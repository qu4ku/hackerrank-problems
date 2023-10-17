(ns save-the-prisoner
  (:require [clojure.test :refer :all]
            [clojure.string :as str]))
;; https://www.hackerrank.com/challenges/save-the-prisoner/
;; 2023/11

(def input
"7 19 2
3 7 3"
)


;; first solution
(defn solution [n m s]
  (->>
    (+ m (- s 1))
    ((fn [x]
        (if (= 0 (mod x n))
          n
          (mod x n))))))

(defn check [input solution]
  (->>
    input
    (str/split-lines)
    (map #(str/split % #" "))
    (mapv (fn [vec] (mapv #(Integer/parseInt %) vec)))
    (mapv #(apply solution %))))

(deftest test
  (is (= 2 (solution 5 2 1))
      (= 6 (solution 7 19 2))))


;; another solutions
(defn solution2 [n m s]
  (let [sum-mod (+ m (- s 1))]
    (if (zero? (mod sum-mod n))
      n
      (mod sum-mod n))))

(defn solution3 [n m s]
  (let [sum-mod (+ m (- s 1))]
    (cond
      (zero? (mod sum-mod n)) n
      :else (mod sum-mod n))))

(check input solution2)
