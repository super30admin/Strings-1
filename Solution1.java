//TC: O(n)
//SC:o(1)
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hmap=new HashMap<>();
        int slow=0;
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(hmap.containsKey(ch))
            {
                slow=Math.max(slow,hmap.get(ch)+1); //we need to get next char after slow and compare it with our slow
            }
            //if no char is repeating
            hmap.put(ch,i); //character and its index
            max=Math.max(max,i-slow+1);//record max length for every iteration
        }
        return max;
        
    }
}