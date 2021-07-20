//Time Complexity-O(s)
//Space complexity-O(s)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        HashMap<Character,Integer> map = new HashMap<>();//stores the index with each char in s
        int start=0;
        int end =0;
        while(end<s.length()){
            char ch= s.charAt(end);
            
            if(map.containsKey(ch))
                start=Math.max(start,map.get(ch));//if we encouunter same char later but it's index is not updated yet and pints to value before start.
            
            map.put(ch,end+1);
            max=Math.max(max,end-start+1);
            
            end++;
            
        }
        return max;
    }
}