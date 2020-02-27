package com.tomcarter.fizzbuzz.handlers;

/**
 * IntHandler interface
 *
 * This interface is used to handle an int
 */
public interface IntHandler {

    /**
     * handleInt method.
     *
     * This method can be implemented to check if this int is handled by this class
     * and if necessary substitue an alternative token
     *
     * @param input the original int
     * @return a String representation of the original int, or a special token
     */
    public String handleInt(int input);
}
