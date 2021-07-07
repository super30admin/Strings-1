// Time Complexity : O(S+T)
// Space Complexity : O(26)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        int[] frequency = new int[26];
        
        //populate
        for(char ch : T.toCharArray())
        {
            int index = ch - 'a';
            frequency[index]++;
        }
        
        //custom order
        for(char ch : S.toCharArray())
        {
            int index = ch - 'a';
            int count = frequency[index];
            writeChar(sb, ch, count);
            frequency[index] = 0;
        }
        
        //left over character
        for (int i=0;i<26;i++)
        {
            char ch = (char)('a'+i);
            writeChar(sb, ch, frequency[i]);
            frequency[i]=0;
        }
        return sb.toString();
    }
    private void writeChar(StringBuilder sb, char ch, int n)
    {
        while(n > 0)
        {
            sb.append(ch);
            n--;
        }
    }
}
