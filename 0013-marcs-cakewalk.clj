(ns marcs-cakewalk
  (:require [clojure.string]))

;; https://www.hackerrank.com/challenges/marcs-cakewalk/
;; dif: easy
;; init 2023/11. done.

;; these have timout problems but are fast even on long input
;; i assume it's hr error as the solution is the same as others

(defn solve [xs]
  (reduce +
          (map-indexed (fn [idx x]
                         (* x (Math/pow 2 idx)))
                       (sort > xs))))


(solve [1 3 2])
(time (solve [801 234 536 747 172 590 833 847 509 429 666 411 609 894 348 254 814 767 647 965 711 801 852 781 972 390 218 290 508 174 55 714 442 284 745 872 46 131 833 315]))


(->> (repeatedly (read) #(read))
     (sort >)
     (map-indexed (fn [idx x]
                    (* x (Math/pow 2 idx))))
     (reduce +)
     int
     println)


;; precomputed powers of two, should be fastest but also too slow
(defn count-miles [n read-fn]
  (let [inputs (take n (repeatedly read-fn))
        sorted-inputs (sort > inputs)
        powers-of-2 (take n (iterate #(* 2 %) 1))]
    (->> (map * sorted-inputs powers-of-2)
         (reduce +)
         int
         println)))

(count-miles (read) #(read))
