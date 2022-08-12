//Time Complexity: O(n); where n is the length of the string s
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem2 {

    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0)
            return 0;
        
        HashMap<Character,Integer> map = new  HashMap<>();
        
        int slow = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(map.containsKey(c)){
                
                slow = Math.max(slow, map.get(c) + 1);
                max = Math.max(max, i-slow+1);
                map.put(c,i);
                
            }
            else{
                max = Math.max(max, i-slow+1);
                map.put(c,i);
            }
        }
        
        return max;
    }
}
