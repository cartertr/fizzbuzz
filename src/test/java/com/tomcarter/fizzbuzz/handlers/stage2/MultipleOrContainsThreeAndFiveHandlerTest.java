package com.tomcarter.fizzbuzz.handlers.stage2;

import com.tomcarter.fizzbuzz.Token;
import com.tomcarter.fizzbuzz.handlers.IntHandler;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultipleOrContainsThreeAndFiveHandlerTest {

    private MultipleOrContainsThreeAndFiveHandler standaloneMultipleOrContainsThreeAndFiveHandler;
    private MultipleOrContainsThreeAndFiveHandler multipleOrContainsThreeAndFiveHandlerWithNextHandler;


    @Before
    public void setup() {
        this.standaloneMultipleOrContainsThreeAndFiveHandler = new MultipleOrContainsThreeAndFiveHandler();

        IntHandler nextHandler = mock(IntHandler.class);
        when(nextHandler.handleInt(anyInt())).thenReturn("Mock");
        this.multipleOrContainsThreeAndFiveHandlerWithNextHandler = new MultipleOrContainsThreeAndFiveHandler();
        this.multipleOrContainsThreeAndFiveHandlerWithNextHandler.setNextHandler(nextHandler);
    }

    @Test
    public void testSubstitutesMultipleOfThreeAndFive()
    {
        assertEquals(Token.FIZZBUZZ.getToken(), standaloneMultipleOrContainsThreeAndFiveHandler.handleInt(15));
    }

    @Test
    public void testDoesNotSubstituteThree()
    {
        assertEquals(String.valueOf(3), standaloneMultipleOrContainsThreeAndFiveHandler.handleInt(3));
    }

    @Test
    public void testDoesNotSubstituteFive()
    {
        assertEquals(String.valueOf(5), standaloneMultipleOrContainsThreeAndFiveHandler.handleInt(5));
    }

    @Test
    public void testSubstitutesMultipleOfThreeContainingFive() {
        assertEquals(Token.FIZZBUZZ.getToken(), standaloneMultipleOrContainsThreeAndFiveHandler.handleInt(51));
    }

    @Test
    public void testSubstitutesMultipleOfFiveContainingThree() {
        assertEquals(Token.FIZZBUZZ.getToken(), standaloneMultipleOrContainsThreeAndFiveHandler.handleInt(30));
    }

    @Test
    public void testSubstitutesContainingThreeAndFiveButNotAMultipleOfEither() {
        assertEquals(Token.FIZZBUZZ.getToken(), standaloneMultipleOrContainsThreeAndFiveHandler.handleInt(53));
    }

    @Test
    public void testDoesNotSubstituteMultipleOfFiveThatIsNotMultipleOfThreeAndFive()
    {
        assertEquals(String.valueOf(10), standaloneMultipleOrContainsThreeAndFiveHandler.handleInt(10));
    }

    @Test
    public void testDoesNotSubstituteNonMultipleOfThreeOrFiveWhichDoesNotContainThreeOrFive()
    {
        assertEquals(String.valueOf(2), standaloneMultipleOrContainsThreeAndFiveHandler.handleInt(2));
    }

    /**
     * This test ensures that the next handler in the chain gets an opportunity to
     * handle this int, in this case we use a mocked next handler
     */
    @Test
    public void testPassesUnhandledIntToNextHandler()
    {
        assertEquals("Mock", multipleOrContainsThreeAndFiveHandlerWithNextHandler.handleInt(2));
    }
}
