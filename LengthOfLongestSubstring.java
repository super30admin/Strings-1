class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }
        int start = 0;
        int end = 1;
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put(s.charAt(0),0);
        while(end<s.length()){
            if(hm.containsKey(s.charAt(end))){
                int count = end-start;
                max = Math.max(count, max);
                if(start<hm.get(s.charAt(end))+1)
                start = hm.get(s.charAt(end))+1;
            }
                hm.put(s.charAt(end),end);
                end++;
        }
        max = Math.max(max, end-start);
        return max;
    }
}

//Time complexity : O(n) where n is the length of string
//Space complexity : O(k) where k is the size of hashmap
