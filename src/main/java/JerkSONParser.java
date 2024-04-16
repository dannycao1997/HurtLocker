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

    private String fieldPattern = "([\\w]+)([:@^*%!])([\\w\\.\\/]+)";
    private String itemSplitPattern = "##";

    private Pattern fieldPatternCompiled = Pattern.compile(fieldPattern);
    private Pattern itemSplitter = Pattern.compile(itemSplitPattern);

    private ArrayList<GroceryItems> listOfGroceryItems = new ArrayList<>();

    public ArrayList<GroceryItems> getListOfGroceryItems() {
        return listOfGroceryItems;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void parse(String input) {
        String[] items = itemSplitter.split(input);
        for (String item : items) {
            try {
                Matcher matcher = fieldPatternCompiled.matcher(item);
                String name = "";
                String price = "blank";
                while (matcher.find()) {
                    String key = matcher.group(1).toLowerCase();
                    String separator = matcher.group(2);
                    String value = matcher.group(3);
                    if (key.equals("name")) {
                        name = value;
                    } else if (key.equals("price")) {
                        price = value;
                    }
                }
                listOfGroceryItems.add(new GroceryItems(name, price));
            } catch (Exception e) {
                errorCount++;
            }
        }
    }

    public String itemCounter(String itemName) {
        StringBuilder itemChart = new StringBuilder();
        LinkedHashMap<String, Integer> priceCounter = new LinkedHashMap<>();
        int itemCount = 0;

        for (GroceryItems item : listOfGroceryItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemCount++;
                priceCounter.put(item.getPrice(), priceCounter.getOrDefault(item.getPrice(), 0) + 1);
            }
        }

        itemChart.append("name:\t").append(itemName).append("\t\tseen: ").append(itemCount).append(" times\n");
        itemChart.append("=============\t\t=============\n");
        int counter = 0;

        for (String key : priceCounter.keySet()) {
            itemChart.append("Price:\t").append(key).append("\t\tseen: ").append(priceCounter.get(key)).append(" times\n");
            if (counter == 0) {
                itemChart.append("-------------\t\t-------------\n");
            }
            counter++;
        }
        return itemChart.toString();
    }
}
