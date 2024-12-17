//791. Custom Sort String - https://leetcode.com/problems/custom-sort-string/description/
//Time Complexity: O(m+n) ~ m: source, n:order
//Space Complexity: O(m)

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        //create HashMap to store source string
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        //to append characters
        StringBuilder result = new StringBuilder();
        for(char c: order.toCharArray()){
            if(map.containsKey(c)){
                int freq = map.get(c);
                //append freq times to result
                for(int i=0; i<freq; i++){
                    result.append(c);
                }
                map.remove(c);
            }
        }
        //add remaining characters of source to the result
        for(char c: map.keySet()){
            int freq = map.get(c);
            for(int i=0; i<freq; i++){
                result.append(c);
            }
        }
        return result.toString();
    }
}