package com.example.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class NetworkClientCallable implements Callable<RequestResponse> {

    private final RequestResponse requestResponse;

    public NetworkClientCallable(RequestResponse requestResponse) {
        this.requestResponse = requestResponse;
    }

    @Override
    public RequestResponse call() throws Exception {
        try (Socket socket = new Socket(requestResponse.host, requestResponse.port);
             Scanner scanner = new Scanner(socket.getInputStream())) {

            StringBuilder responseBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                responseBuilder.append(scanner.nextLine()).append("\n");
            }

            requestResponse.setResponse(responseBuilder.toString());
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
            // Set response to indicate failure, if needed
            requestResponse.setResponse("Error: " + e.getMessage());
        }

        return requestResponse;
    }
}
