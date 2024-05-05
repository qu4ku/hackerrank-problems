(ns mark-cakewalk
  (:require [clojure.string :as str]))

;; https://www.hackerrank.com/challenges/marcs-cakewalk/
;; dif: easy
;; init 2024/05. done.


(def cakes [5 10 7])

(->> cakes
     sort
     reverse
     (map-indexed (fn [idx val] (* val (Math/pow 2 idx))))
     (reduce +)
     int
     )


;; works but too slow
(let [n (read)
      arr (repeatedly n #(read))]
  (->> arr
       sort
       reverse
       (map-indexed (fn [idx val] (* val (Math/pow 2 idx))))
       (reduce +)
       int
       println))

(let [n (read)
      arr (vec (repeatedly n #(read)))]
  (->> arr
       (sort)
       (reverse)
       (map-indexed (fn [idx val] (* val (bit-shift-left 1 idx))))
       (reduce +)
       long
       println))
