// Time Complexity : O(N) where N is the length of T
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N

class Solution {
public:
    string customSortString(string S, string T) {
        unordered_map<char,int> count;
        for(int i=0;i<T.length();i++){
            if(count.find(T[i])!=count.end()){
                count[T[i]] = count[T[i]]+1;
            }
            else{
                count.insert(pair<char, int>(T[i], 1));
            }
        }
        string result = "";
        for(int i=0;i<S.length();i++){
            if(count.find(S[i])!=count.end()){
                while(count[S[i]]!=0){
                    result = result+S[i];
                    count[S[i]]--;
                }
                count.erase(S[i]);
            }
        }
        if(!empty(count)){
            for(auto it=count.begin();it!=count.end();++it){
                int a = it->second;
                while(a!=0){
                    result = result + it->first;
                    a--;
                }
            }
        }
        return result;
    }
};
