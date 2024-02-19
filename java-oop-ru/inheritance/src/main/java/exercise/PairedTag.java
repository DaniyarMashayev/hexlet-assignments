package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> children;
    public PairedTag(String tagName, Map<String, String> map, String tagBody, List<Tag> children) {
        super(tagName, map);
        this.tagBody = tagBody;
        this.children = children;
    }

    @Override
    public String toString() {
        String child = children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining(""));
        return String.format("%s%s%s</%s>", super.toString(), child, tagBody, tagName);
    }
}
// END
