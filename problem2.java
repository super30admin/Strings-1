class longestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            max = Math.max(max, i - slow + 1);
            map.put(c, i + 1);
        }
        
        return max;
    }
}

//time complexity O(n) where n is length of string
//space complexity O(1)