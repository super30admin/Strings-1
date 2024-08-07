import java.util.HashMap;

public class CustomSortString {
    public static String customSortString(String order, String s) { //O(max(l,m) T.C
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) { //frequency-map of all characters in the s string
            char c = s.charAt(i); //O(l) T.C, l is length of s string
            map.put(c, map.getOrDefault(c, 0) + 1); //O(1) S.C -> size 26 at max
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length(); i++) { //O(m) T.C. where m is length of order string
            char c = order.charAt(i);
            if(map.containsKey(c)) { //if the map contains the character from order
                sb.append(String.valueOf(c).repeat(map.get(c))); //append that char its count times to the sb
                map.remove(c); //then remove the char from the map
            }
        }

        for (Character key : map.keySet()) { //if any chars are pending in the map, that are not part of the order
            sb.append(String.valueOf(key).repeat(map.get(key))); //append them at the end with its count times
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abdabcdnitin";
        String order = "abd";

        System.out.println("The string " + s + " after custom sorted with order " + order +
                " , becomes: " + customSortString(order, s));
    }
}
