# UIUA LANGUAGE

# https://www.hackerrank.com/challenges/happy-ladybugs/
# dif: easy
# init 2024/01. done.


S ← "IIIAAFFI"
SS ← ▽=0⌕ "_".S
Happy ← =0 /+ ⌕1 ∵⧻ ⊜□ ≠0.¯-1♭◴∵(⊗S)S
Under ← /+ ⌕ "_" S
HappyH ← =0/+<2/+¯≡-1∵(⊗SS)SS

Sol ← ⊏+ Happy =2+ HappyH Under {"NO" "YES"}
Sol
