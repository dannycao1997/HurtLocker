import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    private ArrayList<GroceryItems> listOfGroceryItems = new ArrayList<GroceryItems>();

    public ArrayList<GroceryItems> getListOfItems() {
        return listOfGroceryItems;
    }

    public String[] stringSplitting(String string) {
        String[] splitStrings = string.split(stringSplitPattern);
        return splitStrings;
    }

    public String itemCounter(String string) {
        StringBuilder itemChart = new StringBuilder();
        LinkedHashMap<String, Integer> priceCounter = new LinkedHashMap<>();
        int stringCount = 0;
        for (GroceryItems item : listOfGroceryItems) {
            if (item.getName().equals(string)) {
                stringCount++;
                if (priceCounter.containsKey(GroceryItems.getPrice())) {
                    priceCounter.put(GroceryItems.getPrice(), priceCounter.get(GroceryItems.getPrice()) + 1);
                } else if (GroceryItems.getPrice().equals("blank")) {
                    stringCount--;
                } else {
                    priceCounter.put(GroceryItems.getPrice(), 1);
                }
            }
            
        }
    }
