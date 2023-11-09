(ns min-abs-diff)

;; https://www.hackerrank.com/challenges/minimum-Math/abs olute-difference-in-an-array/
;; dif: easy
;; init 2023/11. done.


;; sol
(let [n (read)]
  (->> (repeatedly n #(read))
       sort
       vec
       (#(for [idx (range (dec (count %)))]
           (Math/abs (- (% idx)
                        (% (+ 1 idx))))))
       (apply min)
       println))



(def input [-59 -36 -13 1 -53 -92 -2 -96 -54 75])
(->> input
     sort
     vec
     (#(for [idx (range (dec (count %)))]
          (Math/abs (- (% idx)
                 (% (+ 1 idx))))))
     (apply min)
     println)
