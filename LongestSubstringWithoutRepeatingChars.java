import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {
    public static int lengthOfLongestSubstringHashSet(String s) { //O(2n) T.C, O(1) S.C
        int slow = 0; //pointer
        int count = 0; //result
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) { //fast pointer
            char c = s.charAt(i);
            if(set.contains(c)) { //if the set already contains the current char, means repeat
                while(s.charAt(slow) != c) { //until the char at slow pointer doesn't equal current char
                    set.remove(s.charAt(slow)); //remove all the chars from the current window
                    slow++; //and increment the pointer
                }
                slow++; //increment one more time to skip the duplicated char as well
            } else {
                set.add(c); //the first occurrence of current char
                count = Math.max(count, (i-slow+1)); //the length of substring is between slow and fast pointers
            }
        }
        return count;
    }

    public static int lengthOfLongestSubstringHashMap(String s) { //O(n) T.C
        int slow = 0; //pointer
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>(); //O(1) S.C

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) { //if duplicate found
                slow = Math.max(slow, map.get(c) + 1); //increment the index of slow pointer to current char + 1
                //There could a scenario where slow has already crossed the earlier duplicate, hence we take the max
                //between slow and current char index. This is similar to above sol but skips traversing all elements.
            }
            map.put(c, i); //put the current char and the fast pointer into the map
            count = Math.max(count, (i-slow+1));
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "abdabcdnitin";
        System.out.println("The length of the longest substring in " + s1 + " using hashset is: " +
                lengthOfLongestSubstringHashSet(s1));

        String s2 = "halamathihabibo";
        System.out.println("The length of the longest substring in " + s2 + " using hashmap is: " +
                lengthOfLongestSubstringHashMap(s2));
    }
}