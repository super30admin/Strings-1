class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0; // base case, if the string is empty or the length of the string is 0, then we simply return 0
        int slow = 0, max = 0;// we create an integer variable called as slow and max which are initialized to 0
        HashMap<Character, Integer> map = new HashMap<>();// we take a hashmap with name map and the key input for it as character and the value input as Integer.
        for(int i = 0; i < s.length(); i++) { // we go through the length of the s string. here i can be considered as the fast pointer
            char c = s.charAt(i);//we take each character present in the string and store it in a character variable called as c.
            if(map.containsKey(c)) { // if map contains the character c
                slow = Math.max(slow, map.get(c)); // we update the slow to take the max betweem the present slow and the value of it in the hashmap
            }
            max = Math.max(max, i - slow + 1);// this is the case if the map dosent contain the key we take the max between the current max and i - slow + 1
            map.put(c, i + 1); // we put the character c in the hashmap with i+1
        }
        return max; //in the end, we return max
    }
}
//tc and sc - O(n) and O(1)