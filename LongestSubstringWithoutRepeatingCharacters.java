/*

Thought Process: Sliding Window Approach
    1. Create a store index hashmap which will store the index of the current (fast) indecx location
    2. If we are getting unique elements, keep on storing their fast indexes and calculate the result.
    3. Else (HashMap has the element) move slow to the Max( slow or prev index + 1 ) -> (To prevent slow pointer to go back)
    
T.C -> O(N) -> N - length of String S 
S.C -> O(N) -> HashMap Size
*/


class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> storeIndexMap = new HashMap<>();
        
        int res = Integer.MIN_VALUE;
        int slow = 0, fast = 0;
        
        for(Character c: s.toCharArray()){
            if(storeIndexMap.containsKey(c))
                slow = Math.max(slow, storeIndexMap.get(c) + 1);
            
            res = Math.max(res , (fast - slow + 1));
            storeIndexMap.put(c, fast);
            fast++;
        }
        return res;
    }
}