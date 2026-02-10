public class TestStrings1Problems {
    public static void main(String[] args) {
        // Testing Custom Sorting of the String
        CustomSortString cs = new CustomSortString();
        String order = "cba";
        String s = "abcd";
        System.out.println(cs.customSortString(order, s));
        String order1 = "bcafg";
        String s1 = "abcd";
        System.out.println(cs.customSortString(order1, s1));
        //Testing Longest Substring without Repeat Characters
        LongestSubString ls = new LongestSubString();
        String l = "abcabcbb";
        System.out.println("The length of the longest substring is " + ls.lengthOfLongestSubstring(l) );
    }
}
