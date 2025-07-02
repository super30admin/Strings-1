// Time Complexity : O(n+m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
//Approach: maintain freq map for s string. Iterate through order string and compute result string, by adding current char in order
// k times where k = count of char was seen in s string. Lastly add all characters remaining in hashmap that are not in order string
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch)+1);
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                for(int k = 0;k<map.get(ch);k++){
                    res.append(ch);
                }
            }
            map.remove(ch);
        }
        for(char ch: map.keySet()){
            for(int k = 0;k<map.get(ch);k++){
                res.append(ch);
            }
            //map.remove(ch);
        }
        return res.toString();
    }
}