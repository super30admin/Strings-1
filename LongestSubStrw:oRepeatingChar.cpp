// HashMap Solution
// Time COmplexity -> O(n)
// Space Complexity -> O(26)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> map;
        int slow = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s[i];
            if(map.count(c))
                slow = max(slow, map[c]);
            maxLen = max(maxLen, i - slow + 1);
            map[c] = i+1;
        }
        return maxLen;
    }
};

// HashSet Solution
// Time COmplexity -> O(2n)
// Space Complexity -> O(26)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        set<char> set;
        int maxLen = 0;
        int slow = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s[i];
            if(set.count(c)){
                
                while(s[slow] != c){
                    set.erase(s[slow]);
                    slow++;
                }
                slow++;
            }
            set.insert(c);
            maxLen = max(maxLen, i - slow + 1);
        }
        return maxLen;
    }
};

// HashSet solution with a separate fast pointer
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.length() == 0 || s.length() == 1)
            return s.length();
        int slow = 0;
        int fast = 1;
        set<char> set;
        set.insert(s[0]);
        int answer = 0;
        while(fast < s.length()){
            char c = s[fast];
            if(set.count(c)){
                while(s[slow] != c){
                    set.erase(s[slow]);
                    slow++;
                }
                slow++;
            }
            set.insert(s[fast]);
            answer = max(answer, fast - slow + 1);
            fast++;
            
        }
        return answer;
    }
};