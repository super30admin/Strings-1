/*
* Keep track of the characters and frequency in the source string and store it in a map
* Iterate over the order string and start building the resultant string but pulling the frequency of each character from the order string and whatever is left at the end in the map, can be appended at the end of the resultant string
* TC: O(n) -> n is length of the source string as characters in order string are non repeating so thats 26 char so O(1)
* SC: O(n) -> map with 26 characters so space is constant but stringbuilder will take n where n is length of the source string

Follow up: what if we want all the permutations?
2 ways: 
    - dderive all the permutations and then check if they are matching with the order provided by the order string, exponential solution 
    - TC: O(2^N) -> n is the length of all the characters in s
    - Another way is to have the frequency map, built a string by following the order provider by the order string and then come up with all the permutations of the remaining characters in the source string
    - TC: O(2^n) -> n is the length of characters that are not in the order string
*/

class Solution {
    public String customSortString(String order, String s) {
        StringBuilder res = new StringBuilder(); //O(n)
        HashMap<Character, Integer> sMap = new HashMap<>();
        //add all the characters and their freq in the map from source string
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        // iterate over order string and append the characters to the res freq times
        for (int i = 0; i < order.length(); i++) {
            if (sMap.containsKey(order.charAt(i))) {
                int freq = sMap.get(order.charAt(i));
                while (freq != 0) {
                    res.append(order.charAt(i));
                    freq--;
                }
                sMap.remove(order.charAt(i));
            }
        }

        // if there are any characters left in the map, iterate over those characters and append it to the res
        if (sMap.size() != 0) {
            for (char ch : sMap.keySet()) {
                int freq = sMap.get(ch);
                while (freq != 0) {
                    res.append(ch);
                    freq--;
                }
                // the removal of chr from map wont work as we are iterating through the map and modifying the map as well which will give us concurrent modification exception
                //sMap.remove(order.charAt(i));
            }
        }
        return res.toString();
    }
}