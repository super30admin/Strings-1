//TC:O(n)
//SC:O(1)
//facebook
//Sliding Window Technique: Idea is to use start and end that is current window of focus. The end pointer would be putting characters into the set, making sure that duplicates are removed before we put it. The start pointer would be removing characters and incrementing until charAt[end] can be inserted in the set. Track the global maxima on the fly.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow,map.get(c));
            }
            map.put(c,i+1);
            max = Math.max(max,i-slow+1);
        }
        return max;
    }
}