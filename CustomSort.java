// Time Complexity : O(T.length())
// Space Complexity : O(unique chars in T)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// keep count of char occurances in T
// process S add charcters in S with count as in T to result StringBuilder
// add remaining elements in T

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        for(int i=0; i<T.length(); i++){
            charCount.put(T.charAt(i), charCount.getOrDefault(T.charAt(i), 0)+1);
        }
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(charCount.containsKey(c)){
                int count = charCount.get(c);
                while(count>0){
                    result.append(c);
                    count--;
                }
                charCount.remove(c);
            }
        }
        
        for(char c : charCount.keySet()){
            int count = charCount.get(c);
            while(count>0){
                result.append(c);
                count--;
            }
        }            

        return result.toString();
    }
}