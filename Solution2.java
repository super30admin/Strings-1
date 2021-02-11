package Strings1;
import java.util.HashMap;
//Time Complexity:O(N)
//Space Complexity: O(1)
public class Solution2 {
	public static int lengthOfLongestSubstring(String s) {
		//edge case
		if(s.length() == 0 || s == null)return 0;
		int max =0;			//to count maximum length
		int low = 0;		//set a low pointer
		HashMap<Character, Integer> hs = new HashMap<>();		
		for(int i =0;i<s.length();i++) {
			char c = s.charAt(i);
			if(hs.containsKey(c)) {
				low = Math.max(low,hs.get(c));
			}
			max = Math.max(max,i-low+1);		//change max
			hs.put(c,i+1);
		}
		return max;			
		
	}
	public static void main(String[] args) {
		String s1 = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s1));
	}
}
