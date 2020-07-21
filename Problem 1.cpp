//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    string customSortString(string S, string T) {
        //add all the elements in the string T to map
        map<char, int> m;
        string res="";
        for(int i=0; i<T.size(); i++){
            if(m.find(T[i])==m.end())
                m[T[i]]=1;
            else
                m[T[i]]++;
        }
        
        //iterate over S and add it to result
        for(int i=0; i<S.size(); i++){
            if(m.find(S[i])!=m.end()){
                int val = m[S[i]];
                while(val!=0){
                    res+=S[i];
                    val--;
                }
                m.erase(S[i]);
            }
        }
        
        //add the remaining elements in the map to res
        for(auto it = m.begin(); it!=m.end(); it++){
            int val = it->second;
            while(val!=0){
                res+=it->first;
                val--;
            }
        }
        
        return res;
        
    }
};