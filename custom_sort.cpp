// Time Complexity: O(n log n), where n is the length of the string s.
// Space Complexity: O(n), where n is the length of the string s.
// Did this code run successfully on LeetCode? Yes

//Approach: 
// 1. Create a map to store the order of characters in the string 'order'.
// 2. Sort the string 's' using a custom comparator.
// 3. The comparator checks if both characters are in the order map.
// 4. If both characters are in the order map, compare their indices.
// 5. If only one character is in the order map, it comes first.
// 6. If neither character is in the order map, sort them in alphabetical order.

class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char, int> orderMap;
        for(int i = 0; i < order.size(); i++){
            orderMap[order[i]] = i;
        }

        sort(s.begin(), s.end(), [&](char a, char b){
            bool a_in_order = orderMap.count(a);
            bool b_in_order = orderMap.count(b);

            if(a_in_order && b_in_order){
                return orderMap[a] < orderMap[b];
            } else if(a_in_order){
                return true;
            } else if(b_in_order) {
                return false;
            } else{
                return a < b;
            }
        });
        return s;
    }
};