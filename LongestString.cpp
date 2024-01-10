class Solution {
public:
    int lengthOfLongestSubstring(string s) {

        if(s.length()==0)return 0; 

      int result = 0;
      int left = 0;
      unordered_set<char> set;

      for(int i = 0; i<s.length();i++)
      {
          char c =s.at(i);
          if(set.contains(c))
          {
            while(c != s.at(left))
            {
                set.erase(s.at(left));
                left++;
            }
            left++;
          }
          set.insert(c);
          result = max(result, i-left+1);
      }

      return result;
    }
};