// TC - O(n) n = str.length
// SC - O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;

        HashSet<Character> set = new HashSet<>();
        int index = 0;
        int result = Integer.MIN_VALUE;

        // add the elements to a set as we traverse through the given input string
        // if we encounter an element that already present in the set, remove the elements from the set starting at index and increment the index
        // till the set doesnt contain the current element (basically we are sliding the window of valid longest substring without repeatition)
        // update the size of the longest substring without repeatition accordingly.
        for(int i=0; i<s.length(); i++) {
            while(set.contains(s.charAt(i))) {
                set.remove(s.charAt(index++));
            }
            
            set.add(s.charAt(i));
            result = Math.max(result, set.size());
            
        }
      
        return result == Integer.MIN_VALUE? set.size(): result;
    }
}
