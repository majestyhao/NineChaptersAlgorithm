package GraphandSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	/**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
   public List<List<String>> findLadders(String start, String end, Set<String> dict) {
	   HashMap<String, Integer> dist = new HashMap<String, Integer>();
	   // backward BFS to calculate distance
	   BFS(end, start, dist, dict);
	   
	   // forward DFS 
	   List<List<String>> result = new ArrayList<List<String>>();
	   List<String> list = new ArrayList<String>();
	   list.add(start);
	   //System.out.println(dist);
	   DFS(start, end, dist, list, result, dict);
	   
	   return result;
   }
   
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
   
   private void BFS(String start, String end, HashMap<String, Integer> dist, Set<String> dict) {
	   int ladder = 1;
	   Queue<String> queue = new LinkedList<String>();
	   queue.add(start);
	   dist.put(start, 1);
	   
	   while(!queue.isEmpty()) {
		   ladder++;
		   int size = queue.size();
		   for (int i = 0; i < size; i++) {
			   String str = queue.poll();
			   for (String neighbor : getNext(str, dict)) {
				   //System.out.println(neighbor);
				   if (!dist.containsKey(neighbor)) {
					   queue.add(neighbor);
					   dist.put(neighbor, ladder);
					   if (neighbor.equals(start)) {
						   return;
					   }
				   }
			   }
		   }
	   }
	   
   }
   
   private void DFS(String start, String end, HashMap<String, Integer> dist, List<String> list,
		   List<List<String>> result, Set<String> dict) {
	   if (start.equals(end)) {
		   System.out.println(list);
		   result.add(new ArrayList<String>(list));
		   return;
	   }
	   for (String neighbor : getNext(start, dict)) {
		   if (!dist.containsKey(neighbor) || dist.get(neighbor) >= dist.get(start)) {
			   continue;
		   }
		   
		   list.add(neighbor);
		   //System.out.println(list);
		   DFS(neighbor, end, dist, list, result, dict);
		   list.remove(list.size() - 1);
	   }
   }

}
