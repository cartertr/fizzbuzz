package com.tomcarter.fizzbuzz.handlers.stage2;

import com.tomcarter.fizzbuzz.Token;
import com.tomcarter.fizzbuzz.handlers.IntHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultipleOrContainsThreeHandlerTest {

    private MultipleOrContainsThreeHandler standaloneMultipleOrContainsThreeHandler;
    private MultipleOrContainsThreeHandler multipleOrContainsThreeHandlerWithNextHandler;


    @Before
    public void setup() {
        this.standaloneMultipleOrContainsThreeHandler = new MultipleOrContainsThreeHandler();

        IntHandler nextHandler = mock(IntHandler.class);
        when(nextHandler.handleInt(anyInt())).thenReturn("Mock");
        this.multipleOrContainsThreeHandlerWithNextHandler = new MultipleOrContainsThreeHandler();
        this.multipleOrContainsThreeHandlerWithNextHandler.setNextHandler(nextHandler);
    }

    @Test
    public void testSubstitutesThree()
    {
        assertEquals(Token.FIZZ.getToken(), standaloneMultipleOrContainsThreeHandler.handleInt(3));
    }

    @Test
    public void testSubstitutesMultipleOfThree()
    {
        assertEquals(Token.FIZZ.getToken(), standaloneMultipleOrContainsThreeHandler.handleInt(9));
    }

    @Test
    public void testDoesNotSubstituteNonMultipleOfThreeWhichDoesNotContainThree()
    {
        assertEquals(String.valueOf(2), standaloneMultipleOrContainsThreeHandler.handleInt(2));
    }

    /**
     * Added to support stage 2 of the exercise
     */
    @Test
    public void testSubstitutesNonMultipleOfThreeButWhichContainsThree()
    {
        assertEquals(Token.FIZZ.getToken(), standaloneMultipleOrContainsThreeHandler.handleInt(13));
    }

    /**
     * This test ensures that the next handler in the chain gets an opportunity to
     * handle this int, in this case we use a mocked next handler
     */
    @Test
    public void testPassesUnhandledIntToNextHandler()
    {
        assertEquals("Mock", multipleOrContainsThreeHandlerWithNextHandler.handleInt(2));
    }
}
