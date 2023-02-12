class Solution {
    
    
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> seen = new HashSet<>();

        int left = 0;
        int right = 0;
        int max_len = 0;

        while(right < s.length()){

            char curr = s.charAt(right);
            while(!seen.isEmpty() && seen.contains(curr)){

                seen.remove(s.charAt(left));
                left ++;

            }

            seen.add(curr);
            max_len = Math.max(max_len, right - left + 1);
            right++;

        }

        return max_len;
       
    }
    
}  