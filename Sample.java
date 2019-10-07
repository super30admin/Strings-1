Time Comp: O(n)
Space Comp: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int i = 0;
        int j = 0;
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                if(maxLen<j-i){
                    maxLen = j-i;
                }
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLen;
    }
}
