import java.util.HashMap;
import java.util.HashSet;

/*
Time complexity: O(N), n is the length of the order string
Space Complexity: O(1) amortized as map would store maximum of 26 characters and their frequencies, even set would have 26
characters at max
Run on leetcode: yes
Any difficulties: no

Approach:
1. Attempted after discussed in the class
 */
public class CustomSortString {

    public static String customSortString(String order, String s){

        // Creating Map to store the no of chars in the unsorted string
        HashMap<Character, Integer> map = new HashMap<>();

        // Create a set to store those chars which are not present in the sorted string
        HashSet<Character> notPresent = new HashSet<>();

        // Traverse through the unsorted string for filling above data structures
        for(Character c:s.toCharArray()){
            if(!order.contains(c.toString()))
                notPresent.add(c);
            if (map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }

        // Traverse through sorted string to fill the values in sorted order from unsorted characters
        StringBuilder result= new StringBuilder();
        for(char ch: order.toCharArray()){
            if(map.containsKey(ch)){
                for(int i=0; i<map.get(ch); i++)
                    result.append(ch);
            }
        }

        // Append the characters which are not present in the sorted string.
        for(char ch: notPresent){
            for(int i=0; i<map.get(ch); i++)
                result.append(ch);
        }

        return result.toString();
    }
    public static void main(String[] args){
        System.out.println("Custom sort: "+ customSortString("cba","abcd"));
    }
}
