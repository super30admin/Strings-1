// Time Complexity : O(len(s))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//Approach: Two pointers approach. Start 2 pointers at beginning of string. For each incoming charcter check if we already saw it, if not, add char and it's cucrent index
/// to hashmap. If already seen, check if prev seen index is in current window, if yes jump start to prev seen index+1.
/// Also replace the index of current charater to current index. At each char, check if length of current string in window is max we saw so far
/// without any duplicates
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start=0, end;
        for(end=0;end<s.length();end++){
            char curr = s.charAt(end);
            if(map.containsKey(curr) && map.get(curr)>=start){
                start = map.get(curr)+1;
                System.out.println("updating start: "+start);
            }
            map.put(curr, end);
            if(end-start+1>maxLength){
                maxLength = end-start+1;
                System.out.println(map+" "+maxLength+" "+s.substring(start, end+1));
            }
        }
        System.out.println(map);
        return maxLength;
    }
}