# Strings-1

## Problem1 
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

# Hashmap
# Parse over the string 's' and add the character to the hashmap along with its frequency
# Parse over the order and append the characters in sequence from the hashmap by reducing the frequency
# of characters in the order. When the frequency becomes '0' we remove it from the map.
# Parse over the remaining elements of the map and append them. The order of these characters doesn't 
# matter.
# Return the result array.

## Problem2 

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

# Two Pointers
# Iterate the fast pointer until it is less than the length of the string.
# When a repeated character is found, remove all elements from the hashset and move the slow pointer 
# to escape the repeated character
# If the character is unique we continue adding in the hashset and increment the fast pointer
# Get the max length of the string by comparing the exisiting max length and the difference between the
# pointers. Return the maximum length of the string.

# Hashmap
# Edge case when the string is empty we return 0/
# For loop over characters of the string, store the character in the hash map with frequency
# If the character already exists then we update the frequency
# Find the max length of characters by taking existing length and difference current character index
# with slow pointer and return the maximum length. 