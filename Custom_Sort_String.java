//Time Complexity: O(length(S)+length(T))
//Space Complexity: O(length(T))

class Solution {
    public String customSortString(String S, String T) {
        
        if(S == null || S.length()==0)
            return T;
        
        if(T == null || T.length()==0)
            return S;
        
        int[] T_array = new int[26];
        
       //insert all the chars from T into an Index array
        for(char c: T.toCharArray())
        {
            T_array[c-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        //loop through each element in S and if its present in index array, add it to the final result string
        for(char c : S.toCharArray())
        {
            int count = T_array[c-'a'];
            while(count > 0)
            {
                sb.append(c);
                count--;
            }
            T_array[c-'a'] = 0;
        }
        
        //now add the remianing chars from T into the result string
        for(char ch: T.toCharArray())
        {
            
        }
        
        
        for(char ch='a'; ch<='z'; ch++)
        {
            for(int i=0; i< T_array[ch-'a']; i++)
            {
                sb.append(ch);
            } 
        }
        
        return sb.toString();
    }
}
