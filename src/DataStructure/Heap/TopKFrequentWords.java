package DataStructure.Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by hao on 15-12-14.
 */
public class TopKFrequentWords {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        PriorityQueue<Element> pq = new PriorityQueue<>(1, new ElementComparator());
        for (String word : map.keySet()) {
            pq.add(new Element(word, map.get(word)));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        String[] res = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll().word;
        }

        return res;
    }

    class Element {
        String word;
        int freq;
        Element(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    class ElementComparator implements Comparator<Element> {
        public int compare(Element a, Element b) {
            if (a.freq != b.freq) {
                return a.freq - b.freq;
            } else {
                return b.word.compareTo(a.word);
            }
        }
    }
}
