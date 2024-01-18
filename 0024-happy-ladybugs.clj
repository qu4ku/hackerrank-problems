(ns happy-ladybugs
  (:require [clojure.string :as str]))

;; https://www.hackerrank.com/challenges/happy-ladybugs/
;; dif: easy
;; init 2024/01. done.


(defn sol [s]
  (if (every? #(<= 2 %) (vals (frequencies (str/replace s "_" ""))))
    (if (some identity [(every? #(<= 2 %) (map count (partition-by identity s)))
                        (str/includes? s "_")])
      "YES"
      "NO")
    "NO"))


