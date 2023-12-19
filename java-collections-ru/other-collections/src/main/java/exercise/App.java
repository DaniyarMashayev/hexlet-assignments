package exercise;

import java.util.Set;
import java.util.Map;
import java.util.TreeSet;
import java.util.LinkedHashMap;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        Set<String> sortedUnionSet = new TreeSet<>();
        sortedUnionSet.addAll(data1.keySet());
        sortedUnionSet.addAll(data2.keySet());
        for (String key : sortedUnionSet) {
            if (!data1.containsKey(key) && data2.containsKey(key)) {
                result.put(key, "added");
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.put(key, "deleted");
            } else if (data1.containsKey(key) && data2.containsKey(key) && data1.get(key).equals(data2.get(key))) {
                result.put(key, "unchanged");
            } else {
                result.put(key, "changed");
            }
        }
        return result;
    }
}
//END
