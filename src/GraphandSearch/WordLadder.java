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
   public int ladderLength(String start, String end, Set<String> dict) {
	   Queue<String> queue = new LinkedList<String>();
	   queue.add(start);
	   HashSet<String> met = new HashSet<String>();
	   met.add(start);
	   /*HashMap<String, Integer> ladder = new HashMap<String, Integer>();
	   ladder.put(start, 1);*/
	   
	   int ladder = 1;
	   while (!queue.isEmpty()) {
		   ladder++;
		   /*
		   String str = queue.poll();
		   met.put(str, 0);
		   //for (String element : dict) {
		   for (String element : getNext(str, dict)) {
			   if (!met.containsKey(element) && dist(str, element)) {
				   queue.offer(element);
				   if (element.equals(end)) {
					   return ladder.get(str) + 1;
				   }
				   if (!ladder.containsKey(element)) {
					   ladder.put(element, ladder.get(str) + 1);		
				   }
			   }
		   }
	   }
	   
	   return ladder.get(end);*/
		   int size = queue.size();
		   for (int i = 0; i < size; i++) {
			  String str = queue.poll();
			  for (String element : getNext(str, dict)) {
				  if (!met.contains(element)) {
					  if (element.equals(end)) {
						  return ladder;
					  }
					  queue.offer(element);
					  met.add(element);
				  }
			  }
		   }
	   }
	   
	   return 0;
   }
   /*
   private boolean dist(String str1, String str2) {
	   int count = 0;
	   for (int i = 0; i < str1.length(); i++) {
			   if (str1.charAt(i) != str2.charAt(i)) {
				   count++;
			   }
	   }
	   
	   return count == 1;
   }
   */
   private ArrayList<String> getNext(String str, Set<String> dict) {
	   ArrayList<String> result = new ArrayList<String>();
	   for (int i = 0; i < str.length(); i++) {
		   for (char j = 'a'; j <= 'z'; j++) {
			   StringBuilder tmp = new StringBuilder(str);
			   tmp.setCharAt(i, j); 
			   if (dict.contains(tmp.toString())) {
				   result.add(tmp.toString());
			   }
		   }
	   }
	   
	   return result;
   }

}
