(ns anagrams.core-test
    (:require [clojure.test :refer :all]
              [anagrams.core :refer :all]))

(deftest the-getArrayFromNewlinedelimitedFile-returns-a-single-value-when-there-is-one-item-in-the-file 
(is (= (getArrayFromNewlinedelimitedFile "test/anagrams/test_files/singleVarFile.txt") ["hello"])))


(deftest the-getArrayFromNewlinedelimitedFile-returns-a-each-value-in-the-array-as-an-array-tem
    (is (= 
        (getArrayFromNewlinedelimitedFile 
            "test/anagrams/test_files/multipleValueVarFile.txt") 
            ["hello", "world"])))