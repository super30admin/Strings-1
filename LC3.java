class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0, j = 0; i < s.length() && j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            
            maxLen = Math.max(maxLen, (j - i + 1));
            map.put(s.charAt(j), j + 1);
        }
        return maxLen;
    }
}

//Time : O(n)
//Space : O(1) -> Since English letters, digits, symnbols and spaces would count up to be constant.