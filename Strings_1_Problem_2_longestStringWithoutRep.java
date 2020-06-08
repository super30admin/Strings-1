import java.util.HashSet;

//Time Complexity: O(n) (worst case will be n+n as we'll be using two pointers here)
//Space Complexity: O(n) For storing non repeating numbers in the hashset
//Runs successfully on leetcode
//No problem

//Here we will be traversing fast pointer untill we find any repeats, same time we'll be checking for max length
//If we find any repeatins we'll be removing those elements with the slow pointer untill there are no more repeats

public class Strings_1_Problem_2_longestStringWithoutRep {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;

        HashSet<Character> hs = new HashSet<>();

        while(j != s.length())
        {
            if(!hs.contains(s.charAt(j)))
            {
                hs.add(s.charAt(j));
                j++;
                max = Math.max(max,hs.size());
            }
            else
            {
                hs.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
