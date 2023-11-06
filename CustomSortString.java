class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Count the occurrences of each character in s
        for (char schar : s.toCharArray()) {
            map.put(schar, map.getOrDefault(schar, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        // Append characters from the order string in the specified order
        for (char ochar : order.toCharArray()) {
            if (map.containsKey(ochar)) {
                int count = map.get(ochar);
                while (count > 0) {
                    sb.append(ochar);
                    count--;
                }
                map.remove(ochar); // Remove the character from the map
            }
        }

        // Append any remaining characters in s that are not in the order
        for (char schar : s.toCharArray()) {
            if (map.containsKey(schar)) {
                int count = map.get(schar);
                while (count > 0) {
                    sb.append(schar);
                    count--;
                }
                map.remove(schar);
            }
        }

        return sb.toString();
    }
}
/**
 * If the given S = cbc , ‘c’ should occur before ‘b’ and ‘b’ should occur before ‘c’.
 * 
One approach is to use HashMap and put all the other string characters inside hashmap and pull out all c’s and b’s and c’s from hashmap and then attach remaining characters to the string.

O( M + N), O(M){StringBuilder}, HashMap has 26 characters so it's O(1) for HashMap. → Remember in Strings Space will be O(1), bcz of its constant characters 
 * 
 */