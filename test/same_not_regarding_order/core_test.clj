(ns same-not-regarding-order.core-test
  (:require
    [midje.sweet :refer :all]
    [clojure.test.check.generators :as gen]
    [midje.experimental :refer [for-all]]
    [same-not-regarding-order.core :as sut]))

(facts
  "about identifying when sequence elements are the same not regarding order"

  (fact
    "when they are not"
    (sut/same-not-regarding-order?
      [1 2 3] [14]) => false

    (sut/same-not-regarding-order?
      [1 2 3] [1 1 2 3]) => false)

  (for-all
    [elems (gen/vector gen/int)]
    {:num-tests 100}
    (fact "when they are"
      (sut/same-not-regarding-order? elems (shuffle elems)) => true)))