import java.util.HashMap;
import java.util.Scanner;
public class CustomSortString_HashMap {


        // HASHMAP - O(permuted String length)

        /** Build frequency map of characters in s
         * go through order characters and add them to result with correct
         frequency
         * then add non-order remaining characters of s to result in correct frequency */

        public String customSortString(String order, String s) {

            // build frequency of characters in s map
            HashMap<Character, Integer> mapFreq = new HashMap<>();

            for(int i = 0; i< s.length(); i++) { //O(S.length)

                char curr = s.charAt(i);

                mapFreq.put(curr, mapFreq.getOrDefault(curr, 0) + 1);
            }

            StringBuilder result = new StringBuilder(); // O(S.length) - space

            for(int j = 0; j < order.length(); j++) { //O(S.length)
                // for loop is just to find characters common to s and order in the order of order
                char ch = order.charAt(j);

                // if character of order is present in frequency of characters in s map
                if(mapFreq.containsKey(ch)) {

                    // add order-character in s to result in its frequency
                    int fq = mapFreq.get(ch);

                    for(int l = 0; l < fq; l++) {

                        result.append(ch);
                    }
                    // remove order-character from map after adding to result in its full frequency
                    mapFreq.remove(ch);
                }

            }

            // add remaining non-order characters of s to result in their own frequency
            for(char rest: mapFreq.keySet()) { //O(S.length)

                int fq = mapFreq.get(rest);

                for(int l = 0; l < fq; l++) {

                    result.append(rest);
                }

                // mapFreq.remove(rest);
                //removes remaining characters also from map and makes it empty

            }
            // StringBuilder to String conversion
            return result.toString();
        }

        public static void main(String[] args) {

            CustomSortString_HashMap obj = new CustomSortString_HashMap();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter order: ");
            String order = scanner.nextLine();

            System.out.println("Enter s: ");
            String s = scanner.nextLine();

            String answer = obj.customSortString(order, s);

            System.out.println("Permuted String with custom sorted order is " + answer);

        }
}

/*
TIME COMPLEXITY = O(N)
N = S.length = length of permuted string
TIME COMPLEXITY = O(N)
*/