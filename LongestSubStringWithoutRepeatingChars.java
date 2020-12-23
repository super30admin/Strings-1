/**
 * TC : O(N) SC : O(N)
 * Approach: using sliding technique, we can kepp track of the maximum window in which there are no repeated elements encountered. 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s.length() == 0) return max;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0, j = 0; j < s.length(); j++){    
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            max = Math.max(max,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return max;
    }
}