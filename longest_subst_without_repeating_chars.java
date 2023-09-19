class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int slow=0;
        HashMap<Character,Integer> m = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(m.containsKey(s.charAt(i)))
            {
                slow = Math.max(m.get(s.charAt(i))+1,slow);

            }
            m.put(s.charAt(i),i);
            max = Math.max(max, i-slow+1);


        }
        return max;
    }
}