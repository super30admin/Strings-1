// Approach 1: Hashset
// Time Complexity : O(2n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We use two pointers to track the start and end of the substring
// We traverse the string and insert the elements in a hashset to check for repetition
// We update the start pointer and the hashset(by moving the pointer one index at a time) once we reach second occurence of an element 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                while(s.charAt(start)!=c)
                    {set.remove(s.charAt(start));
                    start++;
                    }
                start++;
            }
            result = Math.max(result, i-start+1);
            set.add(c);
        }
        return result;
    }
}

// Approach 2: HashMap
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Similar to approach 1 but we will use a hashmap so that we can store the index of last occurence of char
// Once we reach a duplicate element, we update start Index
// We also need to consider the case where the duplicate element is before the start Index as we are not deleting entries from the map

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                start = Math.max(start, map.get(c)+1);
            }
            result = Math.max(result, i-start+1);
            map.put(c,i);
        }
        return result;
    }
}