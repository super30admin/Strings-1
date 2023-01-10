// Time Complexity: O(n) //length of string
// Space Complecity: O(n) //length of string

/*
 * store the string character in hashmap with its occurance and 
 * go through the order and build new string in that order with
 * rest of the character appended to it.
 */

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }
            else{
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < order.length(); i++){
            if(map.containsKey(order.charAt(i))){
                int count = map.get(order.charAt(i));
                while(count != 0){
                    sb.append(order.charAt(i));
                    count--;
                }
                map.remove(order.charAt(i));
            }
        }

        for(char c: map.keySet()){
            int count = map.get(c);
            while(count != 0){
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}