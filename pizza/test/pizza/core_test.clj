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

(deftest the-findPizza-function-Returns-The-Pizza-that-is-requested
  (testing "the findPizza function Returns The Pizza that is requested"
    (is 
      ( = 
        (findPizza pizzaOrders "peperoni") 
        { :id "peperoni" :price 15.65 }))))

(deftest the-findPizza-function-Throws-An-error-if-the-pizza-is-not-valid
  (testing "the findPizza function Throws An error if the pizza is not valid"
    (is (thrown? Exception (findPizza pizzaOrders "notInList")))))

(deftest the-calculateTotalCost-function-retruns-0-when-there-is-nothing-in-the-list
  (testing "The calculateTotalCost function retruns 0 when there is nothing in the list"
    (is (= (calculateTotalCost  []) 0))))

(deftest the-calculateTotalCost-function-retruns-the-value-of-the-one-item-in-the-list
  (testing "The calculateTotalCost function retruns 0 when there is nothing in the list"
    (is (= (calculateTotalCost  [{:price 23.99}]) 23.99))))
    
(deftest the-calculateTotalCost-function-retruns-the-sum-of-all-items-in-the-list
  (testing "The calculateTotalCost function retruns the sum of all items in the list"
    (is (= (calculateTotalCost  [{:price 23.99}, {:price 15.99}]) 39.98))))