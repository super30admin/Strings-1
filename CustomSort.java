/*Time Complexity : O(n+m)
Space Complexity : O(n)
Did it run on LeetCode : yes.
Any Problems : No.
*/


class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder string = new StringBuilder();
        
        for(char t : T.toCharArray())
        {
            if(!map.containsKey(t)) map.put(t,1); // if value not in map, add to map.
            else
                map.put(t,map.get(t)+1); // If the value of t is already present in the map then just increase the count of that letter.
        }
        
        for(char s : S.toCharArray())    // Check if the letter is present in the Hashmap or not. 
        {
            if(map.containsKey(s))  // if present : add the letter to the string the number of times it occurs.
            {
                for(int i=0;i<map.get(s);i++)
                {
                    string.append(s);    
                }
                map.remove(s); // once added to string builder, remove from map.
            }
        }
         
        for(char c : map.keySet()) // run this loop for adding the remaining characters not present in the string S but present in string T.
        {
            for (int i=0; i<map.get(c);i++)
            {
                string.append(c);
            }
        }
        
        return string.toString(); // Convert string builder to String and return.
    }
}