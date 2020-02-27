package com.tomcarter.fizzbuzz.handlers.stage1;

import com.tomcarter.fizzbuzz.Token;
import com.tomcarter.fizzbuzz.handlers.AbstractIntHandler;
import com.tomcarter.fizzbuzz.handlers.IntHandler;

/**
 * This is an IntHandler class which substitutes the Buzz token for any multiple of 5
 */
public class MultipleOfFiveHandler extends AbstractIntHandler implements IntHandler {

    @Override
    public String handleInt(int input) {
        if (isMultipleOf5.test(input)) {
            return Token.BUZZ.getToken();
        }

        return super.handleInt(input);
    }
}
