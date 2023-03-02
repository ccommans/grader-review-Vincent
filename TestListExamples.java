import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeLeftAllSmallerThanRight() {
    List<String> left = Arrays.asList("A", "B", "C");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("A", "B", "C", "a", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeLeftAllLargeThanRight() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("A", "D");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("A", "D", "a", "b", "c");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeGeneralCase() {
    List<String> left = Arrays.asList("a", "g", "T");
    List<String> right = Arrays.asList("F", "a");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("F", "a", "a", "g", "T");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeEmpty() {
    List<String> left = Arrays.asList();
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList();
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testfilterNoMatch() {
    List<String> input = Arrays.asList("Hello", 
        "Something but moon", "Other thing but mooon");
    List<String> expected = Arrays.asList();
    List<String> result = ListExamples.filter(input, new IsMoon());
    assertEquals(expected, result);
  }

  @Test(timeout = 500)
  public void testfilterEmptyArray() {
    List<String> input = Arrays.asList();
    List<String> expected = Arrays.asList();
    List<String> result = ListExamples.filter(input, new IsMoon());
    assertEquals(expected, result);
  }

  @Test(timeout = 500)
  public void testfilterCapitalCases() {
    List<String> input = Arrays.asList("Hello", 
        "mOoN", "Other thing but mooon");
    List<String> expected = Arrays.asList("mOoN");
    List<String> result = ListExamples.filter(input, new IsMoon());
    assertEquals(expected, result);
  }

  @Test(timeout = 500)
  public void testfilterLowerCases() {
    List<String> input = Arrays.asList("Hello", 
        "moon", "Other thing but mooon");
    List<String> expected = Arrays.asList("moon");
    List<String> result = ListExamples.filter(input, new IsMoon());
    assertEquals(expected, result);
  }

  @Test(timeout = 500)
  public void extraCreditAlwaysRight() {
    assertEquals(1, 1);
  }
}
