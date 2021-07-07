//
// Created by shazm on 8/19/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

class Solution {
private:
    static string str;
    static bool customSort(char c1, char c2){
        return (str.find(c1)<str.find(c2));
    }
public:
    string customSortString(string S, string T) {
        str = S;
        sort(T.begin(),T.end(),customSort);
        return T;
    }
};
string Solution :: str;

int main(){
    return 0;
}