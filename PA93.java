//Leetcode : 3. Longest Substring Without Repeating Characters
//Time Complexity: O(n) // n is number of char in string s
//Space Complexity: O(1) // As the size of hashmap will be of at max 26 char
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0; 
        int low=0;
        int len = s.length();
        int j=0;
        int maxLen=1;
        HashMap<Character, Integer> hm = new HashMap<>();
        while(j<len){        
            if(!hm.containsKey(s.charAt(j)) || hm.get(s.charAt(j))<low ){
                   maxLen= Math.max(maxLen, (j-low)+1);
                }
                else{
                    maxLen= Math.max(maxLen, (j-low));
                    low= hm.get(s.charAt(j)) +1;
                   }
                  hm.put(s.charAt(j),j);
            j++;
        }       
        return maxLen;
    }
}