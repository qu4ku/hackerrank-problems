(ns jim-and-the-orders
  (:require [clojure.string :as str]))

;; https://www.hackerrank.com/challenges/jim-and-the-orders/
;; dif: easy
;; init 2024/05. done.


(def orders [[1 3] [2 3] [3 3]])

(defn solve [orders]
  (->> orders
       (map-indexed (fn [idx o] [(inc idx) (reduce + o)]))
       (sort-by second)
       (map first)))

(solve orders)


;; with reading input
(let [s (for [n (range 0 (read))] [(read) (read)])]
  (->> s
       (map-indexed (fn [idx o] [(inc idx) (reduce + o)]))
       (sort-by second)
       (map first)
       (clojure.string/join " ")
       println))
