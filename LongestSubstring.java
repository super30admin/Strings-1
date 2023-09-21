//TC = O(n) -> only 1 pass through s string
//SC = O(1) -> max map can be is 52 entries which is constant

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int len = 0; 
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                slow = Math.max(slow,map.get(curr)+1);
                map.put(curr, i);
            }
            else{
                 map.put(curr, i);
            }
            len = Math.max(len, i-slow+1);
        }
        return len;
    }
}