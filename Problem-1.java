//Time Complexity:O(n)
//Space Complexity: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() == 0) return 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        int max = Integer.MIN_VALUE;
        
        int start =0;
        int end =0;
        while(end<s.length()){
            char ch = s.charAt(end);
            
            if(map.containsKey(ch))
                start = Math.max(start, map.get(ch));
                map.put(ch, end+1);
                max = Math.max(max, end-start +1);
                end ++;
            
        }
        return max;
    }
}