
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Frequency Map
 */

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> freq=new HashMap<>();

        for(int i=0;i<s.length();i++){
            freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)+1);
        }

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<order.length();i++){
            char c=order.charAt(i);
            int count=freq.getOrDefault(c,0);
            while(count>0){
                sb.append(c);
                count--;
            }
            freq.remove(c);
        }

        for(char c: freq.keySet()){
            int count=freq.get(c);
            while(count>0){
                sb.append(c);
                count--;
            }
        }

        return sb.toString();

    }
}




