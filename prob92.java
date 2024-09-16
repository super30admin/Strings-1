class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        int[] arr = new int[256];
        int slow=0;
        int fast=0;
        int max=0;
        while(fast<s.length()){
            if(arr[s.charAt(fast)] > 0){
                slow = Math.max(slow,arr[s.charAt(fast)]);
            }
            arr[s.charAt(fast)]=fast+1;
            max=Math.max(max,fast-slow+1);
            fast++;
        }
        return max;
        
    }
}