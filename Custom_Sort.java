/*
Approach: we store the source string char by char in hashmap,
we store the occurences of each character
we start traversing from given order, and check for each character
whether it is present in hashmap, if yes we check its count and
add that many times
This is how we can form a valid permutation followed by order
 */

/*
Time: O(n+m)
Space: O(n)
 */

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int n = s.length();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder(); // generate all sequence of characters

        for(char c: order.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int k=0; k<count; k++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        for(char c: map.keySet()){
            int count = map.get(c);
            for(int k=0; k<count; k++){
                sb.append(c);
            }
        }

        return sb.toString();
        
    }
}