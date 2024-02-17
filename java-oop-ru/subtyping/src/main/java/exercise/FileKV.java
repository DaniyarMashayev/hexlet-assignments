package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String file;
    private final Map<String, String> map;

    public FileKV(String file, Map<String, String> map) {
        this.file = file;
        this.map = new HashMap<>(map);
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);

    }

    @Override
    public void unset(String key) {
        map.remove(key);

    }

    @Override
    public String get(String key, String defaultValue) {
        return  map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(map);
    }
}
// END
