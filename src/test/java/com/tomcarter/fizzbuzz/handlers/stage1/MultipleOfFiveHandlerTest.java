package com.tomcarter.fizzbuzz.handlers.stage1;

import com.tomcarter.fizzbuzz.Token;
import com.tomcarter.fizzbuzz.handlers.IntHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultipleOfFiveHandlerTest {

    private MultipleOfFiveHandler standaloneMultipleOfFiveHandler;
    private MultipleOfFiveHandler multipleOfFiveHandlerWithNextHandler;


    @Before
    public void setup() {
        this.standaloneMultipleOfFiveHandler = new MultipleOfFiveHandler();

        IntHandler nextHandler = mock(IntHandler.class);
        when(nextHandler.handleInt(anyInt())).thenReturn("Mock");
        this.multipleOfFiveHandlerWithNextHandler = new MultipleOfFiveHandler();
        this.multipleOfFiveHandlerWithNextHandler.setNextHandler(nextHandler);
    }

    @Test
    public void testSubstitutesFive()
    {
        assertEquals(Token.BUZZ.getToken(), standaloneMultipleOfFiveHandler.handleInt(5));
    }

    @Test
    public void testSubstitutesMultipleOfFive()
    {
        assertEquals(Token.BUZZ.getToken(), standaloneMultipleOfFiveHandler.handleInt(10));
    }

    @Test
    public void testDoesNotSubstituteNonMultipleOfFive()
    {
        assertEquals(String.valueOf(2), standaloneMultipleOfFiveHandler.handleInt(2));
    }

    /**
     * Added to support stage 2 of the exercise, to ensure no regression in this stage 1 handler
     */
    @Test
    public void testDoesNotSubstituteNonMultipleOfFiveButWhichHasFiveInIt()
    {
        assertEquals(String.valueOf(51), standaloneMultipleOfFiveHandler.handleInt(51));
    }

    /**
     * This test ensures that the next handler in the chain gets an opportunity to
     * handle this int, in this case we use a mocked next handler
     */
    @Test
    public void testPassesUnhandledIntToNextHandler()
    {
        assertEquals("Mock", multipleOfFiveHandlerWithNextHandler.handleInt(2));
    }
}
