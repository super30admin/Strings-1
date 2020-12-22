//Time Complexity  - O(n)
//Space Complexity - O(n)       
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int slow = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(hmap.containsKey(c)){
                slow = Math.max(slow, hmap.get(c));
            }
            hmap.put(c, i+1);
            max  = Math.max(max, i-slow+1);
        }
        return max;    
    }
}   