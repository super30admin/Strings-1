class Solution:

    """
    TC on
    SC - O1
    """
    def maximumSwap(self, num: int) -> int:
        """highest digits to swap"""
        highest_digit = 0
        highest_position = 0
        """lowest digits to swap"""
        low_digit = 0
        low_position = 0
        """currhighest digit"""
        curr_highdigit = -1
        curr_highposition = 0

        res = num
        ##currplace one's
        pos = 1
        while num:
            digit = num % 10
            if digit > curr_highdigit:  # if digit is greatest digit yet
                curr_highdigit, curr_highposition = digit, pos

            elif digit < curr_highdigit:  # if digit is less than greatest digit yet
                # set the digits to swap as the greatest digit yet, and this digit
                highest_digit = curr_highdigit
                highest_position = curr_highposition
                low_digit = digit
                low_position = pos

            pos *= 10
            num //= 10
        res += -(highest_digit * highest_position) + (highest_digit * low_position) - (low_position * low_digit) + (
                    low_digit * highest_position)
        ###subtract lowest at high position and add lowest at low position

        return res

        return 0
