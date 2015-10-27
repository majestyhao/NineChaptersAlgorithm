package GraphandSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	/**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		   Queue<String> queue = new LinkedList<String>();
		   Set<String> visited = new HashSet<String>();
		   queue.add(beginWord);
		   int count = 1;
		   while (!queue.isEmpty()) {
			   int len = queue.size();
			   count++;
			   for (int i = 0; i < len; i++) {
				   String str = queue.remove();
				   if (visited.contains(str)) {
					   continue;
				   }
				   visited.add(str);
				   for (int j = 0; j < str.length(); j++) {
					   if (addValid(str, j, queue, wordList, endWord, visited)) {
						   return count;
					   }
				   }
			   }
		   }

		   return 0;
	   }

	private String replace(String str, int pos, char c) {
		char[] chars = str.toCharArray();
		chars[pos] = c;
		return new String(chars);
	}

	private boolean addValid(String str, int pos, Queue<String> queue,
							 Set<String> wordList, String endWord, Set<String> visited) {
		for (char i = 'a'; i <= 'z'; i++) {
			if (str.charAt(pos) == i) {
				continue;
			}
			//String newStr = str.substring(0, pos) + i + str.substring(pos + 1, str.length());
			String newStr = replace(str, pos, i);
			if (newStr.equals(endWord)) {
				return true;
			}
			if (wordList.contains(newStr)) {
				queue.add(newStr);
			}
		}

		return false;
	}

}
