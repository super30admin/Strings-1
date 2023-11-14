// # Strings-1

// ## Problem1 
// Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                for(int k=0; k<cnt; k++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        for(char c: map.keySet()){
            int cnt = map.get(c);
            for(int k=0; k<cnt; k++){
                sb.append(c);
            }
        }
        return sb.toString();

    }
}

// ## Problem2 

// Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int fast = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                while(s.charAt(slow) != c){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                set.remove(s.charAt(slow));
                slow++;
            }
            set.add(c);
            max = Math.max(max, i-slow+1);
        }
        return max;

    }
}