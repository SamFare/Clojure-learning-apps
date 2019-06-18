(ns pizza.core
  (:gen-class))

(use '[clojure.string :only (join)])

(defn pizzaOrderAsString 
  [pizzaOrders]
    (->> pizzaOrders
              (map-indexed  
                  #(format "%d: %s price: %.2f" 
                        (+ % 1)
                        (get %2 :id) 
                        (get %2 :price)))
              (join "\n")))

(defn -main []
  (let [ pizzaOrders [ 
    {
      :id "peperoni"
      :price 23.99
    },
    {
      :id "mozerella"
      :price 23.99
    },
    {
      :id "Nudja"
      :price 23.99
    }] ]
  
  (println "Please select a pizza to add to your basket:")
  (println (pizzaOrderAsString pizzaOrders))
  (print "Enter your choice here >> ")))
