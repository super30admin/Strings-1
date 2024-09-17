/*
Passed All Test Cases 

HashSet Approach 

Big O 
Time-> O(N), N is # of chars in string s
Space-> O(N), N is # of chars in string s
*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //edge case
        if(s.length() == 0) return 0 ; 
        
        //to keep frequencies of chars
       HashSet<Character> set = new HashSet<>() ;  
        
        //we are using 2 pointers
        int start = 0 ; 
        int end = 0 ; 
        
        //to keep track of max length of substring 
        
        int maxLen = 0 ; 
        while (end < s.length()) {
            //char at end 
            char add = s.charAt(end) ; 
            
            //to make sure no repeating char is includued
            while(set.contains(add)) {
                char check = s.charAt(start) ; 
                set.remove(check) ; 
                
                //moving start ptr to shrink window
                start++ ; 
            }
            
            //adding char to substring
            set.add(add) ; 
            
            //calculating max length 
            maxLen = Math.max(end - start + 1 , maxLen) ; 
            
            //moving end pts to swell window
            end++ ; 
        }
        
        return maxLen ; 
    }
}




/*
Passed All Test Cases 

Big O
Time-> O(N), where N is # of chars in string s
Space-> O(1)

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //edge case
        if(s.length() == 0) return 0 ; 
        
        //to keep frequencies of chars
        int [] cf = new int [256] ; 
        
        //we are using 2 pointers
        int start = 0 ; 
        int end = 0 ; 
        
        //to keep track of max length of substring 
        
        int maxLen = 0 ; 
        while (end < s.length()) {
            //char at end 
            char add = s.charAt(end) ; 
            
            //to make sure no repeating char is includued
            while(cf[add] != 0) {
                char check = s.charAt(start) ; 
                cf[check]-- ; 
                
                //moving start ptr to shrink window
                start++ ; 
            }
            
            //adding char to substring
            cf[add]++ ;
            
            //calculating max length 
            maxLen = Math.max(end - start + 1 , maxLen) ; 
            
            //moving end pts to swell window
            end++ ; 
        }
        
        return maxLen ; 
    }
}