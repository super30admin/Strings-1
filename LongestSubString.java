// idea: 
// 1) Iterate through the string and append it in a hashmap, while maintaining a max string length without repeating characters
// 2) Empty the hashmap if repeated characters are found and start filling the hashmap from the start of the character where character gets repeated
// 3) keep track of the longest string while in this process

// Time complexity: o(n)
// space complexity: o(1)

// did it run on leetcode: yes

class Solution {
    public int lengthOfLongestSubstring(String s) {
        LinkedHashSet<String> s1 = new LinkedHashSet<String>();
        int max=0,count=0;
		if(s.length()>1) {
		for(int i=0;i<s.length();i++) {
			count++;
            String a= String.valueOf(s.charAt(i));
			if(!s1.contains(a)) {
				s1.add(a);
				if(i==s.length()-1 && s1.size()>max) {
						max = s1.size();
						break;
				}
			} else {
				if(s1.size()>max) {
				max = s1.size();
				if(i!=s.length()-1) 
                i = i-count+1;      
			} else i = i-count+1;	
                count=0; 
                s1.clear();
			}
		}
		}
		else if(s.length()==1) max = 1;
        return max;
    }
}