package com.tomcarter.fizzbuzz;

import com.tomcarter.fizzbuzz.handlers.stage1.MultipleOfFiveHandler;
import com.tomcarter.fizzbuzz.handlers.stage1.MultipleOfThreeAndFiveHandler;
import com.tomcarter.fizzbuzz.handlers.stage1.MultipleOfThreeHandler;

import java.util.stream.IntStream;

/**
 * This class runs stage 1 of the exercise
 */
public class FizzBuzzStage1Runner {
    public static void main(String[] args) {
        //Set up chain of responsibiity
        //First is the three and five handler
        MultipleOfThreeAndFiveHandler multipleOfThreeAndFiveHandler = new MultipleOfThreeAndFiveHandler();
        MultipleOfThreeHandler multipleOf3Handler = new MultipleOfThreeHandler();
        MultipleOfFiveHandler multipleOf5Handler = new MultipleOfFiveHandler();
        multipleOfThreeAndFiveHandler.setNextHandler(multipleOf3Handler);
        multipleOf3Handler.setNextHandler(multipleOf5Handler);

        //Stream through the ints to give desired output
        IntStream.rangeClosed(1, 100).mapToObj(multipleOfThreeAndFiveHandler::handleInt).forEach(System.out::println);
    }
}
