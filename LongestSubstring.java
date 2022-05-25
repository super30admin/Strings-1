// O(n) time, index m will iterate over n times
// O(min(m,n)) space: sliding window is size of hashmap, upper bounded by size of string n, and size of alphabet m

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        
        int idx = 0;
        for (int m = 0; m < n; m++){
            if (map.containsKey(s.charAt(m))){
                idx = Math.max(map.get(s.charAt(m)), idx);
            }
            answer = Math.max(answer, m - idx + 1);
            map.put(s.charAt(m), m + 1); // if we encounter this char again, we skip all the way to index m + 1 directly
        }
        return answer;
    }
}