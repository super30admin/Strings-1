// Time Complexity : O(n)
// Space Complexity : O(m), the HashSet
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


public class longestSubStrWORepeats {
    public int lengthOfLongestSubstring(String s) {
        //Sliding window approach
        int max=1, start=0, end=1;
        if(s.length()==0)
            return 0;
        //Set to store if a character is already present or not
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while(end<s.length()) {
            //If current character is present in set, shrink from beginning to remove the first occurance
            if(set.contains(s.charAt(end))){
                //calculate size and assign max if current is greater
                int size = end-start;
                if(size>max)
                    max=size;
                set.remove(s.charAt(start));
                start++;
            } else {
                //If current character is not present add it
                set.add(s.charAt(end));
                end++;
            }
        }
        //Calculate size after last insertion
        int size = end-start;
        if(size>max)
            max=size;
        return max;
    }
}
