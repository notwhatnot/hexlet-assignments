package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;


class ReversedSequenceTest {

    @Test
    void testLength() {
        CharSequence text = new ReversedSequence("abcdef");
        int result = text.length();
        int expected = 6;

        assertThat(result).isEqualTo(expected);
    }


    @Test
    void testToString() {
        CharSequence text = new ReversedSequence("abcdef");
        String result = text.toString();
        String expected = "fedcba";

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testCharAt() {
        CharSequence text = new ReversedSequence("abcdef");

        char result = text.charAt(1);
        char expected = 'e';

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testSubSequence() {
        CharSequence text = new ReversedSequence("abcdef");

        String result = text.subSequence(1, 4).toString();
        String expected = "edc";

        assertThat(result).isEqualTo(expected);
    }


}