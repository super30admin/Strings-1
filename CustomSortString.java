// Time Complexity : The time complexity is O(n) where n is the length of String T
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {

        Map<Character,Integer> map = new HashMap<>();

        // store the frequencies of characters in String T
        for(int i=0;i<T.length();i++){

            char c = T.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);

        }

        StringBuilder output = new StringBuilder();

        // Sort the characters in T according to that of S
        for(int i=0;i<S.length();i++){

            char c = S.charAt(i);
            if(map.containsKey(c)){

                for(int j=0;j<map.get(c);j++){
                    output.append(c);
                }
                map.remove(c);
            }
        }

        // Append the remaining characters
        for(char key:map.keySet()){

            for(int i=0;i<map.get(key);i++){
                output.append(key);
            }
        }

        return output.toString();

    }
}