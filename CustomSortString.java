/* Approach:
1. Go through the str and add the count for every char in a int array (store count at index)
2. Go through order and if the char exists in the str, add it that many times to the result string
3. Finally loop through the remaining keys and add them to the result

Time complexity: O(N), m would at max 26
Space complexity: O(1): for array: at max 26 chars
*/

class Solution {
    public String customSortString(String order, String str) {
        int[] map = new int[26];
        StringBuilder result = new StringBuilder();
        for(int k=0; k <= str.length()-1; k++)
        {
            char c = str.charAt(k);
            map[c-'a']+=1;
        }
        
        for(int i=0; i<=order.length()-1; i++)
        {
            char c = order.charAt(i);
            if(map[c-'a']!=0)
            {
                int count = map[c-'a'];
                for(int j=0; j<=count-1; j++)
                {
                    result.append(c);
                }
                map[c-'a']=0;
            }
        }
        
        for (char c = 'a'; c <= 'z'; c++)
            for (int i = 0; i < map[c - 'a']; i++)
                result.append(c);
        
        return result.toString();
    }
}