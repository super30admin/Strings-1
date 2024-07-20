/*
    LC - 791. Custom Sort String
    TC - O(m + n)
    SC - O(1)
    Approach - 
        Using HashMap to store the frequency of characters in the string s.
        traverse the order string and get the frequency to append the element as many times
        remove the key after appending to the string.
        check if any keys remaining, and append the remaining.
*/

class Solution {
    public String customSortString(String order, String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        HashMap<Character, Integer> myMap = new HashMap<>();
        for(int i=0; i< s.length(); i++) {
            myMap.put(s.charAt(i), myMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length(); i++) {
            char c = order.charAt(i);
            if(myMap.containsKey(c)) {
                int times = myMap.get(c);
                for(int j=0; j<times; j++) {
                    sb.append(c);
                }
                myMap.remove(c);
            }
        }
        for(char ch: myMap.keySet()) {
            int times = myMap.get(ch);
            for(int j=0; j<times; j++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}