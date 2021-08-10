// Time Complexity : o(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String order, String s) {
        
        if(s==null||s.length()==0)
            return s;
        
        HashMap<Character,Integer> hm=new HashMap<>();
        
        StringBuilder sb=new StringBuilder();
        
        //updating count in maap for every character in string
        
        for(int i=0;i<s.length();i++)
        {
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        
        // placing characters of order string in to stringbuilder
        for(int i=0;i<order.length();i++)
        {
            char ch=order.charAt(i);
            
            if(hm.containsKey(ch))
            {
                int count=hm.get(ch);
            
            while(count>0)
            {
                sb.append(ch);
                count--;
            }
            
            hm.remove(ch);
            }
            
        }
        
        for(char c: hm.keySet())
        {
           int count=hm.get(c);
            
            while(count>0)
            {
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}