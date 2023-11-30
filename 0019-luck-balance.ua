# UIUA LANGUAGE

# https://www.hackerrank.com/challenges/luck-balance/
# dif: easy
# init 2023/11. done.

k ← 3
x ← [[5 1] [2 1] [1 1] [8 1] [10 0] [5 0]]

# garbage oneliner :(
Sol ← -/+↘k⊏⍖.≡⊏0▽=1≡⊏1.x+/+↙k⊏⍖.≡⊏0▽=1≡⊏1.x/+≡⊏0▽=0≡⊏1.x
Sol


# more readable
Zeros ← /+ ≡⊏0 ▽=0 ≡⊏1.
OnesW ← /+ ↙k ⊏⍖. ≡⊏0 ▽=1 ≡⊏1.
OnesL ← /+ ↘k ⊏⍖. ≡⊏0 ▽=1 ≡⊏1.
Sol ← - OnesL x + Zeros x OnesW x


# step by step
Zeros ← (
  .
  ≡⊏1
  ▽=0
  ≡⊏0
  /+
)

OnesW ← (
  .
  ≡⊏1
  ▽=1
  ≡⊏0
  ⊏⍖.
  ↙ k
  /+
)

OnesL ← (
  .
  ≡⊏1
  ▽=1
  ≡⊏0
  ⊏⍖.
  ↘ k
  /+
)

Sol ← - OnesL x + Zeros x OnesW x