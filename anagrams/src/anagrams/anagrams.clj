(ns anagrams.anagrams)

(defn wordToSortedArray [word] (sort (to-array word)))

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

