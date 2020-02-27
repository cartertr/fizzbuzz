package com.tomcarter.fizzbuzz.handlers.stage1;

import com.tomcarter.fizzbuzz.Token;
import com.tomcarter.fizzbuzz.handlers.AbstractIntHandler;
import com.tomcarter.fizzbuzz.handlers.IntHandler;

/**
 * This is an IntHandler class which substitutes the FizzBuzz token for any multiple of 3 and 5
 */
public class MultipleOfThreeAndFiveHandler extends AbstractIntHandler implements IntHandler {

    @Override
    public String handleInt(int input) {
        //Least common condition first
        if (isMultipleOf5.and(isMultipleOf3).test(input)) {
            return Token.FIZZBUZZ.getToken();
        }

        return super.handleInt(input);
    }
}
