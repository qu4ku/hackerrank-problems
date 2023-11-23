(ns beautiful-pairs
  (:require [clojure.set :as set]))

;; https://www.hackerrank.com/challenges/beautiful-pairs/
;; dif: easy (but somewhat hard to implement in clj)
;; init 2023/11. done.

; should be 6
(def A [3 5 7  11 5 8])
(def B [5 7 11 10 5 8])

; ans. convoluted as F.
(let [fA (frequencies A)
      fB (frequencies B)
      n (-
          (reduce + (vals fB))
          (reduce + (map (fn [[k v]] (if (>= v 0) v 0)) (merge-with - fB (select-keys fA (keys fB))))))
      c (count A)]
  (if (< n c)
    (inc n)
    (dec n)))
