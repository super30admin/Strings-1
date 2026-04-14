//
//  CustomSortString.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/11/26.
//

class CustomSortString {
    /*
    time complexity -> O(m + n)
    n - length of order string. Order string can be maximum 26 characters. SO, it's constant O(1)
    hence O(m)
    Space complexity - O(1)
    */
    func customSortString(_ order: String, _ s: String) -> String {
        
        //take the hashmap, count the frequency for each character, loop throught the order strin. put that particular character that many times.  add rest of the character and return it.
        //wgile adding reduce the count of the hashmap count. If 0, remove it from the hashmap.
        //Once custom string is done. Iterate throught the string and add rest of the characters.

        var charDict = Dictionary<Character, Int>()

        for char in s {
            charDict[char, default: 0] += 1
        }
        var resultString: String = ""
        for char in order {
            if let frequencyOfChar = charDict[char] {
                for i in 0..<frequencyOfChar {
                    resultString.append(char)
                    // charDict[char] = charDict[char]! - 1
                }
                charDict.removeValue(forKey: char)

            }
        }
        for k in charDict.keys {
            if let frequency = charDict[k] {
                for i in 0..<frequency {
                    resultString.append(k)
                    // charDict[k]! -= 1 - no need for it.
                }
                charDict.removeValue(forKey: k)
            }
        }
        return resultString
    }
}
