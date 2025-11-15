class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int start = 0, max = 0;

        Map<Character, Integer> indexMap = new HashMap<>();

        for (int i=0; i<s.length(); i++) {

            char c = s.charAt(i);
            if (indexMap.containsKey(c) && indexMap.get(c) >= start) {

                start = indexMap.get(c) + 1;

            } 
            indexMap.put(c, i);

            max = Math.max(max, i - start + 1);

        }

        return max;

    }
}
