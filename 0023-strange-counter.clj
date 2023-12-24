(ns strange-counter)

;; https://www.hackerrank.com/challenges/strange-code/
;; dif: easy
;; init 2023/12. done.

(defn generate-cycle-size [n]
  (* (biginteger "3") (bigint (Math/pow 2 (dec n)))))

(defn generate-list [n]
  (->>
   (for [i (range 1 (inc n))]
     (generate-cycle-size i))
   (reductions +)))

(defn strange-counter [n]
  (->> (- (first (drop-while (partial > n) (generate-list 100))) (dec n))
       bigint
       .toString))

(strange-counter 1000000000000)
