(ns anagrams.anagrams-test
  (:require [clojure.test :refer :all]
            [anagrams.anagrams :refer :all]))

(deftest When-there-are-no-letters-in-the-scramble-then-a-blank-array-is-returned 
    (is 
      (= 
        (findAngrams ["test"]  "") 
        [])))

(deftest When-there-is-no-words-in-the-language-then-a-blank-array-is-returned
  (is 
    (= (findAngrams [] "search") [])))

(deftest when-a-word-contains-all-the-letters-of-the-search-word-then-the-word-is-added-to-the-array
  (is 
    (=
      (findAngrams ["fresher"] "refresh") 
      ["fresher"])))

(deftest when-a-word-contains-all-the-letters-of-the-search-and-more-word-then-the-word-is-not-added-to-the-array
  (is 
    (= 
      (findAngrams ["freshers"] "refresh") 
      [])))

(deftest when-the-word-is-in-the-dictionary-it-is-not-included-in-the-final-array 
  (is
    (=
      (findAngrams ["test"] "test") 
      [])))
