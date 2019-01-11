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
        Reader r1 = TestUtils.getReader(clazz, expectedJsonPath);
        Reader r2 = TestUtils.getReader(clazz, actualJsonPath);

        JsonReader expectedJsonReader = new JsonReader(r1);
        JsonReader actualJsonReader = new JsonReader(r2);

        assertJsonsEqual(expectedJsonReader, actualJsonReader);
    }

    public static void assertJsonsEqual(String expectedJson, String actualJson) {
        Reader r1 = new StringReader(expectedJson);
        Reader r2 = new StringReader(actualJson);

        JsonReader expectedJsonReader = new JsonReader(r1);
        JsonReader actualJsonReader = new JsonReader(r2);

        assertJsonsEqual(expectedJsonReader, actualJsonReader);
    }

    public static void assertJsonsEqual(JsonReader expectedJson, JsonReader actualJson) {
        JsonElement el1 = TestUtils.readJson(expectedJson);
        JsonElement el2 = TestUtils.readJson(actualJson);

        if (!el1.equals(el2)) {
            String jsonStr1 = el1.toString();
            String jsonStr2 = el2.toString();
    
            assertEquals(jsonStr1, jsonStr2);
        }
    }

}
