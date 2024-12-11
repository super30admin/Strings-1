// given the string s we need to find the longest substring without repeating characters
// given string :- abcabcbb
// brutue force approach would be to genereate all the possible substring and check if each
// sustring contans repeating characters or not 
// but the time complexity to generate all the combination is O(N^2)

// the optimal approach is we can use the map to store the frequency of each character with first
// iteration
//mean while we can use two pointer starting from the first character
// while increamenting the end pointer we can check if the map contains the char or not if yes
// we store the length of the current string and update the start pointer untill we reach the same 
// character as the end pointer then start iterating the end pointer again, we can repeat this process
// untill we reach the string end

// the time complexity for this would O(2*n) we can further optimize this by updating the start pointer to
// index of the previos char

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // create the freq map
        unordered_map<char, int> map;

        int start = 0;
        int end = 0;
        int len = 0;

        while(end < s.length())
        {
            // start iterating end
            //check if the char is present
            if(map.find(s[end])!= map.end())
            {
                //update the start 
                start = max(start,map[s[end]]+1);
            }
            
            map[s[end]] =end;
            
            len = max(len, end-start+1);
            end++;
        }
        return len;
    }
};
//Time complexity O(n)
//space complexity O(1) - cause map is in range of(0,26)
/*
bacdabdc
*/