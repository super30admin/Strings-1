{
 "cells": [
  {
   "cell_type": "code",
   "execution_count": 1,
   "metadata": {},
   "outputs": [],
   "source": [
    "class Solution:\n",
    "    def lengthOfLongestSubstring(self, s: str) -> int:\n",
    "        seen = {}\n",
    "        maxi = 0;\n",
    "        slow = 0;\n",
    "        for element in range(len(s)):\n",
    "            if s[element] in seen:\n",
    "                slow = max(slow, seen[s[element]])\n",
    "            maxi = max(element + 1 - slow, maxi)\n",
    "            seen[s[element]] = element + 1\n",
    "        return maxi;"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "metadata": {},
   "outputs": [],
   "source": []
  }
 ],
 "metadata": {
  "kernelspec": {
   "display_name": "Python 3",
   "language": "python",
   "name": "python3"
  },
  "language_info": {
   "codemirror_mode": {
    "name": "ipython",
    "version": 3
   },
   "file_extension": ".py",
   "mimetype": "text/x-python",
   "name": "python",
   "nbconvert_exporter": "python",
   "pygments_lexer": "ipython3",
   "version": "3.6.4rc1"
  }
 },
 "nbformat": 4,
 "nbformat_minor": 2
}
