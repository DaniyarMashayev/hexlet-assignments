package exercise;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
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
        return result;
    }
}
//END
