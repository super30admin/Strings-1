//time: O(n+m) space: O(1)
class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char,int> umap;
        string result;
        for(char c : s) {
            umap[c]++;
        }
        for(int i = 0; i < order.size(); i++) {
            if(umap.find(order[i]) != umap.end()) {
                while(umap[order[i]] != 0) {
                    result += order[i];
                    umap[order[i]]--;
                }
            }
        }
        for(auto c : umap) {
            if(c.second != 0) {
                while(c.second != 0) {
                    result += c.first;
                    c.second--;
                }
            }
        }
        return result;
    }
};