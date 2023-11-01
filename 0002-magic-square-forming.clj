(ns magic-square-forming
  (:require [clojure.string :as str]
            [clojure.math.combinatorics :as combo]))

;; https://www.hackerrank.com/challenges/magic-square-forming/
:: dif: medium
;; init 2023/10. done.

(def input "4 9 2
3 5 7
8 1 5
")

(def square
  (->> input
       (str/split-lines)
       (map #(mapv (fn [x] (Integer/parseInt x)) (str/split % #" ")))
       vec))

(def flattened-magic-squares
  [[2 7 6 9 5 1 4 3 8]
   [2 9 4 7 5 3 6 1 8]
   [4 3 8 9 5 1 2 7 6]
   [4 9 2 3 5 7 8 1 6]
   [6 1 8 7 5 3 2 9 4]
   [6 7 2 1 5 9 8 3 4]
   [8 1 6 3 5 7 4 9 2]
   [8 3 4 1 5 9 6 7 2]
   [2 7 6 9 5 1 4 3 8]
   [2 9 4 7 5 3 6 1 8]
   [4 3 8 9 5 1 2 7 6]
   [4 9 2 3 5 7 8 1 6]
   [6 1 8 7 5 3 2 9 4]
   [6 7 2 1 5 9 8 3 4]
   [8 1 6 3 5 7 4 9 2]
   [8 3 4 1 5 9 6 7 2]])


(defn magic-sum [v1 v2]
  (reduce + 0 (map #(Math/abs (apply - %))(map vector v1 v2))))

(defn solve [s]
  (reduce min (map #(magic-sum (flatten s) %) flattened-magic-squares))
  )


;; get flattened magic squares, brute force:
(def perm (combo/permutations [1 2 3 4 5 6 7 8 9]))
(def perm-squares (mapv #(mapv vec (partition 3 %)) perm))

(defn is-magic [m]
  (let [d1 (+ ((m 0) 0) ((m 1) 1) ((m 2) 2))
        d2 (+ ((m 0) 2) ((m 1) 1) ((m 2) 0))
        r1 (+ ((m 0) 0) ((m 0) 1) ((m 0) 2))
        r2 (+ ((m 1) 0) ((m 1) 1) ((m 1) 2))
        r3 (+ ((m 2) 0) ((m 2) 1) ((m 2) 2))
        c1 (+ ((m 0) 0) ((m 1) 0) ((m 2) 0))
        c2 (+ ((m 0) 1) ((m 1) 1) ((m 2) 1))
        c3 (+ ((m 0) 2) ((m 1) 2) ((m 2) 2))]
    (and (= d1 d2) (= d1 r1) (= d1 r2) (= d1 r3) (= d1 c1) (= d1 c2) (= d1 c3))))

(def magic-squares (filter is-magic perm-squares))
(def flattened-magic-squares(mapv #(vec (flatten %)) magic-squares))



;; other tests
(with-in-str input
  (map #(map Integer/parseInt (str/split % #" ")) (str/split-lines input))
)

(with-in-str input
(->> input
     (str/split-lines)
     (map #(mapv (fn [x] (Integer/parseInt x)) (str/split % #" ")))
     (flatten)))

