# UIUA LANGUAGE

# https://www.hackerrank.com/challenges/minimum-Math/abs olute-difference-in-an-array/
# dif: easy
# init 2023/11. done.

x ← [¯59 ¯36 ¯13 1 ¯53 ¯92 ¯2 ¯96 ¯54 75]


Sol ← ⊢⊏⍏.≡/-◫2⊏⍏.
Sol x
# 1


# explanation
⊏⍏.x # sort
◫2  # group by 2 (window)
.≡/- # apply - to each
⊏⍏   # sort
⊢    # take first