package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> map;
    private String key;
    private String value;
    public InMemoryKV(Map<String, String> map) {
        this.map = new HashMap<>(map);
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(map);
    }
}
// END
