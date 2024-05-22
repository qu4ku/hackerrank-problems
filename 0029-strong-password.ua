# UIUA LANGUAGE

# https://www.hackerrank.com/challenges/strong-password/
# dif: easy
# init 2024/05. done.


Pass ← "Ab1"

IsF ← =0/+∊∵Pass
Need ← /+ [IsF "0123456789" IsF "abcdefghijklmnopqrstuvwxyz" IsF "ABCDEFGHIJKLMNOPQRSTUVWXYZ" IsF "!@#$%^&*()-+"]
Diff ← -:6+Need⧻Pass
Sol ← ↥Need+Diff Need
Sol
