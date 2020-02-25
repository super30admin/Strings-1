// Time Complexity : O(Max(m,n));  m=lengthof(S), n=lengthof(T), 
// Space Complexity : O(n) n is size of map with max 26 alphabets
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {
        StringBuilder outputString = new StringBuilder();
        
        if(S.length() == 0 || S == null || T.length() == 0 || T == null)  
            return outputString.toString();
        
        HashMap<Character, Integer> map = new  HashMap<>();
        
        //Put in all the chars of T in map
        for(int i=0; i<T.length(); i++) {
            Character c = T.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);    
            }
            else
            {
            map.put(c, 1);
            }
        }
        
        //Build the OutputString with common characters in S and T
         for(int i=0; i<S.length(); i++) { 
             Character c = S.charAt(i);
             while(map.containsKey(c)) {
                 int count = map.get(c);
                 while(count>0) {
                 outputString.append(c);
                 count--;
                 }
                 map.remove(c);
             }
         }
        
    //Append the remaining characters of T which are not in S
    for(Map.Entry<Character, Integer> entry : map.entrySet()) {
         int count = entry.getValue();
        Character c = entry.getKey();
                 while(count>0) {
                 outputString.append(c);
                 count--;
                 }
    }
        return outputString.toString();
    }
}