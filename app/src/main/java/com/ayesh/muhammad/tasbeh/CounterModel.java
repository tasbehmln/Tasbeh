package com.ayesh.muhammad.tasbeh;

/**
 * Created by muhammad on 29/07/17.
 */

public class CounterModel {
    private int counter;

    public CounterModel() {
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
