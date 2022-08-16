// 0(1) space
// 0(n) time
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s== null || s.length()==0)
        {
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int slow =0;
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            if(!map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i),i+1);
                max=Math.max(max,i-slow+1);
            }
            else
            {
                slow=Math.max(slow,map.get(s.charAt(i)));
                map.put(s.charAt(i),i+1);
                max=Math.max(max,i-slow+1);

            }

        }
        return max;
    }
}