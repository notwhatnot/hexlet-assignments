package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    private String tagBody;
    private List<Tag> childrenTag;

    public PairedTag(String tagName, Map<String, String> tagAttributes, String tagBody, List<Tag> childrenTag) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.childrenTag = childrenTag;
    }

    @Override
    public String toString() {
        String childrenTagAsString = childrenTag.stream()
                .map(Tag::toString)
                .collect(Collectors.joining(""));
        return String.format("<%s%s>%s%s</%s>", getTagName(), getTagAttributesAsString(getTagAttributes()),
                tagBody, childrenTagAsString, getTagName());
    }
}
// END
