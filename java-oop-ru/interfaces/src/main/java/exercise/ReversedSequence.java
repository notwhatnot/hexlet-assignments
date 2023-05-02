package exercise;

// BEGIN
class ReversedSequence implements CharSequence {

    String text;

    ReversedSequence(String text) {
        this.text = reverseText(text);
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        return text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return text.subSequence(start, end);
    }

    @Override
    public String toString() {
        return text;
    }

    private String reverseText(String text) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(text);
        stringBuilder.reverse();

        return stringBuilder.toString();

    }

}
// END
