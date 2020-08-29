// There two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.HashMap;

// Your code here along with comments explaining your approach
// Approach 1: Using HashMap
// Time Complexity : O(m+n) = O(n)
//      m: size of S = 26
//      n: size of T
//   Since S has unique char so it is 26
// Space Complexity : O(26) = O(1)
class Problem1S1 {

    /** Get custom sort string */
    public String customSortString(String S, String T) {

        // initialize
        int m = S.length();
        int n= T.length();

        // create hashMap for T
        HashMap<Character, Integer> myMap = new HashMap<>();
        for(int i=0; i<n;i++){
            char c = T.charAt(i);
            myMap.put(c, myMap.getOrDefault(c, 0)+1);
        }
        
        // result
        StringBuilder result = new StringBuilder();

        int count;

        // iterate string S
        for(int i=0; i<m;i++){
            char c = S.charAt(i);

            // check present in T
            if(myMap.containsKey(c)){
                count = myMap.get(c);

                // append char count times
                while(count != 0){
                    result.append(c);
                    count--;
                }
                // remove after processed
                myMap.remove(c);
            }
                
        }

        // Remaining entries add to result
        for(char entry:myMap.keySet()){
            count = myMap.get(entry);
            while(count != 0){
                result.append(entry);
                count--;
            }
        }
        
        // return result
        return result.toString();
         
    }
}
// Your code here along with comments explaining your approach
// Approach 2: Using Array
// Time Complexity : O(m+n) = O(n)
//      m: size of S = 26
//      n: size of T
//   Since S has unique char so it is 26
// Space Complexity : O(26) = O(1)
class Problem1S2 {

    /** get custom string */
    public String customSortString(String S, String T) {
    
        // initialize
        int m = S.length();
        int n= T.length();

        // map size of 26 letter
        int[] myMap = new int[26];
        int mapIndex;

        // iterate string T
        for(int i=0; i<n;i++){
            mapIndex = T.charAt(i) -'a'; // a->0 , z->25
            myMap[mapIndex]++;
        }
        
        // result char array of size T
        char[] result = new char[n];
        int index = 0; // char index

        // iterate String S
        for(int i=0; i<m;i++){

            // map index
            mapIndex = S.charAt(i)-'a';

            // add char that many times
            while(myMap[mapIndex] != 0){
                result[index++] = S.charAt(i);
                myMap[mapIndex]--;
            }
        }

        // iterate map and add all character whose count is greater than 0
        for(int i=0; i<26;i++){
            // reverse map
            char c = (char)(i+'a');

            // add char that many times
            while(myMap[i] != 0){
                result[index++] = c;
                myMap[i]--; 
            }
        }
    
        // convert char to string
        return new String(result);  
    }
}