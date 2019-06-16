(ns concrete-crm.core-test
  (:require [clojure.test :refer :all]
            [concrete-crm.core :refer :all]
            [support.request-helper :refer :all]
            ))

(deftest test-router
  (testing "test the happy path on router"
    (let [
          request (gen-request "/")
          response (app request)
          ]
      (is (= (:status response) 200)
    ))))
