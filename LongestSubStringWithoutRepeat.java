// Time Complexity : O(N)
// Space Complexity : O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int beginIndex = 0;
        //Stores character with its last occurance;
        HashMap<Character, Integer> hs = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //Check if already there update begginging Index
            if(hs.containsKey(c)){
                // Check if the occurance of it is after the current begin Index
                if (hs.get(c) >= beginIndex)  beginIndex = hs.get(c)+1;
            }
             //Add the character with its index and increment length
            hs.put(c,i);
            max = Math.max(i-beginIndex+1,max);
        }
        return max;
    }
}