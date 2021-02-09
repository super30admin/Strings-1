//TC: O(n)
//SC: O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int slow =0; int maximum  = 0; 
        for(int i =0; i< s.length(); i++){
            char c =  s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, i+1);
            maximum = Math.max(maximum, i - slow+1);
            
        } return maximum;
        
    }
}
