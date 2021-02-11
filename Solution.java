//Time Complexity:O(m+n)
//Space Compelxity: O(1)
package Strings1;
import java.util.HashMap;
import java.util.Map;
public class Solution {
	public static String customSortString(String S, String T) {
		StringBuilder sb = new StringBuilder();  
		//edge case
		if(T == null || T.length() == 0) return sb.toString();
		HashMap<Character,Integer> hs = new HashMap<>();
		for(int i =0;i<T.length();i++) {
			char c = T.charAt(i);
			hs.put(c, hs.getOrDefault(c, 0)+1);
		}
		for(int i=0;i<S.length();i++) {
			char c= S.charAt(i);
			if(hs.containsKey(c)) {
				int count = hs.get(c);
				while(count>0) {
					sb.append(c);
					count--;
				}
				hs.remove(c);
			}
		}
		//System.out.println(hs.entrySet());
		//to append the rest of the characters
		for(Map.Entry<Character,Integer> en : hs.entrySet()) {
			char c = en.getKey();
			int count = en.getValue();
			System.out.println(count);
			while(count>0) {
				sb.append(c);
				count--;
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String s1= "cba";
		String s2 = "abcdde";
		System.out.println(customSortString(s1,s2));
	}
}
