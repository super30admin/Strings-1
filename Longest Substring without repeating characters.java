// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will maintain two pointers slow and fast starting from index 0. We will keep adding characters and 
// their indices in a hashmap while iterating through the string using the fast pointer. Whenever we come across a 
// character in the string which is already present in the hashmap, we will check if the its index lies between slow and fast. 
// If yes, then we will set slow=index+1 and update the new index in the map. 
// If it is not then we will update the new index in the map and keep moving the fast pointer.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int slow=0; //slow pointer
        int max=0;  //length of the lengthOfLongestSubstring

        for(int i=0;i<s.length();i++)   //i is the fast pointer
        {
            char c=s.charAt(i); //character at index i
            if(map.containsKey(c)) //if the character is present in the map
            {
                //we will check if the value at the character in the map is greater than slow. 
                slow = Math.max(slow, map.get(c) + 1);
            }
            //if the character is not present in the hashmap
            map.put(c,i);
            max=Math.max(max,(i-slow)+1);
        }

        return max;
    }
}



//Using HashSet

//We will maintain two pointers slow and fast starting from index 0. We will keep adding characters to a hashSet while iterating through the string using the fast pointer. Whenever we come across a character in the string which is already present in the hashmap, we will move the slow pointer, and removing the characters from the hashmap until we find the duplicate character. 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int slow=0; //slow pointer
        int max=0;  //length of the lengthOfLongestSubstring

        for(int i=0;i<s.length();i++)   //i is the fast pointer
        {
            char c=s.charAt(i); //character at index i
            if(set.contains(c))
            {
                while(s.charAt(slow)!=c) //we will keep moving the slow pointer until we find the duplicate character
                {
                    set.remove(s.charAt(slow)); //remove the character from the HashSet
                    slow++;     //increment the slow pointer
                }
                //when we get the character int the string
                slow++;
            }
            //if the character is not present in the hashSet
            set.add(c);
            max=Math.max(max,(i-slow+1));
        }

        return max;
    }
}