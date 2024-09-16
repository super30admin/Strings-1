class Solution:
    def isNumber(self, s: str) -> bool:
        if len(s) == 0:
            return False
        """
        Digit
        Sign
        Exponent
        Dot
        """
        seendigit = False
        seenexp = False
        seendot = False
        for i, c in enumerate(s):
            if c.isdigit():
                seendigit = True
            elif c in ['+', '-']:
                """
                1. Cant be two signs
                2. If theres a sign in the middle then e should be on its left
                """
                if i > 0 and s[i - 1] not in ['e', 'E']:
                    return False
            elif c in ['e', 'E']:
                """
                1. Cant be two exponents's
                2. Must come after a digit
                """
                if seenexp or not seendigit:
                    return False
                seenexp = True
                ###after exponenet frehs integer
                seendigit = False
            elif c == '.':
                """seendot false, . comes before exp"""
                if seendot or seenexp:
                    return False
                seendot = True
            else:
                return False
        return seendigit


