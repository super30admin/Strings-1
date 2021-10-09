// Time Complexity :O(m+n) n= length of String
// Space Complexity :O(m) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/* put all the characters of main string in HashMap along with their freq
/* run a loop over orderString and check each char if it is in Map or not if it is in map 
get the freq and add that character in stringbuilder for as any times as freq is and keep removing that character from the Map. at last add all the remaining character of map in stringbuilder. return stringbuilder*/


class Solution {
    public String customSortString(String order, String s) {
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
      
       for(int i =0; i< s.length(); i++)
        {   char c =  s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        StringBuilder  sb = new StringBuilder();
        
       for(int i =0; i< order.length(); i++)
        {   char c =  order.charAt(i);
            if(map.containsKey(c))
            {
                int count = map.get(c);
                while(count >0)
                {
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
      
        
     for(Map.Entry<Character,Integer> entry : map.entrySet())
     {  
         int count = entry.getValue();
         char key = entry.getKey();
                while(count >0)
                {
                    sb.append(key);
                    count--;
                }
          
    }

        return sb.toString();
    }
}