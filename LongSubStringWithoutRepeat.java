/*Approach: 
1. Store the index of the chars in a map
2. Use 2 pointers, 1 pointing to the char that is repated and another to loop through the string
3. The moment a char is repeated, set teh slow pointer to the next char of the repeated char

Time Complexity: O(N)
Space complexity: O(N)
*/
class Solution {
    int max=0;
    HashMap<Character, Integer> map = new HashMap<>();
    
    public int lengthOfLongestSubstring(String s) {
        int i =0; int j=0;
        while(i<=s.length()-1)
        {
            char c = s.charAt(i);
            if(!map.containsKey(c))
            {
                map.put(c,i);
            }
            else
            {
                if(map.get(c)>=j)
                    j = map.get(c)+1;
                map.put(c,i);
            }
            i++;
            max = Integer.max(max,i-j);
        }
        return max;
    }
}