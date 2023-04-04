package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    public void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int n = 2;
        List<Integer> numbers1Result = App.take(numbers1, n);
        List<Integer> localResult = numbers1.subList(0, n);
        assertThat(numbers1Result).containsExactlyElementsOf(localResult);

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        n = 8;
        List<Integer> numbers2Result = App.take(numbers2, n);
        assertThat(numbers2Result).containsExactlyElementsOf(numbers2);
        // END
    }
}
