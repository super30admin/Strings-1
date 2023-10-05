/*
    Time Complexity - O(n) where n is the length of str. Maximum length of order is just 26. Hence length of order can be ignored.
    Space Complexity - O(1) excluding the size of the ouput string. Count[] is of fixed size 26, hence can be considered O(1). 
 */
class Solution {
    public String customSortString(String order, String str) {
        int[] count = new int[26];

        for (char ch : str.toCharArray()) 
            ++count[ch - 'a'];      

        StringBuilder sb = new StringBuilder();

        for (char ch : order.toCharArray())                            
            while (count[ch - 'a']-- > 0) 
                 sb.append(ch);  
    
        for (char ch = 'a'; ch <= 'z'; ++ch)
            while (count[ch - 'a']-- > 0) 
                sb.append(ch);     
        
        return sb.toString();
   }
}
