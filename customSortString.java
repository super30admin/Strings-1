class Solution {
    public String customSortString(String order, String s) {
        
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        String result="";
        
        for(int i=0;i<order.length();i++)
        {
            char c=order.charAt(i);
            int size=map.getOrDefault(c,0);
            for(int j=0;j<size;j++)
                result=result+c;
            map.remove(c);
        }
        
        for(char c : map.keySet())
        {
            int size=map.get(c);
            for(int j=0;j<size;j++)
                result=result+c;
        }
        
        return result;
        
    }
}

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no