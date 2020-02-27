package com.tomcarter.fizzbuzz;

/**
 * Token enum
 *
 * This enum encapsulates the tokens which can be substituted for numbers in the output
 */
public enum Token {
    FIZZ("Fizz"),
    BUZZ("Buzz"),
    FIZZBUZZ("FizzBuzz");

    private final String token;

    Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
