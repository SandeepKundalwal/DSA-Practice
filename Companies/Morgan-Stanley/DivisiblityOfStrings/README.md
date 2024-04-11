Find out if a given string is divisible by another string
String Divisibility means: If s = "atanatanatan" and t = "atan", then s is divisble by t (repeating t for some constant frequency will give us s) atan+atan+atan (t+t+t) = atanatanatan (s)
Given two strings, t and s. Find if s is divisible by t.

If s is not divisible by t, then return -1.
If divisible, then find the string u, which is the least common divisor of s and t.
eg 1: s = "ababab", t = "abab", then return -1, as s is not divisible by t
eg 2: s = "ababababababababab", t = "ababab", then u = "ab". u is the shortest string which divides both s and t