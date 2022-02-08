package strings1;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
	//Time Complexity : O(m+n), where m is the length of order string,n of s string
	//Space Complexity : O(n), string s
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public String customSortString(String order, String s) {
        Map<Character, Integer> count = new HashMap<>();
        
        for(char c: s.toCharArray())
            count.put(c, count.getOrDefault(c, 0) + 1);
        
        StringBuilder res = new StringBuilder();
        for(char c: order.toCharArray()) {
            if(count.containsKey(c)) {
                int cnt = count.get(c);
                for(int i=0; i<cnt; i++)
                    res.append(c);
                count.remove(c);
            }
        }
        
        for(char c: count.keySet()) {
            int cnt = count.get(c);
            for(int i=0; i<cnt; i++)
                res.append(c);
        }
        
        return res.toString();
    }
}
