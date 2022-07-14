class Solution {
  
  //Tc: O(n) sc:O(1)
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        int maxLen=0;
        int low=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                low=Math.max(low,map.get(c)+1);
            }
            
                maxLen=Math.max(maxLen,i-low+1);
                map.put(c,i);   
        }
        
        
     return maxLen;   
    }
}
