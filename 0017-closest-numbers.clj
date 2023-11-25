(ns closest-numbers)

;; https://www.hackerrank.com/challenges/closest-numbers/
;; dif: easy
;; init 2023/11. done.


(def xs [-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470 ])


;; meh
(let [sxs (sort-by first 
                            (map (fn [p] [(abs (apply - p)) p])
                                 (partition 2 1 (sort xs))))
      minv (first (apply min-key first sxs))]
  (->>
   (filter #(= (first %) minv) sxs)
   (map second)
   flatten
   (apply println)))


(let [n (read)
      xs (repeatedly n #(read))
      sxs (sort-by first
                            (map (fn [p] [(Math/abs (apply - p)) p])
                                 (partition 2 1 (sort xs))))
      minv (first (apply min-key first sxs))]
  (->>
   (filter #(= (first %) minv) sxs)
   (map second)
   flatten
   (apply println)))
