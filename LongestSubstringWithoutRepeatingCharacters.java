//Time Complexity-O(n)
//Space Complexity-O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||
          s.length()==0)
        {
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int start=0;
        int end=0;
        HashMap<Character,Integer>map=new HashMap(1000);
        while(end <s.length())
        {
            char c=s.charAt(end);
            if(map.containsKey(c))
            {
                start=Math.max(start,map.get(c));
            }
            map.put(c, map.getOrDefault(0,end)+1); 
            max=Math.max(max,end-start+1);
            end++;
        }
        return max;
        
    }
}