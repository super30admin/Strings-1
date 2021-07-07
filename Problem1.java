// Time Complexity :O(M+N) -> M - ordered string length; N - given String
// Space Complexity :O(M) -> HashMap to store order of characters in ordered string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We will use a hashmap to store the character and its rank for each character in ordered string S.
// 2. We create an array to store frequency of characters of ordered string.
// 3. we iterate through each character in given string , and if it is present in hash set then we increment its count in character array,
//    else we append the character to string builder .
// 4. Now since each element in array stores frequency of elements of ordered string , if frequency > 0 , we add each character its value
//    times to string builder.
// 5. return final stringbuilder.
import java.util.HashMap;

public class customSortString {
    public static String customSortString(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        int rank = 0;
        for(char c:S.toCharArray())
            map.put(c,rank++);
        StringBuilder sb = new StringBuilder();
        int[] chararr = new int[S.length()];
        for(char c:T.toCharArray()){
            if(!map.containsKey(c))
                sb.append(c);
            else
                chararr[map.get(c)]++;
        }
        for(int i = 0;i<chararr.length;i++){
            while(chararr[i]>0){
                sb.append(S.charAt(i));
                chararr[i]--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "cba";
        String T = "abecd";
        System.out.print(customSortString(S,T));
    }
}
