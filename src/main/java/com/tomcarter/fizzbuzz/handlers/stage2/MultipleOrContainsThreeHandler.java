package com.tomcarter.fizzbuzz.handlers.stage2;

import com.tomcarter.fizzbuzz.Token;
import com.tomcarter.fizzbuzz.handlers.AbstractIntHandler;
import com.tomcarter.fizzbuzz.handlers.IntHandler;

/**
 * This is an IntHandler class which substitutes the Fizz token for any multiple of 3 or any ints that have 3 in it
 */
public class MultipleOrContainsThreeHandler extends AbstractIntHandler implements IntHandler {

    @Override
    public String handleInt(int input) {
        if (isMultipleOf3.or(contains3).test(input)) {
            return Token.FIZZ.getToken();
        }

        return super.handleInt(input);
    }
}
