(ns anagrams.core
    (:gen-class)
    (:require [anagrams.anagrams :refer :all]
              [clojure.java.io :as io]
              [clojure.string :as str]))

(defn getArrayFromNewlinedelimitedFile 
    [fileName]
    (str/split (slurp fileName) #"\n+"))    

(defn -main
    []
    (println "Enter a string of text:")
    (let [scramble (read-line)] 
        (println
            (findAngrams (getArrayFromNewlinedelimitedFile "http://codekata.com/data/wordlist.txt") scramble))))