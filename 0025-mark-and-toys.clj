(ns mark-and-toys
  (:require [clojure.string :as str]))

;; https://www.hackerrank.com/challenges/mark-and-toys/
;; dif: easy
;; init 2024/05. done.

(def prices [1 12 5 111 200 1000 10])
(def k 50)


(defn sol [prices k]
  (->> prices
       sort
       (reductions +)
       (take-while #(< % k))
       count))

