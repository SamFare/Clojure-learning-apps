(ns pizza.core
  (:gen-class))

(use '[clojure.string :only (join)])

(defn getPizzaOrders [] [ 
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
  }])

(defn pizzaOrderAsString 
  [pizzaOrders]
    (->> pizzaOrders
              (map-indexed  
                  #(format "%d: %s price: %.2f" 
                        (+ % 1)
                        (get %2 :id) 
                        (get %2 :price)))
              (join "\n")))

(defn findPizza 
  [pizzaOrders pizzaChoice]
    (let [pizzaChoiceList 
          (filter #(= (get % :id) pizzaChoice) pizzaOrders)]
    (if (not (empty? pizzaChoiceList)) 
      (first pizzaChoiceList) 
      (throw (Exception. "") ))))

(defn displayBasket
  [selectedOrders]
  (println "\nBasket ---------")
  (println 
    (->> selectedOrders
      (map #(format "%s %.2f" (get % :id) (get % :price)))
      (join "\n"))))

(defn eventLoop
    [pizzaOrders, selectedOrders]
      
        (displayBasket selectedOrders)
        (println "Please select a pizza to add to your basket:")
        (println (pizzaOrderAsString pizzaOrders))
        (println "Enter your choice here >> ")
        
        (try
          (let [pizzaChoice (read-line)]
            (eventLoop pizzaOrders, 
                (conj selectedOrders (findPizza pizzaOrders pizzaChoice))))
          (catch Exception e 
            (println " 😢: Not a valid Pizza choice 🍕")
            (eventLoop pizzaOrders selectedOrders))))

(defn -main []
  (let [ pizzaOrders  (getPizzaOrders) ]
    (let [selectedOrders ()]
      (eventLoop pizzaOrders selectedOrders)))) 
      
      
