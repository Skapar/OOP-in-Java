package com.example;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        // Comment out the loop that initializes the data array with random values
        // The rest of the code remains the same
        int[] data = new int[1024 * 1024 * 128]; //512MB

        for (int i = 0; i < data.length; i++) {
            data[i] = ThreadLocalRandom.current().nextInt();
        }

        ForkJoinPool pool = new ForkJoinPool();

        // Create a RandomArrayAction instance
        int threshold = data.length / 16; // Example threshold, you may adjust this as needed
        RandomArrayAction randomArrayAction = new RandomArrayAction(data, 0, data.length - 1, threshold);

        // Use ForkJoinPool to invoke the RandomArrayAction task
        pool.invoke(randomArrayAction);

        // Now the array 'data' is initialized with random values

        FindMaxTask task = new FindMaxTask(data, 0, data.length - 1, threshold);
        Integer result = pool.invoke(task);
        System.out.println("Max value found:" + result);
    }
}
