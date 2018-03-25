(ns same-not-regarding-order.core-test
  (:require
    [midje.sweet :refer :all]
    [same-not-regarding-order.core :as sut]))

(facts
  "about identifying when sequence elements are same the same not regarding order"
  (fact
    "it identifies when elements are not the same"
    (sut/same-not-regarding-order? [1 2 3] [14]) => false))
