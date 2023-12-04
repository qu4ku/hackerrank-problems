(ns big-sorting)


;; https://www.hackerrank.com/challenges/big-sorting/
;; dif: easy
;; init 2023/11. done: 2023/12.


;; 2023/12
(let [n (Integer/parseInt (read-line))
      numbers (repeatedly n read-line)
      bucket (group-by count numbers)]
  (doseq [key (sort (keys bucket))]
    (doseq [value (sort (bucket key))]
      (println value))))


;; works but time limit
(let [n (read)
      xs (repeatedly n #(read))]
  (doseq [x (sort xs)]
    (println (str x))))
