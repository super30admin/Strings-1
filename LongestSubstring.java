package LC3_LenOfLongestSubstring;

import java.util.HashMap;

public class LongestSubstring {
public int lengthOfLongestSubstring(String s) {
        
        //Edge case
        if(s==null || s.length() == 0)
        {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        int max = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(fast < s.length())
        {
            Character c = s.charAt(fast);
            if(map.containsKey(c))
            {
                slow = Math.max(slow,map.get(c));
                
            }
            map.put(c,fast+1);
            max = Math.max(max, (fast-slow)+1);
            fast++;
        }
        return max;
    }

	public static void main(String[] args) {
		
		String str = "abcdefaderfad";
		LongestSubstring obj =  new LongestSubstring();
		System.out.println("The length of longest substring is :" +obj.lengthOfLongestSubstring(str));
		// TODO Auto-generated method stub

	}

}
