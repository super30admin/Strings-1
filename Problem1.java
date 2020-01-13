/**
LeetCode Submitted : YES
Space Complexity : O(constant) //Using character HashMAP
Time Complexity : O(String Length)

The idea is to use 2 pointers to iterate the string length such that we move fast pointer by updating th e hash value and slow pointer if we encounter key already exists in hashmap by taking maximum of current slow with new value of hashMap. Also, maximum length of substring will be maximum of current maximum and (fast pointer - slow pointer + 1)

**/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max  = 0;
        int fast = 0;
        int slow = 0;
        
        if(s == null || s.length() < 1)
            return max;
        
        HashMap<Character,Integer> map = new HashMap<>();
        while(fast < s.length()){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow,map.get(c));
            }
            map.put(c,fast+1);
            max = Math.max(max,fast - slow + 1);
            fast++;
        }
        return max;
    }
}
