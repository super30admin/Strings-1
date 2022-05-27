//time-O(n)
//space-O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s==null || s.length()==0) return max;
        Map<Character, Integer> map = new HashMap<>();
        int p1 = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                p1 = Math.max(p1, map.get(ch)+1);
            }
            map.put(ch, i);
            max = Math.max(max, i-p1+1);
        }

        return max;
    }
}
