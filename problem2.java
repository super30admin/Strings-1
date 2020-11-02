// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, 7ms

// Your code here along with comments explaining your approach

// Slide the window through the array and if the character is not present add and increment the head pointer else increase the tail pointer, return the maximum of max length and set size
    public int lengthOfLongestSubstring(String s) {
        
        int head = 0, tail = 0, max = 0;
        
        Set<Character> set = new HashSet<>();
        
         while(tail <= head && head < s.length()){ // Slide through the window
             char c = s.charAt(head);
            if(!set.contains(c)){
                set.add(c);
                max = Math.max(max, set.size());
                head++;
            }
            else{
                set.remove(s.charAt(tail));
                tail++;
            }
            
        }
        
        return Math.max(max, set.size());
        
    }
}