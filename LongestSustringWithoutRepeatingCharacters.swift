//
//  LongestSustringWithoutRepeatingCharacters.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/10/26.
//

/*
 Bruteforce - create all the substrings of the string and then check if it has repeating characters.  To create substrings - O(n pow 2)
 to check if its the substring
 */
class LongestSubstringWithoutRepeatingChars {
    
    init() {
        
    }
    
    //time complexity - O(2n), space complexity - O(1)
    func longestSubstringWithoutRepeatingCharactersUsingSet() {
        func lengthOfLongestSubstring(_ s: String) -> Int {
            
            //A set solution and a hash map solution using 2 pointers
            let length = s.count
            if (length == 0) {
                return 0
            }
            if (length == 1) {
                return 1
            }
            var left = 0
            var right = 0
            var set = Set<Character>()
            var maximumLength = 0
            for right in 0..<length {
                let index = s.index(s.startIndex, offsetBy: right)
                let char = s[index]
                if (set.contains(char)) {
                    //Move the left pointer to escape repeate Character
                    var lIndex = s.index(s.startIndex, offsetBy: left)
                    while(s[lIndex] != char) {
                        set.remove(s[lIndex])
                        left = left + 1
                        lIndex = s.index(s.startIndex, offsetBy: left)
                    }
                    left += 1
                    
                } else {
                    set.insert(char)
                }
                maximumLength = max(maximumLength, (right - left + 1))
            }
            return maximumLength
        }
    }
    
    // time complexity - O(n), space complexity - O(1)
    func longestSubstringWithoutRepeatedCharactersUsingMap(_ s: String) -> Int {
        
            var hashMap = Dictionary<Character, Int>()
            if (s.count == 0) {
                return 0
            }
            if (s.count == 1) {
                return 1
            }
            var left = 0
            let length = s.count
            var maxLength = 0
            for right in 0..<length {
                let rCharIndex = s.index(s.startIndex, offsetBy: right)
                let rChar = s[rCharIndex]

                //present in hash map
                if let rCharIdx = hashMap[rChar] {
                    left = max(left, rCharIdx + 1)
                    hashMap[rChar] = right
                } else {
                    //not in hash map, so add in hashMap
                    hashMap[rChar] = right
                }
                maxLength = max(maxLength, right - left + 1)
            }
            return maxLength
        }
    
}
