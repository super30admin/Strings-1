import java.util.Scanner;
import java.util.HashSet;

public class LongestSubstringNoRepeatChar_SlidingWindowHashSet{

        //SLIDING WINDOW - HASH SET - O(N) = 2N
        /**if a character is repeating, build hash set from the character next to the left replica of repeating character
    and update maximum length meanwhile */

    public int lengthOfLongestSubstring(String s) {

        // length of the longest substring variable to be updated
        int longest = 0;

        // left pointer starting from zero
        int left = 0;

        // 26 characters is a constant space
        HashSet<Character> set = new HashSet<>(); //O(1)

        // main iterator = right pointer iterating over string
        for(int right = 0; right < s.length(); right++) { // O(N)

            // current right character of substring
            char rightChar = s.charAt(right);

            if(!set.contains(rightChar)) {

                // add to set if not there
                set.add(rightChar);

            }
            //if current right character is already is set
            else {

                // as long as left character is not same as right character
                while(s.charAt(left) != rightChar) {

                    //remove left character from set
                    set.remove(s.charAt(left));

                    // move left pointer towards right
                    left++;
                }

                //while loop stops at left character = right character, we still need to move left to escape that repeating character
                left++;
            }

            // maximum of existing longest length and length spanning pointers
            longest = Math.max(longest, right - left + 1);
        }
        //output
        return longest;
    }

    public static void main(String[] args) {

        LongestSubstringNoRepeatChar_SlidingWindowHashSet obj
                = new LongestSubstringNoRepeatChar_SlidingWindowHashSet();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            int answer = obj.lengthOfLongestSubstring(input);

            System.out.println(answer);


    }


}

/*
TIME COMPLEXITY = O(N)
N = length of string

while loop is not actually nested

// for string: "abcdefa"
both left and right move n length each = 2n - worst case

SPACE COMPLEXITY = O(1)
*/
