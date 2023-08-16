//time O(m+n)
//space O(1)

/*
firstly we will iterate over s and build a frequency hash map of all the characters
Then we will iterate over the order and check if they exist in the hash map,
if they exist, we will take the frequency and push each char those number of times, 
and remove the characters which are part of the order string, we will then take the remaining characters and push it at
the end
*/

class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char,int> map;
        

        for(int i=0;i<s.size();i++){
            if(map.find(s[i])!=map.end()){
                map[s[i]]++;
            }
            else{
                map[s[i]]=1;
            }


        }
        string b ="";

        for(int i=0;i<order.size();i++){
            if(map.find(order[i])!=map.end()){
                int count = map[order[i]];
                for(int k=0;k<count;k++){
                    b.push_back(order[i]);
                }
                map.erase(order[i]);

            }


        }

        for(auto i:map){
            int count = i.second;
            for(int k=0;k<count;k++){
                b.push_back(i.first);
            }
        }

        

      

        return b;


        
    }
};