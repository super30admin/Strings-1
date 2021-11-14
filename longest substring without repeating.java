//Timecomplexity:- O(n)
//Spacecomplexity:-O(n);
//Did it run on leetcode:- yes.
//What problems did you face?:- got runtime errors.
//Your code with explanation:- for different characters adding every charecter as key and index+1, if same character repeated once again
//moving start pointer accordingly.







class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashMap<Character,Integer> cache=new HashMap<>();
        int max=Integer.MIN_VALUE;
        int start=0;
        int end=0;
        if(s==null|| s.length()==0){
            return 0;
        }
        while(end<s.length()){
            char ch=s.charAt(end);
            if(cache.containsKey(ch)){
                start=Math.max(start,cache.get(ch));
            }
            cache.put(ch,end+1);
                max=Math.max(max,end-start+1);
                end++;
            
            
        }
    return max;}
}