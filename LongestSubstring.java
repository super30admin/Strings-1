// TC : O(2n)
// SC : O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int startWindow = 0,endWindow=0,maxLen=Integer.MIN_VALUE;
        
        if(s.length()==0)
            return 0;
        
        while (endWindow<s.length()) {
            if (map.containsKey(s.charAt(endWindow))) {
                startWindow = Math.max(map.get(s.charAt(endWindow))+1, startWindow);
            }
            maxLen = Math.max(maxLen, endWindow - startWindow + 1);
            map.put(s.charAt(endWindow), endWindow );
            endWindow++;
        }
        return maxLen;
    }
}
