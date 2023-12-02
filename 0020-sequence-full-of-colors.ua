# UIUA LANGUAGE

# https://www.hackerrank.com/challenges/sequence-full-of-colors
# dif: easy
# init 2023/11. done.

x ← "YGYGRBRB"

a ← = /+⌕"G":/+⌕"R".x
b ← = /+⌕"Y":/+⌕"B".x
c ← =0/+=0⊂≥¯1:≤1.\++¯⌕"G":⌕"R".x
d ← =0/+=0⊂≥¯1:≤1.\++¯⌕"Y":⌕"B".x

Sol ← ("False"|"True")=0/+⌕0[a b c d]
Sol