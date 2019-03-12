package j4fun.countwords;

import java.util.HashMap;
import java.util.Map;

/**
 * @author beou on 3/12/19 15:36
 */
public class WordUtils {
    private Map<String, Integer> wordMap = new HashMap<>();

    public void process(String text) {
        String[] textArr = text.split("\\W+");

        for (int i = 0; i < textArr.length; i++) {
            Integer val = wordMap.get(textArr[i]) != null ? wordMap.get(textArr[i]) : 0;
            wordMap.put(textArr[i], val + 1);
        }
    }

    public void println() {
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue()));
        }
    }
}
