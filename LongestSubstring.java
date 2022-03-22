
//Timecomplexity: o(n)
//SPaceComplexity: o(1) 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        

        int slow = 0;
        int count = 0;
        int maxcount = 0;
        for(int i =0;i<s.length();i++)
        {
            char curr = s.charAt(i);
            if(!map.containsKey(curr))
            {
                map.put(curr,i);
             
                maxcount= Math.max(maxcount,i-slow+1);
                    
            }
            else
            {
                if(map.get(curr) >= slow){
                  slow = map.get(curr)+1;  
                  map.put(curr,i);
                  
                }
                else{
                    maxcount= Math.max(maxcount,i-slow+1);
                }
                
            }
        }
        return maxcount;
        
    }
}
