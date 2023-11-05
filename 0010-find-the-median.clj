(ns find-the-median)

;; https://www.hackerrank.com/challenges/find-the-median
;; dif : easy
;; init 2023/11. done.


(defn median [xs]
  (nth (sort xs) (quot (count xs) 2)))

; sol
(let [n (read)
      xs (repeatedly n #(read))]
  (print (nth (sort xs) (quot (count xs) 2))))
