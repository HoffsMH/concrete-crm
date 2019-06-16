(ns concrete-crm.core
  (:use org.httpkit.server)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [hiccup.core :refer :all])
  (:gen-class))


(defroutes app
  (GET "/" request
       (str "<h1>Hello World</h1>" request))
  (GET "/bye" [] "<h1>Bye World</h1>")

  (GET "/user/:id" [id] (user-handler id))
  (route/not-found "<h1>Page not found</h1>"))

(defn -main
  [& args]
  (run-server app {:port 8080}))

(defn user-handler
  [name]
  (html [:span {:class "foo"} name]))
