// TC - O(n) where n = str.length
// SC - O(1)

class Solution {
    public String customSortString(String order, String str) {
        int[] charCount = new int[26];   
        
        // count the characters in the str array
        for(char c: str.toCharArray()) {
            charCount[c-'a']++;    
        }      
        
        StringBuilder sb = new StringBuilder();
      
        // create a stringbuilder and append each character from the order array * its respective count 
        for (char c : order.toCharArray()) {                            
            while (charCount[c - 'a'] > 0) { 
                sb.append(c); 
                charCount[c-'a']--;   
            }   
        }

        // append the remaining characters from str that were not a part of the order string
        for (char c : str.toCharArray()) {                            
            while (charCount[c - 'a']-- > 0) { 
                sb.append(c); 
            }    
        }
        
        return sb.toString();
    }
}
