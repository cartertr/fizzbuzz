package com.tomcarter.fizzbuzz.handlers.stage2;

import com.tomcarter.fizzbuzz.Token;
import com.tomcarter.fizzbuzz.handlers.AbstractIntHandler;
import com.tomcarter.fizzbuzz.handlers.IntHandler;

/**
 * This is an IntHandler class which substitutes the Buzz token for any multiple of 5 or ints which have 5 in it
 */
public class MultipleOrContainsFiveHandler extends AbstractIntHandler implements IntHandler {

    @Override
    public String handleInt(int input) {
        if (isMultipleOf5.or(contains5).test(input)) {
            return Token.BUZZ.getToken();
        }

        return super.handleInt(input);
    }
}
