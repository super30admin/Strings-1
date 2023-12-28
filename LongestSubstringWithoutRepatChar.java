//Time complexity:O(n)
//Space Complexity:O(1)
//Two pointer with hashset for reference
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int  left = 0;

        HashSet<Character> hs = new HashSet<>();

        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(hs.contains(c)){
                while(c!=s.charAt(left)){
                    hs.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            hs.add(c);
            result = Math.max(result,hs.size()); //can use i-left+1 instead of hashset size() function
        }
        return result;
    }
}