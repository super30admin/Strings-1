//Time Complexity : O(n) //n is size of input string
//Space Complexity : O(26)

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap();

        //left pointer
        int left = 0;
        int max = 0; // gloabl max length
        //i will act as right pointer
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            //c is in map already, so c has repeated
            if(map.containsKey(c))
            {
                //get its prev index where we can place the low pointer in order to escape repating this char in our window
                int index = map.get(c);
                //put slow at max of slow or index of last c occurence
                left = Math.max(left, index);
            }
            map.put(c, i+1);
            //update max length
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
