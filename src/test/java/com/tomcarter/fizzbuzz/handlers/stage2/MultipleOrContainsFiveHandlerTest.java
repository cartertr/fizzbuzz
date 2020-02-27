package com.tomcarter.fizzbuzz.handlers.stage2;

import com.tomcarter.fizzbuzz.Token;
import com.tomcarter.fizzbuzz.handlers.IntHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultipleOrContainsFiveHandlerTest {

    private MultipleOrContainsFiveHandler standaloneMultipleOrContainsFiveHandler;
    private MultipleOrContainsFiveHandler multipleOrContainsFiveHandlerWithNextHandler;


    @Before
    public void setup() {
        this.standaloneMultipleOrContainsFiveHandler = new MultipleOrContainsFiveHandler();

        IntHandler nextHandler = mock(IntHandler.class);
        when(nextHandler.handleInt(anyInt())).thenReturn("Mock");
        this.multipleOrContainsFiveHandlerWithNextHandler = new MultipleOrContainsFiveHandler();
        this.multipleOrContainsFiveHandlerWithNextHandler.setNextHandler(nextHandler);
    }

    @Test
    public void testSubstitutesFive()
    {
        assertEquals(Token.BUZZ.getToken(), standaloneMultipleOrContainsFiveHandler.handleInt(5));
    }

    @Test
    public void testSubstitutesMultipleOfFive()
    {
        assertEquals(Token.BUZZ.getToken(), standaloneMultipleOrContainsFiveHandler.handleInt(10));
    }

    @Test
    public void testDoesNotSubstituteNonMultipleOfFiveWhichDoesNotContain5()
    {
        assertEquals(String.valueOf(2), standaloneMultipleOrContainsFiveHandler.handleInt(2));
    }

    /**
     * Added to support stage 2 of the exercise
     */
    @Test
    public void testSubstitutesNonMultipleOfFiveButWhichContainsFive()
    {
        assertEquals(Token.BUZZ.getToken(), standaloneMultipleOrContainsFiveHandler.handleInt(51));
    }

    /**
     * This test ensures that the next handler in the chain gets an opportunity to
     * handle this int, in this case we use a mocked next handler
     */
    @Test
    public void testPassesUnhandledIntToNextHandler()
    {
        assertEquals("Mock", multipleOrContainsFiveHandlerWithNextHandler.handleInt(2));
    }
}
