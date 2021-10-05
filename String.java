import java.util.*;
public class String{
    // time compexity : 2N + M
    // space complexity : N
    // did it run on leetcode : yes
    // any doubts : no 
    //https://leetcode.com/problems/custom-sort-string/submissions/
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for(int i =0;i<order.length();i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count > 0){
                    result.append(c);
                    count--;
                }
                map.remove(c);
            }
            
        }
        
        for(Character c : map.keySet()){
             int count = map.get(c);
                while(count > 0){
                    result.append(c);
                    count--;
                }
        }
        
        return result.toString();
        
    }
     // time compexity : N
    // space complexity : N
    // did it run on leetcode : yes
    // any doubts : no 
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
    public int lengthOfLongestSubstring(String s) {
		int slow = 0;
        int max =0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow,map.get(c));
            }
            max = Math.max(max,i-slow+1);
            map.put(c,i+1);
            
        }
    
        return max;
	 }
}