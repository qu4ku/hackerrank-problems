(ns jumping-on-the-clouds
  (:require [clojure.string :as str]))

;; https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?isFullScreen=true
;; dif: easy
;; init 2023/10. done.


(def input "7
0 0 1 0 0 1 0")

(defn solve [s]
  (loop [s (rest c)
         c 1]
    (if (empty? s)
      (- c 1)
      (if (= 0 (second s))
        (recur (drop 2 s) (inc c))
        (recur (drop 1 s) (inc c))))))

