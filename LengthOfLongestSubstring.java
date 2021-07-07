/*
Time: O(s*s)
Space: O(s)

/*
Approach: 
========
1. StringBuilder is used to append new characters to determine longest substring.
2. Count variable stores previous sub string's length, so that new builder's length can be compared to the previous one. 
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        if (s.length() < 2)
            return s.length();
        
        for(int i = 0; i < s.length(); i++) {
            //Check if char is present in StringBuilder. Append if not present
            if(sb.toString().indexOf(s.charAt(i)) == -1) {
                sb.append(s.charAt(i));
                
            }
            //If present, then delete string builder substring till that character and append new char to stringbuilder
            else {
                if (count < sb.length())
                    count = sb.length();
                sb.delete(0,sb.toString().indexOf(s.charAt(i))+1);
                sb.append(s.charAt(i));
            }
        }
        
        //Corner case where longest substring is in the end till s.length()-1
        if (count < sb.length())
                    return sb.length();
        return count;
    }
}

// O(S) time and O(S) space  (if S is all unique characters and set has S elements)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();   // to keep track of what elements are in my window
        int maxLen = 0;
        int start = 0, end = 0; 
        int i = 0;
        while(end < s.length()) {
            char c = s.charAt(end);
            while(set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(c);
            maxLen = Math.max(end-start+1, maxLen);
            end++;
        }
        return maxLen;
    }
}