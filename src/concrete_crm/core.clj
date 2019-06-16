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

(defn alt-user-handler
  [name]
  "<form action=\"/numbers\" method=\"post\">
  <div>
    <label for=\"say\">What greeting do you want to say?</label>
    <input name=\"say\" id=\"say\" value=\"Hi\">
  </div>
  <div>
    <label for=\"to\">Who do you want to say it to?</label>
    <input name=\"to\" id=\"to\" value=\"Mom\">
  </div>
  <div>
    <button>Send my greetings</button>
  </div>
</form>"
)

(defn number-handler
  [number]
  number)

(defroutes app
  (POST "/numbers" req (str "suup" req))
  (GET "/" request
       (str "<h1>Hello World</h1>" request))
  (GET "/bye" [] "<h1>Bye World</h1>")
  (GET "/user/:id" [id] (alt-user-handler id))
  (route/not-found "<h1>Page not found</h1>"))

(defn -main
  [& args]
  (run-server app {:port 8080}))
