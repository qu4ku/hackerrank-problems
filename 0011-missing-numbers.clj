(ns missing-numbers
  (:require [clojure.string :as str]))

;; https://www.hackerrank.com/challenges/missing-numbers
;; dif : easy
;; init 2023/11. done.


(defn solve [a b]
  (->>
   (merge-with - (frequencies b) (frequencies a))
   (filter (fn [[k v]] (not= v 0)))
   keys
   sort
   println))


(with-in-str "10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204"
  (let [_ (read-line)
        a (mapv #(Integer/parseInt %) (str/split  (read-line) #" "))
        _ (read-line)
        b (mapv #(Integer/parseInt %) (str/split (read-line) #" "))]
    (->>
     (merge-with - (frequencies b) (frequencies a))
     (filter (fn [[k v]] (not= v 0)))
     keys
     sort
     (apply println))))
