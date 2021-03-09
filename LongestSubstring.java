//TC: O(n)
//Space: O(n)
//We used slinding window to find the maximum substring
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0; 
        int end = 0;
        int max = 0;
        
        while(end<s.length()){
            
            if(map.containsKey(s.charAt(end))){
                if(map.get(s.charAt(end))>start){
                    start=map.get(s.charAt(end));
                }
            }
            max = Math.max(max,end-start+1);
            map.put(s.charAt(end),end+1);
            end++;
        }
        return max;
    }
}