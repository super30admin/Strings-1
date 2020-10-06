    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/custom-sort-string/
    Time Complexity for operators : o(n) .. n is the length of the string
    Extra Space Complexity for operators : o(c) .. number of distinct characters
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Two forloops and then go for sustring (n*m*m) time complexity
        # Optimized approach: 
                              
            # 1. 
                    A) Add second string into hashmap with count of repeated characters.
                    B) The traverse through the first string.
                    C) check if hashamp contains the value or not
                    D) If it contains, then get the count and add that much number of characters into String Builder.
                    E) Then, remove it from Hashmap.
                    F) If it is not in hashmap then leave it as it is. At the end, we will iterate through hashmap and 
                       will append string into String Builder by considering its repetation count.
    */  
class Solution {
    public String customSortString(String S, String T) {
        
        if(S.length() == 0 || T.length() == 0){
            return "";
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i=0;i<T.length();i++){
            char ch = T.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            if(hm.containsKey(ch)){
                int count = hm.get(ch);
                
                while(count>0){
                    sb.append(ch);
                    count--;
                }
                hm.remove(ch);
            }
        }
        
        for(Map.Entry<Character, Integer> map : hm.entrySet()){
            int count = map.getValue();
            
            while(count>0){
                sb.append(map.getKey());
                count--;
            }
        }
        return sb.toString();
    }
}