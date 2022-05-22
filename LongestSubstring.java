//TC : O(N) where N is length of string
//SC : O(1) ignoring hashmap space as will only store at max 26 characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;

        HashMap<Character,Integer> hm = new HashMap<>();

        int slow = 0;
        int max = 0;

        for(int fast =0;fast<s.length();fast++)
        {
            char c = s.charAt(fast);
            if(hm.containsKey(c))
            {
                slow = Math.max(slow,hm.get(c));
            }

            max = Math.max(max,fast-slow+1);
            hm.put(c,fast+1);
        }
        return max;
    }
}