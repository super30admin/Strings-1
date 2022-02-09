//Time complexity : O(n) where n is length of string
//Space complexity : O(n) for hashmap
class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> hm=new HashMap<>();
        int slow=0,fast=0;
        char c;
        int maxLength=1;
        if(s.length()==0){
            return 0;
        }
        while(fast<s.length()){
            // System.out.println("fast = "+fast);

            c=s.charAt(fast);
            if(hm.containsKey(c) && slow<=hm.get(c)){
                // System.out.println("c = "+c);
                slow=hm.get(c)+1;
                // if(fast-slow>maxLength){
                //     maxLength=fast-slow;
                // }
                hm.put(c,fast);
            }else{
                hm.put(c,fast);
                if(fast-slow+1>maxLength){
                    maxLength=fast-slow+1;
                }
                // System.out.println("maxlength = "+maxLength);

            }
            fast=fast+1;
        }

        return maxLength;


    }
}