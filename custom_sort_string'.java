// Time Complexity : O(m+n), where m and n is the length of Strings S and T
// Space Complexity :O(1), hashMap will atlmiost have 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three Liner explanation of your code in plain English
//1. Create a hashMap and add all the characters of the String T with their frequency.
//2. Iterate over the String S and check if hashMap has that character and append that character frequency times
//3. In the end add all the remaining characters in the hashMap to the result and return the result

// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {
        //create a hashMap to store all the characters in String S with their frequency
        HashMap<Character, Integer> hMap = new HashMap<>();
        for(int i=0; i<T.length(); i++){
            char c = T.charAt(i);
            hMap.put(c, hMap.getOrDefault(c, 0) +1);
        }
        
        //create a StringBuilder to form result
        StringBuilder result = new StringBuilder();
        for(int i=0 ;i<S.length(); i++){
            char c = S.charAt(i);
            //if character at String S is present in the hashMap, append all count of that character
            if(hMap.containsKey(c)){
                int count = hMap.get(c);
                for(int j=0; j<count; j++){
                    result.append(c);
                }
                //remove that character from the hashMap
                hMap.remove(c);
            }
        }
        
        //Append the remaining characters in the hashMap
        for(char k: hMap.keySet()){
            int count = hMap.get(k);
            for(int i =0; i<count; i++){
                result.append(k);
            }
        }
        //convert result to String
        return result.toString();
    }
}