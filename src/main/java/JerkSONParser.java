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

    private String fieldPattern = "([\\w]+)([:@^*%!])([\\w\\.]+)";
    private String itemSplitPattern = "##";

    private Pattern fieldPatternComiled = Pattern.compile(fieldPattern);
    private Pattern itemSplitter = Pattern.compile(itemSplitPattern);

    private ArrayList<GroceryItems> listOfGroceryItems = new ArrayList<GroceryItems>();

    public ArrayList<GroceryItems> getListOfItems() {
        return listOfGroceryItems;
    }

    public int getErrorCount() {
        return errorCount;
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

        itemChart.append("name:\t" + string + "\t\t" + "seen: " + stringCount + " times\n");
        itemChart.append("=============\t\t=============\n");
        int counter = 0;
        for (String key : priceCounter.keySet()) {
            itemChart.append("Price:\t" + key + "\t\t" + "seen: " + priceCounter.get(key) + " times");
            if (counter == 0) {
                itemChart.append("\n-------------\t\t-------------\n");
            }
            counter++;
        }

        return itemChart.toString();
    }
}
