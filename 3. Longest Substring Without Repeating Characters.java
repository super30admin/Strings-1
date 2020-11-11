class Solution {// time and space of O(n)
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        int max = 0;
        int start = 0;
        
        //Iterate the string
        for(int curr = 0 ; curr < s.length() ; curr++){
            char ch = s.charAt(curr);
            if(hmap.containsKey(ch)){
                start = Math.max(hmap.get(ch)+1, start) ;
            }
            max = Math.max(curr-start+1 , max);
            hmap.put(ch,curr);
        }
        return max;
    }
}