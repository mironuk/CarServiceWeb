package carservice.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.Reader;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

public class TestUtilsTest {

    @Test
    public void givenResource_whenGetResourceAsString_thenSuccess() {
        // Arrange
        String expectedContent = "Line1\nLine2";

        // Act
        String content = TestUtils.getResourceAsString(TestUtilsTest.class, "test.txt");

        // Assert
        assertEquals(expectedContent, content);
    }

    @Test(expected=RuntimeException.class)
    public void givenNoResource_whenGetResourceAsString_thenException() {
        // Act
        TestUtils.getResourceAsString(TestUtilsTest.class, "nosuchresource");
    }

    @Test
    public void givenResource_whenGetReader_thenSuccess() {
        // Arrange
        Reader reader = TestUtils.getReader(TestUtilsTest.class, "get_reader.txt");

        // Act
        Assert.assertNotNull(reader);
    }

    @Test(expected=RuntimeException.class)
    public void givenNoResource_whenGetReader_thenSuccess() {
        // Act
        TestUtils.getReader(TestUtilsTest.class, "nosuchresource");
    }

    @Test
    public void testReadJson() {
        // Arrange
        JsonReader reader = new JsonReader(TestUtils.getReader(TestUtilsTest.class, "json_test.json"));

        // Act
        JsonElement el = TestUtils.readJson(reader);

        // Assert
        assertNotNull(el);
    }

}
