//Tc:O(2n)
//SC:O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int start = 0, end = 0;
        int max = Integer.MIN_VALUE;	//Storing the given string in hashmap with their indicies.
        while(end<s.length())			//if the next character is available in string then check if the present start index is bigger than char's existing index.
        {								//Choose the maximum index so that we donot fall in an infinite loop.
            char ch = s.charAt(end);	//check length, from start index to end index.
            if(map.containsKey(ch))		//if the length is larger than max, replace. Add the end to hashmap.
                start = Math.max(start,map.get(ch));
            if(max<=end-start+1)
                max = end-start+1;
            
            map.put(ch,end+1);
            end++;            
        }        
        return max;
    }
}