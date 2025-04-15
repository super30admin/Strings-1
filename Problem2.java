public class Problem2 {
    class Solution {
        //t.c -> O(n)
        //s.c -> O(1)
        public int lengthOfLongestSubstring(String s) {
            if(s==null|| s.length()==0){
                return 0;
            }
            int length = s.length();
            //map of character of string and which index it was seen
            HashMap<Character,Integer> map = new HashMap<>();
            int max = 0;
            int ptr1 = 0;//this will help us with the starting point of the substring and it'll move when we've seen a repeated character
            for(int i = 0 ;i<length;i++){
                char c = s.charAt(i);
                //it means we've seen the character before, now time to move the ptr1
                if(map.containsKey(c)){
                    ptr1 = Math.max(ptr1,map.get(c));
                }
                //check if the current substring is max which will be last ptr1- start ptr +1
                max = Math.max(max,i - ptr1+1);
                //now we put the value in the map with where we've found it
                map.put(c,i+1);
            }
            return max;
        }
    }
}
