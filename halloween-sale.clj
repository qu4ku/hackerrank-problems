(ns halloween-sale
  (:require [clojure.string :as s]))

;; https://www.hackerrank.com/challenges/halloween-sale/
;; dif: easy
;; init 2023/10. done.


(defn set-price-at-idx [p d m idx]
  (let [price (- p (* idx d))]
    (if (<= m price)
      price
      m)))

(defn solve [p d m s]
  (loop [budget s
         counter 0
         idx 0]
    (if (< budget 0)
      (dec counter)
      (recur (- budget (set-price-at-idx p d m idx))
             (inc counter)
             (inc idx)))))

(let [p (read)
      d (read)
      m (read)
      s (read)]
  (prn (solve p d m s)))

;; test cases 
(with-in-str "20 3 6 80"
  (let [p (read)
        d (read)
        m (read)
        s (read)]
    (solve p d m s)))

(with-in-str "16 2 1 9981"
  (let [p (read)
        d (read)
        m (read)
        s (read)]
    (solve p d m s)))
