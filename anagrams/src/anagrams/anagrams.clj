(ns anagrams.anagrams
  (:require [clojure.string :as str]))

(defn wordToSortedArray [word] (sort (to-array (str/lower-case  word))))

(defn areAnagrams 
  [word, comapritorWord]
    (= 
      (wordToSortedArray word)
      (wordToSortedArray comapritorWord)))

(defn findAngrams
  [dictionary scramble]
    (->> dictionary
      (filter #(areAnagrams scramble %))
      (filter #(not (= scramble %)))))

