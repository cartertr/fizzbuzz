package com.tomcarter.fizzbuzz.handlers;

import java.util.function.Predicate;

/**
 * Abstract superclass of classes which handle ints
 *
 * Can be subclassed to identify which ints can have a token subsituted for them
 */
public abstract class AbstractIntHandler implements IntHandler {

    //Helper predicates to abstract condition logic
    protected Predicate<Integer> isMultipleOf3 = (i) -> i % 3 == 0;
    protected Predicate<Integer> isMultipleOf5 = (i) -> i % 5 == 0;
    protected Predicate<Integer> contains3 = (i) -> String.valueOf(i).contains("3");
    protected Predicate<Integer> contains5 = (i) -> String.valueOf(i).contains("5");

    //Next handler is stored so that if this handler is not appropriate
    //the next one will be given a chance to handle it
    private IntHandler nextHandler;

    public void setNextHandler(IntHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * This method is called if the subclass does not handle this int
     * Passes the int to the next handler in the chain.
     *
     * If the end of the chain is reached then return as a string
     *
     * @param input the input int
     * @return a special token, or a String representation of the input int
     */
    @Override
    public String handleInt(int input) {
        if (nextHandler != null) {
            return nextHandler.handleInt(input);
        }
        return String.valueOf(input);
    }
}
