import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Java Strings, Exceptions, Unit Testing, and Regex.
// https://www.w3schools.com/java/java_regex.asp
//https://www.geeksforgeeks.org/regular-expressions-in-java/


public class JerkSONParser {

    private int errorCount = 0;

    public int getErrorCount() {
        return errorCount;
    }

    private String fieldPattern = "([A-Za-z0-9.]+)";
    private String stringSplitPattern = "([;:^@%*!])";
    private String itemSplitPattern = "((##))";

    private Pattern fieldName = Pattern.compile(fieldPattern);
    Pattern splitter = Pattern.compile(stringSplitPattern);
    Pattern itemSplitter = Pattern.compile(itemSplitPattern);

    


}
