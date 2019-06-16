(ns concrete-crm.core
  (:use org.httpkit.server)
  (:gen-class))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (defn app [req]
    (println (get req :uri))
    {:status  200
     :headers {"Content-Type" "text/html"}
     :body    "hello HTTP!"})
  (run-server app {:port 8080}))
