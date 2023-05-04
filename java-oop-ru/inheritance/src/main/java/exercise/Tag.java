package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {

    private String tagName;
    private Map<String, String> tagAttributes;

    public Tag(String tagName, Map<String, String> tagAttributes) {
        this.tagName = tagName;
        this.tagAttributes = tagAttributes;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Map<String, String> getTagAttributes() {
        return tagAttributes;
    }

    public void setTagAttributes(Map<String, String> tagAttributes) {
        this.tagAttributes = tagAttributes;
    }

    public abstract String toString();

    protected String getTagAttributesAsString(Map<String, String> tagAttributes) {
        return tagAttributes.keySet().stream()
                .map(key -> " " + key + "=\"" + tagAttributes.get(key) + "\"")
                .collect(Collectors.joining(""));
    }
}
// END
