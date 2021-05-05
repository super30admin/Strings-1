// Runtime complexity - O(n) where n is the length of the string s 
// Space complexity - O(1) where hashmap use the constact space (maximum of 26 characters)

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> submap=new HashMap<>();
        int maxlen=0;
        int start=0;
        if(s==null)
            return 0;
        if(s.length()<2)
            return s.length();
        for(int i=0;i<s.length();i++)
        {
            if(submap.containsKey(s.charAt(i)))
                start=Math.max(submap.get(s.charAt(i)),start);
            submap.put(s.charAt(i),i+1);
            maxlen=Math.max(maxlen,i-start+1);
        }
        return maxlen;
    }
}
