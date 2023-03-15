package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN

class App {

    public static boolean scrabble(String symbols, String word) {
        String[] symbolsArray = symbols.toLowerCase().split("");
        List<String> symbolsList = new ArrayList<String>(Arrays.asList(symbolsArray));

        String[] wordsArray = word.toLowerCase().split("");
        for (String letter : wordsArray) {
            if (symbolsList.contains(letter)) {
                int pos = symbolsList.indexOf(letter);
                symbolsList.remove(pos);
            } else {
                return false;
            }

        }
        return true;
    }
}

//END
