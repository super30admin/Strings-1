// Time - O(N)

// Space - O(Min(m,n))




class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) return 0;

        HashMap<Character,Integer> map = new HashMap<>(); // store character and index + 1 as a value in hashmap

        int slow = 0;

        int max = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {

                slow = Math.max(slow,map.get(c)); // reset the store pointer by calculating the max between index position of slow and index position of the character from the hashmap

            }

            max = Math.max(max, i - slow + 1);  //


            map.put(c,i + 1); // put in map index + 1 as a value for character


        }

        return max;


    }
}