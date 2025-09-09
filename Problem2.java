
//Time Complexity: O(n) where n is the length of the string
//Space Complexity: O(min(m,n)) where m is the size of the charset and n is the length of the string


//we use a sliding window approach to keep track of the longest substring without repeating characters
//we use a hashset to store the characters in the current window
//we use two pointers, one to iterate through the string and the other to keep track of the start of the window
//if we encounter a repeating character, we move the start pointer to the right until the repeating 
//character is removed from the window we update the maximum length of the window at each step.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length(),max=0,slow=0;
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<n;i++){
            char z=s.charAt(i);
            if(set.contains(z)){
                while(s.charAt(slow)!=z){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            set.add(z);
            max=Math.max(max,i-slow+1);
        }
        return max;
    }
}