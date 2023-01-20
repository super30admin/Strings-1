//tc : O(string.length) or O(n)
//sc : O(string.length)
//run successfully 
//no errors 

//used hashmaps to save the repetations 
//used array to save the order
//used string builder to add all the repetations in the order

class Solution {
    public String customSortString(String order, String s) {
        // base case
        if (s.length() < 2)
            return s;
        // logic
        HashMap<Character, Integer> map = new HashMap<>();
        char[] letters = new char[26];
        for (int i = 0; i < order.length(); i++) {
            letters[i] = order.charAt(i);
            map.put(letters[i], 0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1 + map.get(s.charAt(i)));
            } else {
                sb.append(s.charAt(i));
            }
        }
        for (int i = 0; i < order.length(); i++) {
            char letter = letters[i];
            System.out.println(letter);
            int times = map.get(letter);
            while (times > 0) {
                sb.append(letter);
                times--;
            }
        }
        return sb.toString();
    }
}