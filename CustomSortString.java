// USING : HASHMAP
// TC : O(n)
// SC : O(1)
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();

        //populate map based on char occurrences in s String
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        //check which chars are in order and add to sb
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                //get count of occurrences
                int count = map.get(c);
                //add count amt to result
                for(int j = 0; j < count; j++){
                    result.append(c);
                }
                map.remove(c);
            }
        }
        //add all the leftover chars that were not in order string
        for(Character c: map.keySet()){
            //get count of occurrences
                int count = map.get(c);
                //add count amt to result
                for(int j = 0; j < count; j++){
                    result.append(c);
                }
        }
        return result.toString();
    }
}
