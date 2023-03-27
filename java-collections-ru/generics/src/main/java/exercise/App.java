package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN

class App {

    public static <K, V> List<Map<K, V>> findWhere(List<Map<K, V>> books, Map<K, V> where) {
        List<Map<K, V>>  result = new ArrayList<>();
        for (Map<K, V> book: books) {
            if (book.entrySet().containsAll(where.entrySet())) {
                result.add(book);
            }
        }

        return result;
    }
}

//END
