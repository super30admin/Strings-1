package s30.Strings-1;

public class problem2 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            //TC:- O(n)
            //SC:- O(n)
            if(s==null || s.length() == 0) return 0;
            
            int max = 0;
            int slow = 0;
            HashMap<Character,Integer> hm = new HashMap<>();
            
            for(int i=0; i< s.length(); i++){
                char c = s.charAt(i);
                if(hm.containsKey(c)){
                    slow = Math.max(slow, hm.get(c));
                }
                hm.put(c, i + 1);
                max = Math.max(max, i - slow + 1);
            } 
            return max;
        }
    }
}
