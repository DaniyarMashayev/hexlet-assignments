package exercise;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

// BEGIN
class App {
    public static void main(String[] args) {
        List<Map<String, String>> books = new ArrayList<>();
        Map<String, String> book1 = new HashMap<>(Map.of("title", "Cymbeline",
                "author", "Shakespeare", "year", "1611"));
        Map<String, String> book2 = new HashMap<>(Map.of("title", "Book of Fooos",
                "author", "FooBar", "year", "1111"));
        Map<String, String> book3 = new HashMap<>(Map.of("title", "The Tempest",
                "author", "Shakespeare", "year", "1611"));
        Map<String, String> where = new HashMap<>(Map.of("author", "Shakespeare", "year", "1611"));
        books.add(book1);
        books.add(book2);
        books.add(book3);
        findWhere(books, where);
    }

    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> item: books) {
            boolean find = true;
            for (Map.Entry<String, String> entry: where.entrySet()) {
                String itemValue = item.getOrDefault(entry.getKey(), "");
                if (!itemValue.equals(entry.getValue())) {
                    find = false;
                }
            }
            if (find) {
                result.add(item);
            }
        }
        System.out.println(result);
        return result;
    }
}
//END
