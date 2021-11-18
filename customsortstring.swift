// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
    func customSortString(_ order: String, _ s: String) -> String {
        if order == nil || order.count == 0 || s.count == 0 || s == nil {
            return "" 
        }
        var orderArray = Array(order)
        var sArray = Array(s)
        var output = ""
        var hashmap = [Character:Int]()
            for i in 0..<sArray.count {
                var char = sArray[i]
                hashmap[char,default: 1] += 1   
            }
        for i in 0..<orderArray.count {
            var char = orderArray[i]
            if let count = hashmap[char] {
                hashmap[char] = 0
                if count > 0 {
                    for j in 1..<count {
                        output.append(char)
                    }
                }
            }
        }
        for i in 0..<sArray.count {
            var char = sArray[i]
            if let count = hashmap[char] {
                if count > 0 {
                        output.append(char)
 
                }
            }
        }
        return output
    }