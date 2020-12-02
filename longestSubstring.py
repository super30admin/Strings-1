#Brute force approach would be to find all substrings and filter them out using set to check if characters are repeated, if not then find length and compare with max length.
#Time complexity: O(n^2)
#Space Complexity: O(1)
s = "abcdd"
maxi = 0
for i in range(len(s)):
    for j in range(i+1,len(s)):
        if (len(list(s[i:j+1])) == len(list(set(s[i:j+1])))):
            if len(list(s[i:j+1])) > maxi:
                maxi = len(list(s[i:j+1]))
print(maxi)
