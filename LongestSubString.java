// Time Complexity : O(n) where n is the number of elements in the string.
// Space Complexity : O(26)- hashmap can have atmost 26 charcter keys.

class Solution {
    public int lengthOfLongestSubstring(String s) {        
        if(s==null ||s.length()==0) return 0;
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        int max = 0; 
        int slow = 0; 
        int fast = 0;     
        while(fast < s.length()){
           if(map.containsKey(s.charAt(fast))){
               slow = Math.max(slow,map.get(s.charAt(fast)));
           }
            map.put(s.charAt(fast),fast+1); 
            max = Math.max(fast-slow+1,max);           
            fast++;
           }
            return max;
    }
}
// Time Complexity : O(n*n) where n is the number of elements in the string.
// Space Complexity : O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        if (s.length() < 2)
            return s.length();
        
        for(int i = 0; i < s.length(); i++) {            
            if(sb.toString().indexOf(s.charAt(i)) == -1) {
                sb.append(s.charAt(i));                
            }
            else {
                if (count < sb.length())
                    count = sb.length();
                sb.delete(0,sb.toString().indexOf(s.charAt(i))+1);
                sb.append(s.charAt(i));
            }
        }
        if (count < sb.length())
                    return sb.length();
        return count;
    }
}