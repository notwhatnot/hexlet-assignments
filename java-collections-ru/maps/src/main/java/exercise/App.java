package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN

class App {

    public static Map getWordCount(String sentence) {
        Map <String, Integer>  wordsCount = new HashMap<>();

        if ("".equals(sentence)) {
            return  wordsCount;
        }

        Integer initialValue = 1;

        for (String word : sentence.split(" ")) {
            if (wordsCount.containsKey(word)) {
                wordsCount.replace(word, wordsCount.get(word) + 1);
            } else {
                wordsCount.put(word, initialValue);
            }
        }

        return wordsCount;


    }

    public static String toString(Map<String, Integer> wordsCount) {

        if (wordsCount.isEmpty()) {
            return "{}";
        }

        StringBuilder builder = new StringBuilder();
        String tab = "  ";
        builder.append("{\n");
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            builder.append(tab).append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        builder.append("}");

        return builder.toString();
    }
}
//END
