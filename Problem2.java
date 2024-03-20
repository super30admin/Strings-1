class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length()==0) return 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int slow =0;
        int max = 0;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                
                slow = Math.max(slow,hm.get(c)+1);
                

            }
            
                hm.put(c,i);
                max = Math.max(max,i-slow+1);
            
        }
        return max;
        
    }
}