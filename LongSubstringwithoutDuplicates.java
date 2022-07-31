TC:O(n)
SC:O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,max = 0,j=0;
        HashSet<Character>set = new HashSet<>();
        while(i<s.length() && j<s.length()){
            char ch = s.charAt(j);
            while(set.contains(ch)){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(ch);
            max = Math.max(max,set.size());
            j++;
        }
        return max;
    }
}