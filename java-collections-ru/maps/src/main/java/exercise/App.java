package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        String[] words = sentence.split(" ");
        HashMap<String, Integer> wordsFrequency = new HashMap<>();
        for (String word : words) {
            if (wordsFrequency.containsKey(word)) {
                int count = wordsFrequency.get(word);
                wordsFrequency.put(word, count + 1);
            } else {
                wordsFrequency.put(word, 1);
            }
        }
        return wordsFrequency;
    }
}
//END
