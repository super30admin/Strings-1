package s30.strings.s1;

import java.util.HashSet;
import java.util.Set;


//Algo: maintain a set of visited characters, start and end pointers.
// when yiu see a visited character  move your start index to previous occurance plus 1 index.

//TC O(n) n => length of the string.
//SC O(1)
public class LongestSubstringRepeat {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> store = new HashSet();
        int start =0, end =0;

        int count =0;

        while(end < s.length()){

            char ch = s.charAt(end);
            if(store.contains(ch)){

                store.remove(s.charAt(start++));

            }
            else {
                store.add(ch);
                count = Math.max(count, end - start + 1);
                end++;
            }


        }
        return count;

    }
    public static void main(String[] args) {

    }
}
