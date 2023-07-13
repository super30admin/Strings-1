// Time Complexity :o(n)
// Space Complexity : constant
// Did this code successfully run on Leetcode : yes


class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        //store the count of each character in s and store it in map
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        //iterate over order and append the character to the stringbuilder
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < order.length(); i ++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                for(int j=0; j <cnt; j++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        //append the remaining characters in the map to the stringbuilder
        for(char c: map.keySet()){
            int cnt = map.get(c);
            for(int i =0; i<cnt; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}