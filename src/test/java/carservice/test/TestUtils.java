package carservice.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.io.IOUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import carservice.web.common.Constants;

public class TestUtils {

    public static final String ACTIVE_PROFILE = "";

    private TestUtils() {
    }

    public static String getResourceAsString(Class<?> clazz, String resourcePath) {
        try {
            InputStream is = getResourceAsStream(clazz, resourcePath);
            String result = IOUtils.toString(is, Constants.DEFAULT_ENCODING);
            return result;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    static JsonElement readJson(JsonReader in) {
        return new JsonParser().parse(in);
    }

    static Reader getReader(Class<?> clazz, String resourcePath) {
        try {
            InputStream is = getResourceAsStream(clazz, resourcePath);
            InputStreamReader isr = new InputStreamReader(is, Constants.DEFAULT_ENCODING);
            return isr;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static InputStream getResourceAsStream(Class<?> clazz, String resourcePath) {
        String adjustedResourcePath = getAdjustedResourcePath(resourcePath);
        InputStream inputStream = clazz.getResourceAsStream(adjustedResourcePath);
        if (inputStream == null) {
            throw new RuntimeException("Cannot find resource: " + adjustedResourcePath);
        }
        return inputStream;
    }

    private static String getAdjustedResourcePath(String path) {
        return "testdata/" + path;
    }


}
