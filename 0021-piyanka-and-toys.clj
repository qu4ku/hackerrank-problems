(ns piyanka-and-toys)

;; https://www.hackerrank.com/challenges/priyanka-and-toys
;; dif: easy
;; init 2023/12. done.


(def arr [1 2 3 21 7 12 14 21])

(loop [curr (sort arr)
       c 0]
  (if (empty? curr)
    c
    (let [max (+ 4 (first curr))
          g (take-while #(<= % max) curr)]
      (println g)
      (recur (drop (count g) curr) (inc c)))))


(let [n (read)
      arr (repeatedly n #(read))]
  (loop [curr (sort arr)
         c 0]
    (if (empty? curr)
      (println c)
      (let [max (+ 4 (first curr))
            g (take-while #(<= % max) curr)]
        (recur (drop (count g) curr) (inc c))))))
