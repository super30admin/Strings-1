//Time Complexity : O(n)
//Space Complexity : O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if(l<=1) return l;
        HashMap<Character, Integer> map = new HashMap<>();
        int left =0;
        int max= 0;
        for(int right=0; right < l;right++){
            char curr = s.charAt(right);
            if(map.containsKey(curr)){
                left = Math.max(left, map.get(curr) + 1);
            }
            map.put(curr, right);
            max = Math.max(max, right - left +1 );

        }
        return max;
    }
}
