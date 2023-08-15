// Time Complexity : O(m+n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will be going through the source string and create a hashmap containing the characters of the string and its frequency. 
// Then we will go through the order string and check the hashmap to get the frequency of the character. Then append it to the resultant srting those many number of times. 
// Then we remmove it from the hashmap. In the end whatever is left in the hashmap, we append it to the string 


class Solution {
    public String customSortString(String order, String s) {
        //hashmap for the given String
        HashMap<Character,Integer> map=new HashMap<>();
        StringBuilder result=new StringBuilder();
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //we will iterate through order
        for(int i=0;i<order.length();i++)
        {
            char c=order.charAt(i);
            //if the character in order is present in the map
            if(map.containsKey(c))
            {
                //we will append it to the result as many times as the frequency in the map
                for(int j=0;j<map.get(c);j++)
                {
                    result.append(c);
                }
                //after adding it to the result, we remove it from the map
                map.remove(c);
            }
        }
        //in the end if there are still characters in the map left
        
        for(char Key:map.keySet())
            {
                int count=map.get(Key);
                for(int k=0;k<count;k++)
                {
                    result.append(Key);
                }
            }

        return result.toString();
    }
}