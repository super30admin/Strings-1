import java.util.Scanner;
import java.util.HashMap;

public class LongestSubstringNoRepeatChar_SlidingWindowHashMap {


        //SLIDING WINDOW - OPTIMIZED - HASH MAP - O(N) = EXACTLY N TIME

        public int lengthOfLongestSubstring(String s) {

            int longest = 0;

            int slow = 0;

            //map character to index of string
            HashMap<Character, Integer> map = new HashMap<>(); // O(1) = maximum 26 characters - constant space

            //iterate over string
            for(int i = 0; i < s.length(); i++) { //O(N)

                char curr = s.charAt(i);

                // check if curr character is in map already
                if(map.containsKey(curr)) {

                    // move slow to next index of existing replica of repeating character in map, if that gives in a higher low pointer than the existing slow pointer
                    slow = Math.max(slow, map.get(curr) + 1);
                }

                // put current character in map, value gets updated if it is a repeating character
                map.put(curr, i);

                //update longest variable
                longest = Math.max(longest, i - slow + 1);
            }

            return longest;
        }

        public static void main(String[] args) {

            LongestSubstringNoRepeatChar_SlidingWindowHashMap object
                    = new LongestSubstringNoRepeatChar_SlidingWindowHashMap();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            int answer = object.lengthOfLongestSubstring(input);

            System.out.println(answer);
        }

}

/*
TIME COMPLEXITY = O(N) - exactly n times iteration of i
N = length of string

no while loop inside

SPACE COMPLEXITY = O(1)
*/