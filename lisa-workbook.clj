(ns lisa-workbook
  (:require [clojure.string :as s]))

;; https://www.hackerrank.com/challenges/lisa-workbook
;; dif: easy
;; init 2023/10. done.



(with-in-str
  "5 3
4 2 6 1 10"
  (let [n (read)
        k (read)
        arr (repeatedly n #(read))]
    (->> arr
         (mapcat #(partition-all k (range 1 (inc %))))
         (map-indexed (fn [idx val] [(inc idx) val]))
         (filter (fn [e] (some #{(first e)} (second e))))
         count
         println)))

;; ans
(let [n (read)
      k (read)
      arr (repeatedly n #(read))]
    (->> arr
         (mapcat #(partition-all k (range 1 (inc %))))
         (map-indexed (fn [idx val] [(inc idx) val]))
         (filter (fn [e] (some #{(first e)} (second e))))
         count
         println))
