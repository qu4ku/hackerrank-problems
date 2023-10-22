(ns append-and-delate
  (:require [clojure.string :as str]))

;; https://www.hackerrank.com/challenges/append-and-delete
;; dif: easy
;; init 2023/10. done.

(def input "hackerhappy
hackerrank
9")


(defn same-chars [v1 v2]
  (count (take-while #(apply = %) (map vector v1 v2))))

(defn diff-to-build [v1 v2]
  (+
   (- (count v1) (same-chars v1 v2))
   (- (count v2) (same-chars v1 v2))))

(defn solve [v1 v2 n]
  (let [limit (+ (count v1) (count v2))
        diff (diff-to-build v1 v2)
        r (set (range diff (inc limit) 2))]
    (println limit diff r)
    (if (or
         (contains? r n)
         (>= n limit)
         (= 0 diff n))
      "Yes"
      "No")))
