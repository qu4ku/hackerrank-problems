# UIUA LANGUAGE

# https://www.hackerrank.com/challenges/beautiful-pairs/
# dif: easy
# init 2023/11. done.


a ← [3 5 7 11 5 8]
b ← [5 7 11 10 5 8]

Sol ← (+1|-1)<:⧻a.⧻▽≠,0/+⍉∵(∊b)a
Sol


# step by step
∵(∊b)a
⍉
/+
▽≠,0
.⧻
<:⧻a
(+1|-1)