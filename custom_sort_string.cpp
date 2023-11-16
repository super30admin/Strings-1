class Solution {
public:
    string customSortString(string order, string s) {
        int m = order.length();
        int n = s.length();
        unordered_map<char, int> map;
        for(int i=0;i<n;i++){
            map[s[i]]++;
        }
        string sb = "";
        for(int i=0;i<m;i++){
            char c = order[i];
            if(map.count(c)){
                int count = map[c];
                for(int k=0;k<count;k++){
                    sb += c;
                }
                map.erase(c);
            }
        }
        for(const auto &pair: map){
            int count = pair.second;
            for(int k=0;k<count;k++){
                sb+=pair.first;
            }
            //map.erase(pair.first);
        }
        return sb;
    }
};
