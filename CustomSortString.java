import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class CustomSortString {


    /*
    TC : O(N) where N is the length of String str
    SC : O(N) for the hashMap where N is the length of string str
    LC : yes
    Problems : No
     */

    /**
     * The approach used is to create a hashmap that keeps the count of characters present in the string str.
     * Then iterate over the string order and check if the character is present in the map.
     * If yes, then add the character in the final string for times equal to the 'count' stored for that character in the map
     * And remove the character from the map after adding it to final string
     * At the end, add the remaining characters that were not present in the string order by iterating over the hashmap values
     */
    public String customSortString(String order, String str) {
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char[] sort = order.toCharArray();
        String replacement = "";
        int val = 1;
        for (char c : sort) {
            if (map.containsKey(c)) {
                for (int i = 0; i < map.get(c); i++)
                    replacement += c;
                map.remove(c);
            }

        }

        for (Character c : map.keySet()) {
            for (int i = 0; i < map.get(c); i++)
                replacement += c;

        }
        return replacement;
    }


    /*
    TC : O(n+mlogm) where n is the length of order string and m is the length of str string
    SC :O(1)
    LC: yes
    Problems : No
    
     */

    /**
     * Here we override the compare method and write a custom sort based on the indices of the characters given in order
     *
     * @param order
     * @param str
     * @return
     */

    public String customSortString_usingCustomSort(String order, String str) {

        int[] sortedOrder = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            sortedOrder[order.charAt(i) - 'a'] = i;
        }


        Character[] arr = new Character[str.length()];
        for (int i = 0; i < str.length(); ++i)
            arr[i] = str.charAt(i);

        // sort the above array with respect to index of characters of String order
        Arrays.sort(arr, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return Integer.compare(sortedOrder[c1 - 'a'], sortedOrder[c2 - 'a']);
            }
        });


        StringBuilder sb = new StringBuilder(arr.length);
        for (Character c : arr)
            sb.append(c.charValue());

        return sb.toString();
    }
}
