//https://leetcode.com/problems/custom-sort-string/
// Time Complexity : O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map=new HashMap<>();//character and its frequency
        for(int i=0;i<s.length();i++) //iterating to s and create frequency map
        {
            char c=s.charAt(i);
            if(!map.containsKey(c))
                map.put(c,0);
            map.put(c,map.get(c)+1);
        }
        StringBuffer result=new StringBuffer();
        for(int i=0;i<order.length();i++) 
        {
            char c=order.charAt(i);
            if(map.containsKey(c))
            {
                int freq=map.get(c);
                while(freq>0)
                {
                    result.append(c);
                    freq--;
                }
                map.remove(c);  //remove the elements of order in hashmap of s
            } 
        }
        for(Character c:map.keySet())
        {
             int freq=map.get(c);
            while(freq>0)
                {
                    result.append(c);
                    freq--;
                }
        }
        return result.toString();
        
    }
}