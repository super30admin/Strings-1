// Time -> O(n)
// Space -> O(n)
//HashMap solution
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0; 
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(right < s.length()){
            char curr = s.charAt(right);
            if(map.containsKey(curr) && map.get(curr) >= left){
                // repeate
                left = map.get(curr) + 1;
            }

            map.put(curr, right);
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
