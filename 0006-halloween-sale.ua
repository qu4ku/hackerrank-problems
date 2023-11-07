# UIUA LANGUAGE

;; https://www.hackerrank.com/challenges/halloween-sale/
;; dif: easy
;; init 2023/11. done.

p ← 20
d ← 3
m ← 6
s ← 70

Sol ← ⧻⊚≤s \+ ⊂⇌ ⍥(⊂m)⌊÷∶s m [] ;⍢(⊃(-d)⊂)(>m) p []


# some explanation
;⍢(⊃(-d)⊂)(>m) p []   # generate arr from s to m
⍥(⊂m)⌊÷∶s m []        # generate s/m m arr (naive)
⊂⇌                   # join both in reversed order
\+                    # scan it
⧻⊚≤s                 # take only <= s and count them