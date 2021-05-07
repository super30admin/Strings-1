//Time Complexity:O(n)
//space Complexity:O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        HashSet<Character> set = new HashSet<>();
        for(int i =0,j=0;i<s.length();){
            char c =s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                max=Math.max(i-j+1, max);
                i++;
            }else{
                set.remove(s.charAt(j));
                j++;
            }
        }
        return max;
    }
}