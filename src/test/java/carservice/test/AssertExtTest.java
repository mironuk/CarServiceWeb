package carservice.test;

import org.junit.ComparisonFailure;
import org.junit.Test;

public class AssertExtTest {

    @Test
    public void givenEqualJsons_whenAssertJsonFilesEqual_thenSuccess() {
        AssertExt.assertJsonFilesEqual(AssertExtTest.class, "f1.json", "f2.json");
    }

    @Test(expected = ComparisonFailure.class)
    public void givenUnequalJsons_whenAssertJsonFilesEqual_thenComparisonFailure() {
        AssertExt.assertJsonFilesEqual(AssertExtTest.class, "f1.json", "f3.json");
    }

    @Test
    public void givenEqualJsons_whenAssertJsonsEqual_thenSuccess() {
        // Arrange
        String json1 = TestUtils.getResourceAsString(AssertExtTest.class, "f1.json");
        String json2 = TestUtils.getResourceAsString(AssertExtTest.class, "f1.json");

        // Act & Assert
        AssertExt.assertJsonsEqual(json1, json2);
    }

    @Test(expected = ComparisonFailure.class)
    public void givenUnequalJsons_whenAssertJsonsEqual_thenComparisonFailure() {
        // Arrange
        String json1 = TestUtils.getResourceAsString(AssertExtTest.class, "f1.json");
        String json2 = TestUtils.getResourceAsString(AssertExtTest.class, "f3.json");

        // Act & Assert
        AssertExt.assertJsonsEqual(json1, json2);
    }


}
