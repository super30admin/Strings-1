//time o(n)
//space o(1), since max 26 characters are present in the set
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() == 0)
            return 0;
        int len = s.length();
        int max = 0;
        int i =0, j=0;
        HashSet<Character> set = new HashSet<>();
        
        while(i<len && j<len) {
            char ch = s.charAt(j);
            if(!set.contains(ch)) {
                set.add(ch);
                max = Math.max(max, j-i+1);
                j++;
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}