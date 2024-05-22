(ns strong-password
  (:require [clojure.string :as str]))

;; https://www.hackerrank.com/challenges/strong-password/
;; dif: easy
;; init 2024/05. done.


(def n "0123456789")
(def low "abcdefghijklmnopqrstuvwxyz")
(def up "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
(def sp "!@#$%^&*()-+")

(defn is-in? [w s]
  (some #(contains? (set s) %) w))

(let [_ (read-line)
      pass (read-line)
      need (reduce + (map #(if (is-in? pass %) 0 1) [n low up sp]))
      len (+ need (count pass))
      diff (- 6 len)]
  (if (> diff 0)
    (println (+ need diff))
    (println need)))
