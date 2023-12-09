package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String characterSet, String word) {
        String[] characterSetArray = characterSet.toLowerCase().split("");
        String[] wordArray = word.toLowerCase().split("");
        List<String>  characterSetList = new ArrayList<>(Arrays.asList(characterSetArray));
        List<String> wordList = Arrays.asList(wordArray);
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < wordArray.length; i++) {
            if (characterSetList.contains(wordList.get(i))) {
                characterSetList.remove(wordList.get(i));
                resultList.add(wordList.get(i));
            }
        }
        return resultList.equals(wordList);
    }
}
//END
