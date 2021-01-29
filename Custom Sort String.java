/*
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        if S is None or len(S) == 0 or T is None or len(T) == 0:
            return T
        
        frequency = collections.defaultdict(int)
        for c in T:
            frequency[c] += 1
        
        result = []
        for c in S:
            if c in frequency:
                for i in range(frequency[c]):
                    result.append(c)
                del frequency[c]
        
        for key in frequency.keys():
            for i in range(frequency[key]):
                result.append(key)
        
        return "".join(result)
*/

// Time Complexity : O(m+n) where m and n is size of S and T
// Space Complexity : O(1) as there are 26 alphabets only
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach: Maintained a hashmap and then iterated over given string to 
// append all characters in sequence

class Solution {
    public String customSortString(String S, String T) {
        if (S == null || S.length() == 0)
            return T;
        
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i=0; i<T.length(); i++){
            char c = T.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }
        
        for (int i=0; i<S.length(); i++){  			// tc is O(m+n) as inner loop is not dependent on outer loop
            char c = S.charAt(i);
            
            if (freq.containsKey(c)){
            int times = freq.get(c);
            for (int j=0; j<times; j++){
                sb.append(c);
            }
            freq.remove(c);
            }
            
        }
        
        for (char c: freq.keySet()){
            int times = freq.get(c);
            for (int j=0; j<times; j++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}