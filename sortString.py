# Simple idea is to re-arrage the  letters, what could be done here is get the count of alll letters then re-arragne them and then append what is missing  in the second string to get desired output.
# Time Complexity: O(n)
# Space Complexity: O(2n) (list+dictionary) 
S = "cba"
T = "abcd"
countLettersT = dict()
li = list()
for character in T:
    if character not in countLettersT:
        countLettersT[character] = 1
    else:
        countLettersT[character] += 1
print(countLettersT)
for letter in S:
    li.append(letter*countLettersT[letter])
    countLettersT[letter]  =  0
print(li)
for cnt in countLettersT:
    li.append(cnt*countLettersT[cnt])
print("".join(li))

