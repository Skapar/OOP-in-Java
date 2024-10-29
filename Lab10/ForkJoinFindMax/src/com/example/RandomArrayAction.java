package com.example;

import java.util.concurrent.RecursiveAction;

public class RandomArrayAction extends RecursiveAction {
    private final int threshold;
    private final int[] myArray;
    private int start;
    private int end;

    // Constructor
    public RandomArrayAction(int[] myArray, int start, int end, int threshold) {
        this.myArray = myArray;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    // Override compute method
    @Override
    protected void compute() {
        if (end - start < threshold) {
            // Initialize array
        } else {
            // Split array and create new RandomArrayAction instances
            int midway = (start + end) / 2;
            RandomArrayAction r1 = new RandomArrayAction(myArray, start, midway, threshold);
            RandomArrayAction r2 = new RandomArrayAction(myArray, midway + 1, end, threshold);
            invokeAll(r1, r2);
        }
    }
}
