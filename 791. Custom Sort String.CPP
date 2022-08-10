class Solution {
public:
    // tc-O(M+N)
    //SC-O(max(m,n))
    string customSortString(string order, string s) {
     unordered_map<char,int> h;
        for(auto p:s){
            h[p]++;
        }
        string res="";
        for(auto p:order){
            if(h.find(p)!=h.end()){
                int count=h[p];
                while(count--){
                    res+=p;
                }
                h.erase(p);
            }
        }
        if(h.size()>0){
            for(auto p:h){
                int count=p.second;
               while(count--){
                   res+=p.first;
               }
            }
        }
        return res;
    }
};