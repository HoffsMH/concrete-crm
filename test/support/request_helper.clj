(ns support.request-helper
  (:gen-class))

(defn gen-request [resource & params]
  {:request-method :get
            :headers {"content-type" "text/plain"}
            :uri resource
            :params (first params)})
