/*
Time Complexity : O(s), length of the string
Space Complexity : O(s), length of the result string
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
Approach :
We can keep the character count in an array. We take each character from order string, take its count and repeat it that
many times in the result string. Whatever characters are left in the count array, we can append them to result string in
the same way.
*/
public class CustomSortString {
    public String customSortString(String order, String s) {
        int[] countArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            countArr[curr] += 1;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char curr = order.charAt(i);
            //order characters based on order string
            while(countArr[curr-'a'] > 0){
                result.append(curr);
                countArr[curr-'a'] -=1;
            }
        }

        for(int i = 0; i< countArr.length; i++){
            char curr = (char)(i+'a');
            //append rest of the characters
            while(countArr[i] > 0){
                result.append(curr);
                countArr[i] -=1;
            }
        }

        return result.toString();
    }
}
