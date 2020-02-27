package com.tomcarter.fizzbuzz;

import com.tomcarter.fizzbuzz.handlers.stage2.MultipleOrContainsFiveHandler;
import com.tomcarter.fizzbuzz.handlers.stage2.MultipleOrContainsThreeAndFiveHandler;
import com.tomcarter.fizzbuzz.handlers.stage2.MultipleOrContainsThreeHandler;

import java.util.stream.IntStream;

/**
 * This class will run stage 2 of the exercise
 */
public class FizzBuzzStage2Runner {
    public static void main(String[] args) {
        //Set up chain of responsibiity
        //First is the three and five handler
        MultipleOrContainsThreeAndFiveHandler multipleOrContainsThreeAndFiveHandler = new MultipleOrContainsThreeAndFiveHandler();
        MultipleOrContainsThreeHandler multipleOrContains3Handler = new MultipleOrContainsThreeHandler();
        MultipleOrContainsFiveHandler multipleOrContains5Handler = new MultipleOrContainsFiveHandler();
        multipleOrContainsThreeAndFiveHandler.setNextHandler(multipleOrContains3Handler);
        multipleOrContains3Handler.setNextHandler(multipleOrContains5Handler);

        //Stream through the ints to get desired output
        IntStream.rangeClosed(1, 100).mapToObj(multipleOrContainsThreeAndFiveHandler::handleInt).forEach(System.out::println);
    }
}
