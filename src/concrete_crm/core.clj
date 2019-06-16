(ns concrete-crm.core
  (:use org.httpkit.server)
  (:require [compojure.core :refer :all]
            [compojure.route :as route])
  (:gen-class))


(defroutes app
  (GET "/" request
       (str "<h1>Hello World</h1>" request))
  (GET "/bye" [] "<h1>Bye World</h1>")
  (route/not-found "<h1>Page not found</h1>"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (run-server app {:port 8080}))
