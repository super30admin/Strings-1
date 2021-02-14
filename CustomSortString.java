// Time Complexity : O(T)
// Space Complexity : O(1) Map is constant, can have 26 values only.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
//Add all elements with their count from T into Map
//Iterate over S, and if map contains the element, add it to result.
//Add all remaning elements from Map to result.

class Solution {
    public String customSortString(String S, String T) {

        HashMap<Character, Integer> map = new HashMap();

        for(char c : T.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        StringBuilder result = new StringBuilder();
        for(char c : S.toCharArray()) {
            if(map.containsKey(c)) {
                for(int i = 0; i < map.get(c); i++) {
                    result.append(c);
                }
                map.remove(c);
            }
        }

        for(Character c : map.keySet()){
            for(int i = 0; i < map.get(c); i++) {
                result.append(c);
            }
            //map.remove(c);
        }
        return result.toString();
    }
}
