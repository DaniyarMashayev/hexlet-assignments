package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    public String tagName;
    public Map<String, String> map;

    public Tag(String tagName, Map<String, String> map) {
        this.tagName = tagName;
        this.map = map;
    }

    public String toString() {
        String attr = map.entrySet().stream()
                .map(a -> String.format(" %s=\"%s\"", a.getKey(), a.getValue()))
                .collect(Collectors.joining(""));
        return String.format("<%s%s>", tagName, attr);
    }
}
// END
