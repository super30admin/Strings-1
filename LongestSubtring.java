/*
time complexity: O(n)
space coplexity ; O(1), constant space

*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 ||s == null){
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int maxLen = 0;
        
        for(int right = 0; right < s.length();right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                 left = Math.max(left,map.get(ch));
            }
                 map.put(ch,right+1);
                 maxLen = Math.max(maxLen, right - left +1);
        }
        return maxLen;
    }
}