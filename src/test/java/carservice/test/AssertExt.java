package carservice.test;

import static org.junit.Assert.assertEquals;

import java.io.Reader;
import java.io.StringReader;

import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

public class AssertExt {

    private AssertExt() {
    }

    public static void assertJsonFilesEqual(Class<?> clazz, String path1, String path2) {
        Reader r1 = TestUtils.getReader(clazz, path1);
        Reader r2 = TestUtils.getReader(clazz, path2);

        JsonReader jsonReader1 = new JsonReader(r1);
        JsonReader jsonReader2 = new JsonReader(r2);

        JsonElement el1 = TestUtils.readJson(jsonReader1);
        JsonElement el2 = TestUtils.readJson(jsonReader2);

        String jsonStr1 = el1.toString();
        String jsonStr2 = el2.toString();

        assertEquals(jsonStr1, jsonStr2);
    }

    public static void assertJsonsEqual(String json1, String json2) {
        Reader r1 = new StringReader(json1);
        Reader r2 = new StringReader(json2);

        JsonReader jsonReader1 = new JsonReader(r1);
        JsonReader jsonReader2 = new JsonReader(r2);

        JsonElement el1 = TestUtils.readJson(jsonReader1);
        JsonElement el2 = TestUtils.readJson(jsonReader2);

        String jsonStr1 = el1.toString();
        String jsonStr2 = el2.toString();

        assertEquals(jsonStr1, jsonStr2);
    }


}
