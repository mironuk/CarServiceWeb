package carservice.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.io.IOUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;

import carservice.web.common.Constants;

public class TestUtils {

    public static final String ACTIVE_PROFILE = "";

    private TestUtils() {
    }

    public static String getResourceAsString(Class<?> clazz, String resourcePath) {
        try {
            String adjustedResourcePath = getAdjustedResourcePath(resourcePath);
            InputStream is = clazz.getResourceAsStream(adjustedResourcePath);
            if (is == null) {
                throw new RuntimeException("Cannot find resource: " + adjustedResourcePath);
            }
            String result = IOUtils.toString(is, Constants.DEFAULT_ENCODING);
            return result;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    static JsonElement readJson(JsonReader in) {
        try {
            switch (in.peek()) {
                case NUMBER:
                    return new JsonPrimitive(new LazilyParsedNumber(in.nextString()));
                case BOOLEAN:
                    return new JsonPrimitive(Boolean.valueOf(in.nextBoolean()));
                case STRING:
                    return new JsonPrimitive(in.nextString());
                case NULL:
                    in.nextNull();
                    return JsonNull.INSTANCE;
                case BEGIN_ARRAY:
                    JsonArray array = new JsonArray();
                    in.beginArray();
                    while (in.hasNext()) {
                        array.add(readJson(in));
                    }
                    in.endArray();
                    return array;
                case BEGIN_OBJECT:
                    JsonObject object = new JsonObject();
                    in.beginObject();
                    while (in.hasNext()) {
                        object.add(in.nextName(), readJson(in));
                    }
                    in.endObject();
                    return object;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    static Reader getReader(Class<?> clazz, String resourcePath) {
        try {
            String adjustedResourcePath = getAdjustedResourcePath(resourcePath);
            InputStream is = clazz.getResourceAsStream(adjustedResourcePath);
            if (is == null) {
                throw new RuntimeException("Cannot find resource: " + adjustedResourcePath);
            }
            InputStreamReader isr = new InputStreamReader(is, Constants.DEFAULT_ENCODING);
            return isr;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String getAdjustedResourcePath(String path) {
        return "testdata/" + path;
    }


}
