import java.util.HashMap;
import java.util.Map;
//Time Complexity : O(n)
//Space Complexity : O(n) for hash map					
//Did this code successfully run on Leet code :Yes
//Any problem you faced while coding this :

public class LongestSubstringWithoutRepeatingChar {
	 public int lengthOfLongestSubstring(String s) {
	      Map<Character,Integer> map = new HashMap<>();
	       int max=0;
	       int slow = 0;
	       for(int i=0;i<s.length();i++){
	           char c = s.charAt(i);
	           if(map.containsKey(c) && map.get(c) >=slow){
	              slow = map.get(c)+1;
	           }
	           max = Math.max(max,i -slow+1);  
	           map.put(c,i);
	       } 
	       return max ;
	    }
}
