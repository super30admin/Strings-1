//Time Comp: O(N)
//Space Comp: O(1)
class Solution {
public:
    string customSortString(string S, string T) {
        int count[26] = {0};
        string result = "";
        for(char c: T){
            count[c-'a'] += 1;
        }
        
        for(char c: S){
            for(int k=0; k<count[c-'a']; k++){
                result += c;
            }
            count[c-'a'] = 0;
        }
        
        for(char c = 'a'; c<='z'; c++){
            for (int i = 0; i < count[c - 'a']; i++){
                result += c;
            }
        }
        return result;
    }
};