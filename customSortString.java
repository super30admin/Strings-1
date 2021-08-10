//791. Custom Sort String
// Time Complexity : O(2N + K) = O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String order, String s) {
        if(s == null || s.length() == 0 || order == null || order.length() == 0)
            return s;
        
        Map<Character, Integer> countMap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        
        //update count of each character of string S, in the hashMap
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0)+1);
        }
        
        //check if each character in order is present in string S and add to the result
        //if 'c' is 4 times in the string, then add 4 times to the result StringBuilder
        for(int i=0; i<order.length(); i++){
            char ch = order.charAt(i);
            
            if(countMap.containsKey(ch)){
                int count = countMap.get(ch);
                while(count >0){
                    result.append(ch);
                    count--;
                }
                countMap.remove(ch);
            }
        }
        
        //add the remains character of string S to result String builder
        for(char key: countMap.keySet()){
            int count = countMap.get(key);
            while(count>0){
                result.append(key);
                count--;
            }
        }
        
        return result.toString();
        
    }
}