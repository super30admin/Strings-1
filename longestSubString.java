// Time Complexity : O(n)
// Space Complexity :O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        int start=0,max=0;
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c) && map.get(c)>start){
                start=map.get(c);        
            }
            map.put(c,i+1);
            max=Math.max(max,i-start+1);
            
        }
        return max;
    }
}