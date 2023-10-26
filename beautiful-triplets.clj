(ns beautiful-triplets
  (:require [clojure.string :as str]))

;; https://www.hackerrank.com/challenges/beautiful-triplets/problem
;; dif: easy
;; init 2023/10. wip.


;; a[y] - a[x] = a[z] - a[y] = d
;; x < y < z

(def s (map #(Integer/parseInt %) (str/split "1 2 4 5 7 8 10" #" ")))
;; n1, expected 9996
(def long-input
  (->>
   (slurp "inputs/beautiful-triplets-i8.txt") 
   (#(str/split % #"\n"))
   second
   (#(str/split % #" "))
   (map #(Integer/parseInt %))
   ))


;; working solution
(defn index-map [seq]
  (reduce
   (fn [m [idx item]]
     (update m item (fnil conj []) idx))
   {}
   (map-indexed vector seq)))

(def indexed-map (index-map long-input))

(defn solve6 [d arr]
  (let [indexed-map (index-map arr)]
    (reduce + 
            (for [idx (range 1 (count arr))]
              (let [num (nth arr idx)
                    needed-left (- num d)
                    needed-right (+ d num)
                    idxs-left (get indexed-map needed-left)
                    idxs-right (get indexed-map needed-right)]
                (if (and idxs-left idxs-right)
                  (* (count (filter #(< % idx) idxs-left))
                     (count (filter #(> % idx) idxs-right)))
                  0))))))

(time (solve6 1 long-input))





;; OTHER SOLUTIONS / worked but to slow
;; working but time limit
(defn solve [d arr]
  (->>
   (for [x (range (count arr))
         y (range 1 (count arr))
         z (range 2 (count arr))
         :when (and (< x y z)
                    (= d
                       (- (nth arr y) (nth arr x))
                       (- (nth arr z) (nth arr y))))]
     [x y z])
   count))

(->> (solve 3 s)
     time
     println)


;;  (1 2 4 5 7 8 10)


;; works but still to slow
(defn find-magic-idx [s d idx]
  (->>
   (let [left (take idx s)
         right (drop (inc idx) s)
         m (nth s idx)]
     (for [l left
           r right
           :when (= d
                    (- m l)
                    (- r m))]
       [l m r]))
   count))

(defn solve2 [d arr]
  (reduce + (map #(find-magic-idx arr d %)
                 (range 1 (count arr)))))


;; to slow
(defn find-magic-idx [s d idx]
  (let [left (take idx s)
        right (drop (inc idx) s)
        m (nth s idx)
        ln (- m d)
        rn (+ d m)]
    (* (count (filter #(= % ln) left))
       (count (filter #(= % rn) right)))))

(defn solve4 [d arr]
  (reduce + (map #(find-magic-idx arr d %)
                 (range 1 (count arr)))))

;; 16s
(time (solve4 1 long-input))

