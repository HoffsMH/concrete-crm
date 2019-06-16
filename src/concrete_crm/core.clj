(ns concrete-crm.core
  (:use org.httpkit.server)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [hiccup.core :refer :all]
            [hiccup.form :refer :all])
  (:gen-class))

(defn user-handler
  [name]
  (html [:p (form-to [:post "/numbers"]
                     (text-field {:placeholder "189"} "number")
                     (submit-button "submit"))]))

(defn quick-form
  []
  (html
   (form-to {:enctype "multipart/form-data"}
            [:post "/numbers"]
            (text-field "Hello")
            (submit-button {:class "btn" :name "submit"} "Save")
            (submit-button {:class "btn" :name "submit"} "Clone"))))

(defn number-handler
  [number]
  number)

(defroutes app
  (POST "/numbers" [:as request] (str (request :multipart-params)))
  (GET "/" request
       (str "<h1>Hello World</h1>" request))
  (GET "/bye" [] "<h1>Bye World</h1>")
  (GET "/user/:id" [id] (quick-form))
  (route/not-found "<h1>Page not found</h1>"))

(defn -main
  [& args]
  (run-server app {:port 8080}))
