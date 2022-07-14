// Time Comlpexity: O(n)
// Space Complexity:O(no. of unique chars in input string)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int max=0,slow=0;

        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                slow=Math.max(slow,map.get(c));
            }
            max=Math.max(max,i-slow+1);
            map.put(c,i+1);
        }
        return max;
    }
}