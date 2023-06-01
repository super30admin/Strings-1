// Time: O(n)
// Space: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1) return 1;
        if (s.length() == 0) return 0 ;
        Set<Character> set = new HashSet<>();
        int start =0 ,end = 0, max = Integer.MIN_VALUE;
        while(end < s.length()){
            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                max = Math.max(max, (end -start +1));
                end++;
            }else{
                set.remove(s.charAt(start));
                start++;
            }
            
        }
        return max;

    }
}