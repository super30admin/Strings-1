// Time Complexity : O(n + m) where n = len of order and m = len of s
// Space Complexity : O(1) since at most 26 chars will be store in hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Count frequency of each character in 's' using a HashMap.
//   - Iterate 'order' string: for each character, append it to result 'cnt' times (where 'cnt' is frequency in map).
//   - Remove each processed character from map.
//   - Finally, append remaining characters from map (those not in 'order') to result.


import java.util.HashMap;

public class CustomSortString {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        //add all freq from s in map
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c: order.toCharArray()) {
            if(map.containsKey(c)) {
                int cnt = map.get(c);
                for(int k = 0; k < cnt; k++) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        //in map we cant delete characters while iterating the map we get error since concurrent modification in map is not allowed in Java
        for(char c: map.keySet()) {
            int cnt = map.get(c);
            for(int k = 0; k < cnt; k++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        CustomSortString solution = new CustomSortString();

        String order = "cba";
        String s = "abcdabcd";
        String result = solution.customSortString(order, s);

        System.out.println("Custom sorted string: " + result);
    }
}
