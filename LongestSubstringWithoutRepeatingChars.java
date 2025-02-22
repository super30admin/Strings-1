import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()==0){
            return 0;
        }

        int i = 0, start =0, max = Integer.MIN_VALUE;
        HashMap<Character, Integer> hmap = new HashMap<>();
        while(i< s.length()){
            if(!hmap.containsKey(s.charAt(i))){
                hmap.put(s.charAt(i), i+1);
            }else{
                start = Math.max(start, hmap.get(s.charAt(i)));
                hmap.put(s.charAt(i), i+1);
            }
            max = Math.max(max,i-start+1);
            //System.out.println("max "+max);
            i++;
        }
        return max;
    }
}
