unordered_map<int,int> um;
class Solution {
public:
    
    static bool comp(char& a,char& b) {
        return um[a]<um[b];
    }
    string customSortString(string S, string T) {
        for (int i=0;i<S.length();i++) {
            um[S[i]]=i+1;
        }
        
        for (int i=0;i<T.length();i++) {
            if (um.find(T[i])==um.end()) {
                um[T[i]]=0;
            }
        }
        
        sort(T.begin(),T.end(),comp);
        return T;
    }
};