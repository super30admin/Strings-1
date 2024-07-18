import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Tc: O(n) Sc: O(min(m,n)) 
        //HashMap solution using for loop
        int max = 0;
        int slow = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length();i++)
        {
            char ch = s.charAt(i);
            if(map.containsKey(ch))
            {
                slow = Math.max(map.get(ch),slow);
            }

            max = Math.max(max, i-slow+1);
            map.put(ch, i+1);
        }
        

        return max;
    }
}
/* 
//HashMap solution using while loop
class Solution {
    public int lengthOfLongestSubstring(String s) {
//HashMap Solution
        int max = 0;
        int slow = 0;
        int fast = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(fast < s.length())
        {
            char ch = s.charAt(fast);
            if(map.containsKey(ch))
            {
                slow = Math.max(map.get(ch),slow);
            }
            map.put(ch, fast+1);
            max = Math.max(max, fast-slow+1);
            //map.put(ch, fast+1);
            fast++;
        }
        
 
        return max;
    }
}
*/
//HashSet solution:
//Tc: O(2n) ~ O(n) Sc: O(min(m,n)) where m is len of string and n is hset size
/* 
 HashSet<Character> hset = new HashSet<>(); 
      int left = 0;
      int right = 0;
      int maxLen = 0;
        while (right < s.length()) {
            if (hset.contains(s.charAt(right))) {
                hset.remove(s.charAt(left));
                left++;
            } 
            else {
            hset.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
            }
        }
        return maxLen;
        }
    }
*/