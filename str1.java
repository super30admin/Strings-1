//Longest Substring Without Repeating Characters
//Logic : Using two pointer , check character is present in hashset or not.If not then add and on finding 
//repeatition check maximum else remove character from hashset
// Time Complexity : O(n) 
// Space Complexity : O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result=0,i=0 ,j=0;
        int n=s.length();
        HashSet<Character> hs = new HashSet<>();
        while(i< n && j< n){
            if(!hs.contains(s.charAt(j))){
                hs.add(s.charAt(j++));
                result=Math.max(result , j-i);
            }else{
                hs.remove(s.charAt(i++));
            }
        }
        return result;
    }
}

