class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char, int> map;

        for(int i = 0; i<s.length();i++)
        {
            //char c = s.at(i);
            map[s[i]]++;
        }

        string sb;
        for(int i = 0; i<order.length();i++)
        {
            char c = s.at(i);
            if(map.contains(c))
            {
                auto freq = map.find(c);
                 for(auto i = 0; i<freq; i++)
                 {
                     sb.append(c);
                 }
                 map.remove(c);
        
            }
        }

        for(char key:map.keySet())
        {
            auto freq = map.find(c);
                 for(auto k = 0; k<freq;k++)
                 {
                     sb.append(key);
                 }
        }
        return sb;
    }

};