//Time Complexity: O(n + m) where n is length of s and m is length of order.
//Space Complexity: O(1)

//Count frequencies of all characters in s using a HashMap<char, count>.
//Iterate through order; for each char c, append it to the result count[c] times and remove c from the map.
//Append all remaining characters from the map (those not in order) according to their counts.

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        StringBuilder sb = new StringBuilder();

        for(char c: order.toCharArray()){
            if(map.containsKey(c)){
                int cnt = map.get(c);
                for(int k=0; k<cnt; k++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        for(char c : map.keySet()){
            int cnt = map.get(c);
            for(int k=0; k<cnt; k++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
