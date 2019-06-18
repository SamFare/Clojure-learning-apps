(ns pizza.core-test
  (:require [clojure.test :refer :all]
            [pizza.core :refer :all]))

(use '[clojure.string :only (includes?)])


(def pizzaOrders [ 
    {
      :id "peperoni"
      :price 15.65
    },
    {
      :id "mozerella"
      :price 15.65
    },
    {
      :id "Nudja"
      :price 15.65
    }])

(deftest the-pizzaOrderAsString-function-returns-all-the-pizza-names-in-the-string
  (testing "the pizzaOrderAsString function returns all the pizza names in the string"
    (is (includes? (pizzaOrderAsString pizzaOrders) "peperoni"))
    (is (includes? (pizzaOrderAsString pizzaOrders) "mozerella"))
    (is (includes? (pizzaOrderAsString pizzaOrders) "Nudja"))))


(deftest the-pizzaOrderAsString-function-returns-all-the-pizza-prices-in-the-string
  (testing "the pizzaOrderAsString function returns all the pizza prices in the string"
    (is (includes? (pizzaOrderAsString pizzaOrders) "15.65"))
    (is (includes? (pizzaOrderAsString pizzaOrders) "15.65"))
    (is (includes? (pizzaOrderAsString pizzaOrders) "15.65"))))

(deftest the-pizzaOrderAsString-function-returns-indexes-for-each-pizza
  (testing "the pizzaOrderAsString function returns all the pizza prices in the string"
    (is (includes? (pizzaOrderAsString pizzaOrders) "1:"))
    (is (includes? (pizzaOrderAsString pizzaOrders) "2:"))
    (is (includes? (pizzaOrderAsString pizzaOrders) "3:"))))