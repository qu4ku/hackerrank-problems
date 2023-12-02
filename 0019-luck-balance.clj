(ns luck-balance)

;; https://www.hackerrank.com/challenges/luck-balance/
;; dif: easy
;; init 2023/11. done.

(def input "6 3
5 1
2 1
1 1
8 1
10 0
5 0")

(with-in-str input
  (let [n (read)
        k (read)
        xs (for [_ (range n)]
                   [(read) (read)])]
    (println (-
              (+
               (->> xs
                    (filter #(= 0 (% 1)))
                    ((fn [x] (map #(% 0) x)))
                    (reduce +))
               (->> xs
                    (filter #(= 1 (% 1)))
                    ((fn [x] (map #(% 0) x)))
                    sort
                    reverse
                    (take k)
                    (reduce +)))
              (->> xs
                   (filter #(= 1 (% 1)))
                   ((fn [x] (map #(% 0) x)))
                   sort
                   reverse
                   (drop k)
                   (reduce +))))))
