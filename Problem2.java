// There are four approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

import java.util.HashSet;
import java.util.HashMap;

// Your code here along with comments explaining your approach
// Approach 1: Brute force
// Permutate all unique combinations of substring , take the one with maximum length
// Time Complexity : O(n^2)
//      n: length of the string
// Space Complexity : O(128) = O(1)
//    HashSet for characters of string (128 bits)
class Problem2S1 {

    /** get longest substring length without repeat */
    public int lengthOfLongestSubstring(String s) {

        // initailize
        int result = 0;

        // edge case
        if(s != null && s.length() != 0){
            
            // charcter hashset
            HashSet<Character> mySet;

            // iterate char of string
            for(int i=0; i<s.length();i++){
                // create new hashset and add first char
                mySet = new HashSet<>();
                mySet.add(s.charAt(i));

                // permute next chars
                for(int j = i+1; j<s.length();j++){
                    char c = s.charAt(j);
                    // not contains
                    if(!mySet.contains(c))
                        mySet.add(c);
                    else
                        break;
                }
                // max length of substring
                if(result < mySet.size())
                    result = mySet.size();
            }
        }
        // return result
        return result;
    }
}

// Your code here along with comments explaining your approach
// Approach 2: Using Two pointer with HashMap
// Keep track of char's index if it repeates start slow from that location +1
// Time Complexity : O(n)
//      n: length of the string
// Space Complexity : O(128) = O(1)     
//    HashMap for characters of string (128 bits)
class Problem2S2 {

    /** find longest substring */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
       
        // edge case
        if(s != null && s.length() != 0){

            // two pointers
            int slow = 0; 
            int fast = 0;
            int size = s.length();
            // hashmap to track index
            HashMap<Character, Integer> myMap = new HashMap<>();
            char c; 
            int temp;

            // iterate string
            while(fast < size){

                // get character
                c = s.charAt(fast);

                // present in hashmap update slow
                if(myMap.containsKey(c)){
                    slow = Math.max(slow, myMap.get(c));
                }
                // update character's index
                myMap.put(c, fast+1);
                // calcualte current length
                temp = fast-slow +1;

                // get max length
                if(result < temp)
                    result = temp;
                
                // update fast pointer
                fast++;
            }
        }
        // return result
        return result;
    }
}

// Your code here along with comments explaining your approach
// Approach 3: Using Two pointer with Array
// Keep track of char's index if it repeates start slow from that location +1
// Time Complexity : O(n)
//      n: length of the string
// Space Complexity : O(128) = O(1)
//    HashMap for characters of string (128 bits)
class Problem2S3 {

    /** find longest substring */
    public int lengthOfLongestSubstring(String s) {

        // result
        int result = 0;
       
        //edge case
        if(s != null && s.length() != 0){

            // pointers
            int slow , fast, code;
            int size = s.length();
            int[] myMap = new int[128];
            slow = fast = 0;

            // iterate string
            while(fast < size){

                // get ascii value
                code  = s.charAt(fast);
                // update slow
                slow = Math.max(slow, myMap[code]);
                // update charcter's index
                myMap[code] = fast+1;
                
                // take max
                result = Math.max(result, fast- slow + 1);

                // update fast
                fast++;
            }
        }
        // return result
        return result;
    }
}

// Your code here along with comments explaining your approach
// Approach 4: Using Two pointer with Array (Same as above)
// Low memory utilization cause of "FOR LOOP"
// Keep track of char's index if it repeates start slow from that location +1
// Time Complexity : O(n)
//      n: length of the string
// Space Complexity : O(128) = O(1)
//    HashMap for characters of string (128 bits)
class Problem2S4 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
       
        // edge case
        if(s != null && s.length() != 0){
            int code;
            int size = s.length();
            int[] myMap = new int[128];
            
            // iterate string
            for(int fast = 0, slow =0; fast < size; fast++){
                code  = s.charAt(fast); // get ascii
                slow = Math.max(slow, myMap[code]); // update slow
                myMap[code] = fast+1; // update character 's index
                result = Math.max(result, fast-slow+1); // get max length
            }
        }
        // return result
        return result;
    }
}