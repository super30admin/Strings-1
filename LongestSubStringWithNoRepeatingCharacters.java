
//Time: O(n)
//Space: O(n)
//Did it run successfully in leetcode: yes
class LongestSubStringWithNoRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        //map to store index of unique character
        HashMap<Character, Integer> map =new HashMap<>();
        //variable to store maximum length substring
        int max = 0;
        //variable to store count of current substring
        int count = 0;
        //variable to keep track of start of subString
        int slow = 0;
        //looping through the input string
        for(int fast=0; fast<s.length(); fast++){
            //get current character
            Character c= s.charAt(fast);
            //if character already present in map
            if(map.containsKey(c)){
                //get index of character
                int ind = map.get(c);
                //if starting index of current substring smaller or equal to index of current character
                if(slow<=ind){
                    //update starting index
                    slow = ind+1;
                }
            }
            //update index of current character if already exist or create new key value pair
            map.put(c, fast);
            //get length of current substring
            count = fast-slow + 1;
            //update maximum substring length
            max = Math.max(max, count);

        }

        return max;

    }
}