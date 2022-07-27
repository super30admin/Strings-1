//*****LONGEST SUBSTRING WITHOUT REPEATING CHARACHTER-- USING MAP****
//Time complexity:o(n);
//Space complexity:o(1);
//Leetcode runnable: Y;
//Any doubts:N;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Declare map
        HashMap<Character, Integer> map=new HashMap<>();
        //slow pointer
        int slow=0;
        //Max for getting the maximum length of substring
        int max=0;
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            
            if(map.containsKey(c))
            {   
                //It means there is a repeate;
                //Move the slow pointer;
                //we are taking here max because we are not removing anything from the map and if the char has occur first and is into the map but not in the current window it will create a mess.
                slow=Math.max(slow, map.get(c));
            }
            max=Math.max(max, i-slow+1);
            //I am putting i+1 already so that i dont want to add 1 while moving my slow pointer
            map.put(c,i+1);
        }
        return max;
    }
}

//*****LONGEST SUBSTRING WITHOUT REPEATING CHARACHTER-- USING SET****
//Time complexity:o(n)^3;
//Space complexity:o(1);
//Leetcode runnable: Y;
//Any doubts:N;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //null
        if(s==null || s.length()==0)
        {
            return 0;
        }
        if(s.length()==1)
        {
            return 1;
        }
        //HashSet
        HashSet<Character> set=new HashSet<>();
        //Pointers
        int slow=0;
        int fast=1;
        //count var
        int max=0;
        //Intially adding slow into the HashSet
        set.add(s.charAt(slow));
        
        while(fast<s.length())
        {
            char c=s.charAt(fast);
            if(set.contains(c))
            {
                //we need to move the slow pointer till reaching the particular char that is reapating
                while(s.charAt(slow)!=c)
                {
                    //remove from set
                    set.remove(s.charAt(slow));
                    //Move slow
                    slow++;
                }
                //Lastly we have reaxched till character now need to move one more position.
                slow++;
            }
            //At every place calculate count
            max=Math.max(max, fast-slow+1);
            //Add char to set
            set.add(c);
            //Move the fast pointer
            fast++;
            
        }
       return max; 
    }
}
