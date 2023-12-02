(ns sequence-full-of-colors)

;; https://www.hackerrank.com/challenges/sequence-full-of-colors
;; dif: easy
;; init 2023/11. done.

(def input "4
RGGR
RYBG
RYRB
YGYGRBRB")

(with-in-str input
  (let [n (read)
        _ (read-line)] ; empty space after number :/
    (doseq [_ (range n)]
      (let [s (read-line)
            f (frequencies s)]
        (if (every? true?
                    [(= (f \R) (f \G))
                     (= (f \Y) (f \B))
                     (->> (seq s)
                          (map #(case %
                                  \R 1
                                  \G -1
                                  0))
                          (reductions +)
                          (every? #(contains? #{1 0 -1} %)))
                     (->> (seq s)
                          (map #(case %
                                  \Y 1
                                  \B -1
                                  0))
                          (reductions +)
                          (every? #(contains? #{1 0 -1} %)))])
          (println "True")
          (println "False"))))))
