import java.util.HashMap;

class LongestSubWithoutrepititionsHashing {
    //tc-0(n)
    //sc-o(1)
    public static void main(String[] args)
    {
        String s = "abcabcbb";
        int n = lengthOfLongestSubstring(s);
        System.out.println(n);
        
    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int slow =0;
        int max =0;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c))
            {
                slow = Math.max(slow,map.get(c));//or Math.max(slow,map.get(c)+1)
            }
            max = Math.max(max,i-slow+1);
            map.put(c,i+1);//and remove 1 from here
        }
        return max;
    }
}