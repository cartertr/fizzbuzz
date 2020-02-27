package com.tomcarter.fizzbuzz.handlers.stage1;

import com.tomcarter.fizzbuzz.Token;
import com.tomcarter.fizzbuzz.handlers.AbstractIntHandler;
import com.tomcarter.fizzbuzz.handlers.IntHandler;

/**
 * This is an IntHandler class which substitutes the Fizz token for any multiple of 3
 */
public class MultipleOfThreeHandler extends AbstractIntHandler implements IntHandler {

    @Override
    public String handleInt(int input) {
        if (isMultipleOf3.test(input)) {
            return Token.FIZZ.getToken();
        }

        return super.handleInt(input);
    }
}
