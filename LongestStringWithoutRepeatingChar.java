class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        //declaring a set to keep track of letters we invoked
        Set<Character> set = new HashSet<>();
        
        //Initializing slow and fast pointers to index 0
        //result is also initialized to 0
        int slow = 0;
        int fast = 0;
        int res = 0;
        
        //iterating through the string until the slow and fast pointers does not exceed the limit 
        while(slow < n && fast < n){
            
            //if the element at fast pointer is not present in the set then
            //add element to the set and update res and fast pointer
            //else remove the element from set and update slow pointer
            if(!set.contains(s.charAt(fast))){
                set.add(s.charAt(fast));
                fast++;
                res = Math.max(res, fast - slow);
            }else{
                set.remove(s.charAt(slow));
                slow++;
            }
        }
        
        return res;
    }
}
// Time Complexity : O(n) n->length of string
// Space Complexity: O(n)

