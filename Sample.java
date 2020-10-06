//Longest Substring with no repeating characters
// Time Complexity : 0(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        String output="";
        HashMap<Character, Integer> hp= new HashMap<>();
        for(int i=0,j=0;j<s.length();j++)
        {
            char ch = s.charAt(j);
            if(hp.containsKey(ch))
            {
                i= Math.max((hp.get(ch)+1),i);
            }
            if(output.length()<j-i+1)
            {
                output=s.substring(i,j+1);
            }
            hp.put(ch,j);
        }
        return output.length();
    }
}

//Custom Sort string
// Time Complexity : 0(n+m) length of two strings
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String S, String T) {
        if(S.length()==0|| T.length()==0)
            return "";
        HashMap<Character,Integer> hp= new HashMap<>();
        for(int i=0;i<T.length();i++)
        {
            char ch= T.charAt(i);
            hp.put(ch, hp.getOrDefault(ch,0)+1);
            
        }
        String output="";
        for(int x=0;x<S.length();x++)
        {
            char ch =S.charAt(x);
            if(hp.containsKey(ch)){
                int count=hp.get(ch);
                while(count>0)
                {
                    output += ch;
                    count--;
                }
                hp.remove(ch);
            }
        }
        for(Map.Entry<Character,Integer> entry:hp.entrySet())
        {
            char ch= entry.getKey();
            int count=entry.getValue();
            while(count>0)
            {
                output +=ch;
                count--;
            }
                
        }
            
        return output;
        
    }
}

