/*Brute force: 
1. Pick every char from the order and check it in the str
2. If it exists, add it to the result and to a hashset
3. When done, go through the str again, and add the chars not present in the hashset to the result

Time complexity: O(m*n+n)
Space complexity: O(M): for hashset
*/

class Solution {
    public String customSortString(String order, String str) {
        int i=0; int j=0;
        StringBuilder result = new StringBuilder();
        HashSet<Character> remaining = new HashSet();
        while(i <= order.length()-1)
        {
            j=0;
            while(j <= str.length()-1)
            {
                if(str.charAt(j)==order.charAt(i))
                {
                    result.append(str.charAt(j));
                    remaining.add(str.charAt(j));
                }
                j++;
            }
            i++;
        }
        for(int k=0; k<= str.length()-1; k++)
        {
            if(!remaining.contains(str.charAt(k)))
                result.append(str.charAt(k));
        }
        return result.toString();
    }
}