(ns grid-challenge)

;; https://www.hackerrank.com/challenges/grid-challenge/
;; dif: easy
;; init 2023/11. done.

(def grid '("eabcd" "fghij" "olkmn" "trpqs" "xywuv"))
(def grid '("mpxz" "abcd" "wlmf"))
(->> grid
  (map #(sort %))
  (apply mapv vector)
  (map (fn [r] (apply <= (map int r))))
  (#(if (every? identity %) 
        "YES"
        "NO")))


