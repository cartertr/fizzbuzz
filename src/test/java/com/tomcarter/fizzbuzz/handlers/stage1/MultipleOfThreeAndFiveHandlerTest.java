package com.tomcarter.fizzbuzz.handlers.stage1;

import com.tomcarter.fizzbuzz.Token;
import com.tomcarter.fizzbuzz.handlers.IntHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultipleOfThreeAndFiveHandlerTest {

    private MultipleOfThreeAndFiveHandler standaloneMultipleOfThreeAndFiveHandler;
    private MultipleOfThreeAndFiveHandler multipleOfThreeAndFiveHandlerWithNextHandler;


    @Before
    public void setup() {
        this.standaloneMultipleOfThreeAndFiveHandler = new MultipleOfThreeAndFiveHandler();

        IntHandler nextHandler = mock(IntHandler.class);
        when(nextHandler.handleInt(anyInt())).thenReturn("Mock");
        this.multipleOfThreeAndFiveHandlerWithNextHandler = new MultipleOfThreeAndFiveHandler();
        this.multipleOfThreeAndFiveHandlerWithNextHandler.setNextHandler(nextHandler);
    }

    @Test
    public void testSubstitutesMultipleOfThreeAndFive()
    {
        assertEquals(Token.FIZZBUZZ.getToken(), standaloneMultipleOfThreeAndFiveHandler.handleInt(15));
    }

    @Test
    public void testDoesNotSubstituteThree()
    {
        assertEquals(String.valueOf(3), standaloneMultipleOfThreeAndFiveHandler.handleInt(3));
    }

    @Test
    public void testDoesNotSubstituteMultpleOfThreeThatIsNotMultipleOfThreeAndFive()
    {
        assertEquals(String.valueOf(9), standaloneMultipleOfThreeAndFiveHandler.handleInt(9));
    }

    @Test
    public void testDoesNotSubstituteFive()
    {
        assertEquals(String.valueOf(5), standaloneMultipleOfThreeAndFiveHandler.handleInt(5));
    }

    @Test
    public void testDoesNotSubstituteMultipleOfFiveThatIsNotMultipleOfThreeAndFive()
    {
        assertEquals(String.valueOf(10), standaloneMultipleOfThreeAndFiveHandler.handleInt(10));
    }

    @Test
    public void testDoesNotSubstituteNonMultipleOfThreeOrFive()
    {
        assertEquals(String.valueOf(2), standaloneMultipleOfThreeAndFiveHandler.handleInt(2));
    }

    /**
     * Added to support stage 2 of the exercise, to ensure no regression in this stage 1 handler
     */
    @Test
    public void testDoesNotSubstituteNonMultipleOfThreeButWhichHasThreeInIt()
    {
        assertEquals(String.valueOf(13), standaloneMultipleOfThreeAndFiveHandler.handleInt(13));
    }

    /**
     * Added to support stage 2 of the exercise, to ensure no regression in this stage 1 handler
     */
    @Test
    public void testDoesNotSubstituteNonMultipleOfFiveButWhichHasFiveInIt()
    {
        assertEquals(String.valueOf(51), standaloneMultipleOfThreeAndFiveHandler.handleInt(51));
    }

    /**
     * This test ensures that the next handler in the chain gets an opportunity to
     * handle this int, in this case we use a mocked next handler
     */
    @Test
    public void testPassesUnhandledIntToNextHandler()
    {
        assertEquals("Mock", multipleOfThreeAndFiveHandlerWithNextHandler.handleInt(2));
    }
}
