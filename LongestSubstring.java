public class LongestSubstring {
    // TC is O(n)
    // SC is O(26) constant
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        if(len == 1) return 1;
        int max = Integer.MIN_VALUE;
        int slow = 0;
        int fast = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(fast<len){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c)+1);
            }
            max = Math.max(max, fast-slow+1);
            map.put(c, fast);
            fast++;
        }
        return max;
    }
}
