//TC: O(n), n: length of String s
//SC: O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        Map<Character, Integer> map = new HashMap();
        int slow = 0; int fast = 0;
        int max = 0;
        while(fast < n){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, fast+1);
            max = Math.max(max, fast-slow+1);
            fast++;
        }
        return max;
    }
}
