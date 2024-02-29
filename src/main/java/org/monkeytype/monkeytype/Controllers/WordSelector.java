package org.monkeytype.monkeytype.Controllers;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordSelector {
    private static final int NUM_WORDS_TO_SELECT = 100;

    public static String mainWordSelector() {

        List<String> englishWords = loadEnglishWords("base.json");

        List<String> selectedWords = selectRandomWords(englishWords, NUM_WORDS_TO_SELECT);

        String str = String.join(" ", selectedWords);
        return str;
    }

    private static List<String> loadEnglishWords(String filePath) {
        List<String> englishWords = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {
            String[] wordsArray = new Gson().fromJson(reader, String[].class);
            for (String word : wordsArray) {
                englishWords.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return englishWords;
    }

    private static List<String> selectRandomWords(List<String> words, int numWords) {
        List<String> selectedWords = new ArrayList<>(words);
        Collections.shuffle(selectedWords);
        return selectedWords.subList(0, numWords);
    }
}
