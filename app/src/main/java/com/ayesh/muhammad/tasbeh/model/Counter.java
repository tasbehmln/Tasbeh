package com.ayesh.muhammad.tasbeh.model;

/**
 * Created by muhammad on 29/07/17.
 */

public class Counter {
    private int counter;

    public Counter() {
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        try {
            testCounter();
        } catch (IllegalArgumentException e) {
            counter = 0;
        } catch (Exception e) {
            counter = 0;
        }
        this.counter = counter;
    }

    private void testCounter() throws IllegalArgumentException {
        if (counter < 0 )
            throw new IllegalArgumentException();
    }
}
