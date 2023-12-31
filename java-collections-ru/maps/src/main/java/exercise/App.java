package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        if (sentence.isEmpty()) {
            Map<String, Integer> empty = new HashMap<String, Integer>();
            return empty;
        }
        String[] words = sentence.split(" ");
        HashMap<String, Integer> wordsCount = new HashMap<>();
        for (String word : words) {
            int count = wordsCount.getOrDefault(word, 0);
            wordsCount.put(word, count + 1);
        }
        return wordsCount;
    }

    public static String toString(Map<String, Integer> wordsCount) {
        if (wordsCount.isEmpty()) {
            return "{}";
        }
        var entries = wordsCount.entrySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (var entry : entries) {
            stringBuilder.append('\n' + "  ").append(entry.getKey()).append(":").append(" ").append(entry.getValue());
        }
        return  "{" + stringBuilder + '\n' + "}";
    }
}
//END
