(ns mansa-and-stones
  (:require [clojure.math.combinatorics :as combo]))

;; ans
(defn generate-sums [n a b]
  (for [i (range n)]
    (+ (* a i) (* b (- (dec n) i)))))

(defn solve [n a b]
  (->> (generate-sums n a b)
       set
       sort
       (apply println)))

(doseq [_ (range (read))]
  (let [n (read)
        a (read)
        b (read)]
    (solve n a b)))


;; compact ans
(doseq [_ (range (read))]
  (let [n (read)
        a (read)
        b (read)]
    (->> (for [i (range n)]
           (+ (* a i) (* b (- (dec n) i))))
         set
         sort
         (apply println))))


;; works but too slow
(defn generate-lists [n a b]
  (let [pairs [[a a] [a b] [b a] [b b]]]
    (->> (iterate #(mapcat (fn [x] (map (fn [p] (conj x p)) pairs)) %) [[]])
         (nth n)
         (map vec))))

(defn solve [n a b]
  (->> (generate-lists (dec n) a b)
       (map (fn [x] (reduce + x)))
       set
       sort
       (apply println)))

(doseq [_ (range (read))]
  (let [n (read)
        a (read)
        b (read)]
    (solve n a b)))



;; experiments
(butlast '(1 2 3))
