package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
        swapKeyValue(storage);
        System.out.println(storage.get("key", "default"));
    }
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> map = storage.toMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            storage.set(entry.getValue(), entry.getKey());
            storage.unset(entry.getKey());
        }
//        map.forEach((key, value) -> {
//            swappedMap.put(value, key);
//        });
//        KeyValueStorage swappedStorage = new InMemoryKV(swappedMap);
    }
}
// END
