package com.tomcarter.fizzbuzz.handlers.stage1;

import com.tomcarter.fizzbuzz.Token;
import com.tomcarter.fizzbuzz.handlers.IntHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultipleOfThreeHandlerTest {

    private MultipleOfThreeHandler standaloneMultipleOfThreeHandler;
    private MultipleOfThreeHandler multipleOfThreeHandlerWithNextHandler;


    @Before
    public void setup() {
        this.standaloneMultipleOfThreeHandler = new MultipleOfThreeHandler();

        IntHandler nextHandler = mock(IntHandler.class);
        when(nextHandler.handleInt(anyInt())).thenReturn("Mock");
        this.multipleOfThreeHandlerWithNextHandler = new MultipleOfThreeHandler();
        this.multipleOfThreeHandlerWithNextHandler.setNextHandler(nextHandler);
    }

    @Test
    public void testSubstitutesThree()
    {
        assertEquals(Token.FIZZ.getToken(), standaloneMultipleOfThreeHandler.handleInt(3));
    }

    @Test
    public void testSubstitutesMultipleOfThree()
    {
        assertEquals(Token.FIZZ.getToken(), standaloneMultipleOfThreeHandler.handleInt(9));
    }

    @Test
    public void testDoesNotSubstituteNonMultipleOfThree()
    {
        assertEquals(String.valueOf(2), standaloneMultipleOfThreeHandler.handleInt(2));
    }

    /**
     * Added to support stage 2 of the exercise, to ensure no regression in this stage 1 handler
     */
    @Test
    public void testDoesNotSubstituteNonMultipleOfThreeButWhichHasThreeInIt()
    {
        assertEquals(String.valueOf(13), standaloneMultipleOfThreeHandler.handleInt(13));
    }

    /**
     * This test ensures that the next handler in the chain gets an opportunity to
     * handle this int, in this case we use a mocked next handler
     */
    @Test
    public void testPassesUnhandledIntToNextHandler()
    {
        assertEquals("Mock", multipleOfThreeHandlerWithNextHandler.handleInt(2));
    }
}
