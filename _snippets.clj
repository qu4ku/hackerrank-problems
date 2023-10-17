(ns snippets
  (:require [clojure.test :refer :all]
            [clojure.string :as str]))

;; USEFUL SNIPPETS FOUND IN SOLUTIONS



;; reading input
(defn str->nums [str]
  (->> (str/split str #" ")
       (map #(Integer/parseInt %))))

(def T (Integer/parseInt (read-line)))

(doseq [_ (range T)]
  (solve (str->nums (read-line))))


;; reading input / clean
(defn save-prisoner []
  (let [n (read)
        m (read)
        s (dec (read))]
    (prn (inc (rem (+ s (dec m)) n)))))

(let [t (read)]
  (dorun (repeatedly t save-prisoner)))
; can be tested
(with-in-str "3\n10 5 3\n10 5 3\n10 5 3\n"
  (let [t (read)]
    (dorun (repeatedly t save-prisoner))))




;; reading input
(defn readv [] (mapv read-string (str/split (read-line) #"\s")))
(defn readi [] (read-string (read-line)))
(defn readm [n] (vec (repeatedly n readv)))

(dotimes [i (readi)]
  (let [[n m s] (readv)
        last (inc (mod (+ (dec m) (dec s)) n))]
    (println last)))
