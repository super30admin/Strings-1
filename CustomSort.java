// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(1) hashmap with 26 characters at max
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Store the characters and their character counts in the hashmap for the longer
string that we need to parse. Then parse the S string that we need T to convert into so that we know the order our result should appear. If the
map contains the letter we encounter in S, append the result with the character and its number of times of occurances. Since we are parsing over
S we are maintaining the string order. We are getting the number of occurances of T from the map and our result gets build on. 
*/
class Solution {
    public String customSortString(String S, String T) {
        if(S == null || S.length() == 0){return T;}
        HashMap<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < T.length(); i++){
            count.put(T.charAt(i), count.getOrDefault(T.charAt(i), 0) + 1);                                     // Store characters of T and its count
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++)
        {
            if(count.containsKey(S.charAt(i))){                                                     // if the character in S is contained in map (T's characters)
                for(int j = 0; j < count.get(S.charAt(i)); j++)
                    sb.append(S.charAt(i));                                                     // Put the character in the result number of times it has appeared in T
                count.remove(S.charAt(i));                                                  // Remove the character from the map as the character has been processed
            }
        }
        for(Map.Entry<Character, Integer> e : count.entrySet()){
            for(int j = 0; j < e.getValue(); j++)
                    sb.append(e.getKey());                                              // Append the remaining T's characters in the result that are not in S
        }
        return sb.toString();                                                           // Result display
    }
}