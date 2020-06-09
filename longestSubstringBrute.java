//time complexity O(n)
//space complexity O(1) since number of alphabets is 26

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0; int max = 0;
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i);
            } else{
                slow = Math.max(map.get(c) + 1, slow);
                map.replace(c, i);

            }
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }
}
