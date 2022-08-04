// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public String customSortString(String order, String str) {
       HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<str.length();i++)    // creating the frequency of each character using hashmap
        {
            if(hm.containsKey(str.charAt(i)))
               hm.put(str.charAt(i),hm.get(str.charAt(i))+1);
            else
               hm.put(str.charAt(i),1);
        }
        String res ="";
        
        for(int i=0;i<order.length();i++)
        {
            char ch=order.charAt(i);
            if(!hm.containsKey(ch))        //  If the string character is not present in the order string
                continue;
            int freq = hm.get(ch);
            for(int j=0;j<freq;j++)
                res+=Character.toString(ch);     // appending the result
            hm.remove(ch);         // freeing the hashmap
        }
        
        for(Character key : hm.keySet()) // Appending Remaining characters that are not present in the order string
        {
            int freq = hm.get(key);
            for(int j=0;j<freq;j++)
                res+=Character.toString(key);
        }
               return res;
    }
}

