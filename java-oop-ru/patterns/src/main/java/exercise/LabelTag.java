package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String tag;
    private TagInterface inputTag;

    public LabelTag(String tag, TagInterface inputTag) {
        this.tag = tag;
        this.inputTag = inputTag;
    }

    @Override
    public String render() {
        return "<label>" + tag + inputTag.render() + "</label>";
    }
}
// END
