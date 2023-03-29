3. Longest Substring Without Repeating Characters

// HashSet Solution

/*
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int slow = 0;
        int result = 0;
        unordered_set<char> Set; // SC O(n)
        int n = s.size();
        for (int i=0; i< n; i++) { // TC O2(n) ==> O(n)
            char ch = s.at(i);
            if(Set.find(ch) == Set.end()) {
                Set.insert(ch);
            } else {
                while(s.at(slow) != ch) {
                    char c = s.at(slow);
                    Set.erase(c);
                    slow++;
                }
                slow++;
            }
            result = max(result, (i-slow)+1);
        }
        return result;
    }
};

*/

// HAshmap solution

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int slow = 0;
        int result = 0;
        unordered_map<char, int> m; // SC O(n)
        int n = s.size();
        for (int i=0; i< n; i++) { // TC O(n)
            char c = s.at(i);
            if(m.find(c) != m.end()) {
                slow = max((m.find(c)->second+1) , slow);
                m.find(c)->second = i;
            } else {
                m.insert({c,i});
            }
            result = max(result, (i-slow)+1);
            }
            return result;
        }
};
