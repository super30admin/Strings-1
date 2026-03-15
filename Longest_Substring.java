/*
Approach: we use sliding window,
we add characters inside hashset until we hit a duplicate
we move the slow pointer until the duplicate value to add new char
inside hashset for next addition
we check the window size using a max variable and 
finally return the max size as size of longest substring.
 */

/*
Time: O(2n), --> O(n)
Space: O(1) -- 126 characters
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int slow = 0;
        int n = s.length();
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                while(s.charAt(slow) != c){ // remove untill the duplicate
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }

            set.add(c);
            max = Math.max(max, i-slow+1);

        }

        return max;
        
    }
}