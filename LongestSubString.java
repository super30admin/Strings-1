import java.util.HashMap;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/

/*
* We take 2 pointers start and end. Create a hashmap which maintains the entries of all characters of the string
* with their occurrences index. We also maintain a max variable which gives the max length of the substring.
* If a repeated character is encountered change the start pointer
*TC - O(n)
* SC - O(n)
* */
public class LongestSubString {
    public static void main(String[] args) {
        String s = "abca";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() == 0 ) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)) start = Math.max(start,map.get(c));
            map.put(c,i+1);
            max = Math.max(max,i-start+1);
        }
        return max;
    }





    /*public static int lengthOfLongestSubstring(String s) {
        List<String> stringList = new ArrayList<>();
        if(s.length()==0 || s==null) return 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                stringList.add(s.substring(i,j+1));
            }
        }
        for (String str: stringList
             ) {
            for (int i = 0; i < str.length(); i++) {

            }

        }




        /*

        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    System.out.print(str[k]);
                }
                System.out.println();
            }
        }


    return 0;
    }*/
}
