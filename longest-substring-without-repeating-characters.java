// Time Complexity :
O(n) where n is the length of the input
// Space Complexity :
O(m) where m is the length of the array, where we are storing the frequencies
// Did this code successfully run on Leetcode :
yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach


/*
1. find all the substrings starting with a particular character
2. After getting each substring check if it can make a possible result
3. Checking condition would be it will not have any duplicates
4. Possible result  is Maximam length substring until this point
*/

//Method -2
/*
If we find a way where in we would not need to enumerate through rest of the
Substrings once we find the duplicate element, it would be optimized
*/
//This method will use frequency array to check how many times a character occurs
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Define result
        int result = 0;
        /*Define an int array to store the frequencies of each char in s,
        which can be used to find the duplicate element
        */
        
        int [] frequency = new int [128];
        
        //Define windowStart anfd windowEnd
        int windowStart = 0;
        int windowEnd = 0;
        
        //expand the window by incrementing the windowEnd
        
        while(windowEnd < s.length()){
            //extract the character at current position
            char c = s.charAt(windowEnd);
            //increment the frequency of c in frequency array
            frequency[c] ++;
            
            /*incase if my frequency[c] is > 1, it implies that there's a ,
            in that case, I have to contract my window by changing windowStart
            */
            while(frequency[c] > 1){
                char x = s.charAt(windowStart);
                frequency[x]--;
                windowStart++;
            }
            
            //Collect the result as we found a window that does not have duplicates
            result = Math.max(result, windowEnd - windowStart + 1);
            
            //expanding window step
            windowEnd++;
            
        }
        return result;
    }
}




//method -3
/*We want to record the occurence of previous duplicate element,
So that when we encounter the same element later when expanding
we would use it to contract the window*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
     int windowStart=0;
     Map<Character,Integer> m=new HashMap<>();
     int result=0;
        for(int windowEnd=0;windowEnd<s.length();windowEnd++){
            
            char right=s.charAt(windowEnd);
            if(m.containsKey(right)){
                
                windowStart=Math.max(windowStart,m.get(right)+1);
                
            }
            
            
        m.put(right,windowEnd);
        result=Math.max(result,windowEnd-windowStart+1);
            
        }
       
        return result;
        
    }
}