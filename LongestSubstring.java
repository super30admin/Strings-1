import java.util.HashSet;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s){
        int left=0;
        int right=0;
        int maxLen=0;
        //create a HashSet to store the characters
        HashSet<Character> set = new HashSet<>();
        //run the loop until right ptr reaches end
        while(right<s.length()){
            //add the value at right ptr to the set and increment the pointer
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                //check the length of right and left and update max length
                maxLen=Math.max(maxLen,right-left); //check the length of right and left and update max length
            }else{
                //if any repeated character encountered remove it from set and increment left ptr
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
    public static void main (String args[]){
     String s = "pwwkew";
     System.out.println("MaxLen : " +lengthOfLongestSubstring(s));
    }
}

//TC : O(n)
//SC :