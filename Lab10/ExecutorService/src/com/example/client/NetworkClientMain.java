package com.example.client;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.*;

public class NetworkClientMain {

    public static void main(String[] args) {
        // Comment out the main method
    }

    // Obtain an ExecutorService that reuses a pool of cached threads
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    // Create a map that will be used to tie a request to a future response
    private static final Map<RequestResponse, Future<RequestResponse>> callables = new HashMap<>();

    static {
        // Code a loop that will create NetworkClientCallable for each network request
        // The servers should be running on localhost, ports 10000-10009
        for (int port = 10000; port < 10010; port++) {
            RequestResponse request = new RequestResponse("localhost", port);
            NetworkClientCallable callable = new NetworkClientCallable(request);
            Future<RequestResponse> future = executorService.submit(callable);
            callables.put(request, future);
        }
    }

    // Shut down ExecutorService
    static {
        executorService.shutdown();
    }

    // Await termination of all threads within the ExecutorService for 5 seconds
    static {
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    // Loop through the Future objects stored in the Map created in prev step
    // Print out the server's response or an error message with the server details if there was a problem communicating with a server
    static {
        for (Map.Entry<RequestResponse, Future<RequestResponse>> entry : callables.entrySet()) {
            RequestResponse request = entry.getKey();
            Future<RequestResponse> future = entry.getValue();
            try {
                RequestResponse response = future.get();
                System.out.println(request.host + ":" + request.port + " " + response.response);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error talking to " + request.host + ":" + request.port);
            }
        }
    }
}
