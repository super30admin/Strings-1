// TC: O(n*m) where n is the length of the string and m is the substring length
// SC: O(1)

public class LongestSubStringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s == null)
            return 0;
        // setting default length to one since we are adding one character to the result string
        int op = 1;
        String str = Character.toString(s.charAt(0)); 
        for(int i=1; i<s.length(); i++){
            // Checking if the character is not in to string
            if(!str.contains(Character.toString(s.charAt(i)))){
                str += Character.toString(s.charAt(i));
            }
            else{
                // Updating the length of the string before removing the string elements 
                if(op < str.length()){
                    op = str.length();
                }
                // Checking if previous elements is not same as the current
                if(i-1 >= 0 && s.charAt(i-1) != s.charAt(i)){
                    int index = 0;
                    // Fetching the index of the same character and then generating the substring with appending the current character at the end
                    for(int j=0; j<str.length(); j++){
                        if(s.charAt(i) == str.charAt(j)){
                            index = j;
                            break;
                        }
                    }
                    str = str.substring(index+1, str.length())+Character.toString(s.charAt(i));
                }
                // Directly clearing the previous string and adding the current character
                else{
                    str = Character.toString(s.charAt(i));
                }
            }            
        }
        // if strings length is greater then the output length
        if(op < str.length()){
            op = str.length();
        }
        return op;
    }
    
}