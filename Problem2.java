// sliding window
// 2 o(n) complexity
//o(1) space complexity since max of 26 characters we are going to store

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0; 
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i< s.length(); i++){
            if(set.contains(s.charAt(i))){

                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(left));
                    left++;

                }

            }
            set.add(s.charAt(i));
            max = Math.max(max, set.size());
        }
            return max;
        
    }
}
