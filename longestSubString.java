//time complexity O(n)
//space complexity O(n) due to stringbuilder
//approach iterate over the string using two pointers if char already present in map then 
//move slow pointer to that value+1 and update the value of char.
//handle the case of slow pointer moving backwards by taking max of indices

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null) return 0;
        int slow=0;
        int len=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                slow=Math.max(slow,map.get(c));
            }
            map.put(c,i+1);
            len=Math.max(len,i-slow+1);
        }
        return len;
    }
}