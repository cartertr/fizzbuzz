package com.tomcarter.fizzbuzz.handlers.stage2;

import com.tomcarter.fizzbuzz.Token;
import com.tomcarter.fizzbuzz.handlers.AbstractIntHandler;
import com.tomcarter.fizzbuzz.handlers.IntHandler;


/**
 * This is an IntHandler class which substitutes the FizzBuzz token for the following cases :
 *
 * 1) a multiple of both 3 or contains the digit 3
 * AND
 * 2) a multiple of 5 or contains the digit 5
 */
public class MultipleOrContainsThreeAndFiveHandler extends AbstractIntHandler implements IntHandler {

    @Override
    public String handleInt(int input) {

        if ((isMultipleOf3.or(contains3)).and((isMultipleOf5).or(contains5)).test(input)) {
            return Token.FIZZBUZZ.getToken();
        }

        return super.handleInt(input);
    }
}
