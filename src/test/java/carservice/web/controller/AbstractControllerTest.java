package carservice.web.controller;

import org.junit.Assert;
import org.junit.Test;

public class AbstractControllerTest {

    @Test
    public void givenNull_whenTrim_thenNull() {
        String given = null;
        String actual = AbstractController.trim(given);
        Assert.assertNull(actual);
    }

    @Test
    public void givenEmptyString_whenTrim_thenNull() {
        String given = "";
        String actual = AbstractController.trim(given);
        Assert.assertNull(actual);
    }

    @Test
    public void givenStringOfWhiteSpaces_whenTrim_thenNull() {
        String given = " \r\n  \t  ";
        String actual = AbstractController.trim(given);
        Assert.assertNull(actual);
    }

    @Test
    public void givenStringWithLeadingWhiteSpaces_whenTrim_thenStringWithNoLeadingWhiteSpaces() {
        String given = " \r\n  \t test string 1";
        String expected = "test string 1";
        String actual = AbstractController.trim(given);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenStringWithTrailingWhiteSpaces_whenTrim_thenStringWithNoTrailingWhiteSpaces() {
        String given = "test string 2  \r\n  \t ";
        String expected = "test string 2";
        String actual = AbstractController.trim(given);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenStringWithLeadingAndTrailingWhiteSpaces_whenTrim_thenStringWithNoLeadingOrTrailingWhiteSpaces() {
        String given = " \r\n  \t test string 3  \r\n  \t ";
        String expected = "test string 3";
        String actual = AbstractController.trim(given);
        Assert.assertEquals(expected, actual);
    }

}
