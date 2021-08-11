// Time Complexity: O(2n) ≈ O(n)
// Space Complexity: O(1)
// Run on leetcode: yes
// Issues faced: none

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 1;
        int max = 1;
        set.add(s.charAt(start));
        while(end < s.length()){
            char c = s.charAt(end);
            if(set.contains(c)){
                set.remove(s.charAt(start));
                start++;
            }
            else{
                set.add(c);
                max = Math.max(max, end - start + 1);
                end++;
            }
        }
        
        return max;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// Run on leetcode: yes
// Issues faced: Wrote max and put inside else which gave me a wrong answer

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0, j=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                j = Math.max(j, map.get(c));
            }
            max = Math.max(max, i-j+1);
            map.put(c, i+1);
        }
        return max;
    }
}
