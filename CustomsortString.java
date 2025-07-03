/*
 * TC: O(m+n) where m: order.length,n:s.length
 * SC: O(26) 26 character in alphabets which would be max length of HashMap.
 * 
 * Approach:Initially, i will have a HashMap and fill the map with th chars in s with its frequency.Then, i will iterate through the order string and on each iteration i will check if the character exists in my hashamp then i will add it to my result repeating it as per its frequency in the map. 
 * Once i have iterated though the entire order string then i will just append remaining chars in the HashMap.
 */

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }


        for(int i = 0; i<order.length(); i++){
            char ch = order.charAt(i);

            if(map.containsKey(ch)){
                int count = map.get(ch);
                while(count > 0){
                    result.append(ch);
                    count--;
                }
            map.remove(ch);
            }
        }

        for(Character key : map.keySet()){
            int count = map.get(key);
                while(count > 0){
                    result.append(key);
                    count--;
                }
        }

    return result.toString(); 
    }
}