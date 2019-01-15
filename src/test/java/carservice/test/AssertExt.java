package carservice.test;

import static org.junit.Assert.assertEquals;

import java.io.Reader;
import java.io.StringReader;

import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

public class AssertExt {

    private AssertExt() {
    }

    public static void assertJsonFilesEqual(Class<?> clazz, String expectedJsonPath, String actualJsonPath) {
        Reader expectedReader = TestUtils.getReader(clazz, expectedJsonPath);
        Reader actualReader = TestUtils.getReader(clazz, actualJsonPath);

        assertJsonsEqual(expectedReader, actualReader);
    }

    public static void assertJsonsEqual(String expectedJson, String actualJson) {
        Reader expectedReader = new StringReader(expectedJson);
        Reader actualReader = new StringReader(actualJson);

        assertJsonsEqual(expectedReader, actualReader);
    }

    public static void assertJsonsEqual(Reader expectedJson, Reader actualJson) {
        JsonReader expectedJsonReader = new JsonReader(expectedJson);
        JsonReader actualJsonReader = new JsonReader(actualJson);

        JsonElement el1 = TestUtils.readJson(expectedJsonReader);
        JsonElement el2 = TestUtils.readJson(actualJsonReader);

        if (!el1.equals(el2)) {
            String jsonStr1 = el1.toString();
            String jsonStr2 = el2.toString();
    
            assertEquals(jsonStr1, jsonStr2);
        }
    }

}
