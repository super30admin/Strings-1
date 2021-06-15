/*
Desc : We use two pointers here, while we hash the occurences of the characters at any index in the hashmap along with the index of next element as value,
while we encounter an element that has already been hashed into the hashmap, we push our slow pointer to the index that is in value field of hashmap,
the largest distance between the slow and fast pointer is our lenght of longest substring.
Time Complexity : O(n)
Space Complexity : O(k) while k are number of distinct characters in the string
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int slow = 0; int fast = 0; int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(fast<s.length()){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow,map.get(c));
            }
            map.put(c,fast+1);
            max = Math.max(max,fast-slow+1);
            fast++;
        }
        return max;
    }
}
