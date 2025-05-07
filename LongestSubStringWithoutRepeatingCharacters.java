import java.util.HashMap;
import java.util.HashSet;
//TC O(n)
//SC O(n)

/*
This solution uses a sliding window technique with two pointers (slow and i) to track the current
substring. A hashmap stores each character's most recent index for quick duplicate checks.
When a duplicate is found, the slow pointer jumps past the previous occurrence to maintain a
valid window. The window size (i - slow + 1) is continuously updated to track the maximum length.
By processing each character just once, it efficiently finds the longest substring without repeating
characters
* */
class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int slow=0;
        int max=0;

        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(map.containsKey(c))
            {
                //dont take old index
                slow=Math.max(slow,map.get(c)+1);

            }
            map.put(c,i);
            max=Math.max(max,i-slow+1);
        }


        return max;
    }
    public int lengthOfLongestSubstring2(String s) {
        /*
        in brute force we have nested iterations
        to optimize on nested iterations we have
        sliding window
        two ptrs
        binary search
        running sum + hashing

         */


        //instead of set can use array

        //O(2n) two pass happens because of slow ptr..if we store the index we can eliminate that pass

        //so for that we store in hashmap
        //but then if we use those indexes...we might have old indexes which are not relevant as they are before slow pointer
        //hence while using old indexes...we have to check if they are before slow ptr..if yes dont use

        int slow=0;

        int max=0;
        int n=s.length();
        HashSet<Character> set=new HashSet<>();

        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(set.contains(c))
            {
                while(s.charAt(slow)!=c)
                {
                    //this does not run in few cases for example dvdf..when slow pointer itself is on the char
                    //which is duplicate
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            set.add(c);
            max=Math.max(max,i-slow+1);
        }

        return max;
    }
}
