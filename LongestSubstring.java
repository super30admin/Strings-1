import java.util.HashSet;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "abcabcbbb";
		System.out.println(lengthOfLongestSubstring(str));
		
		

	}
	public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int max =0;
        HashSet<Character> set = new HashSet<>();
        
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max,set.size());
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

}
