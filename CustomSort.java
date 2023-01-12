import java.util.HashMap;
import java.util.Map;
//Time Complexity : O(n) 
//Space Complexity : O(n) for hash map and String Builder					
//Did this code successfully run on Leet code :Yes
//Any problem you faced while coding this :
public class CustomSort {
	class Solution {
	    public String customSortString(String order, String s) {
	        Map<Character,Integer> map = new HashMap<>();
	        for(char c:s.toCharArray()){
	            map.put(c,map.getOrDefault(c,0)+1);
	        }
	        StringBuilder sb = new StringBuilder();
	        
	        for(char c :order.toCharArray()){
	            if(map.containsKey(c)){
	                int freq = map.get(c);
	                for(int i=0;i<freq;i++)
	                    sb.append(c);
	                map.remove(c);
	            }
	        }
	        
	        for(char c: map.keySet()){
	            int freq = map.get(c);
	            for(int i=0;i<freq;i++)
	                    sb.append(c);
	        }
	        return sb.toString();
	    }
	}
}
