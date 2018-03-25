(ns same-not-regarding-order.core-test
  (:require
    [midje.sweet :refer :all]
    [clojure.test.check.generators :as gen]
    [midje.experimental :refer [for-all]]
    [same-not-regarding-order.core :as sut]))

(facts
  "about identifying when sequence elements are the same not regarding order"

  (for-all
    [elems (gen/vector gen/int)]
    {:num-tests 1000}
    (fact "when they are"
      (sut/same-not-regarding-order? elems (shuffle elems)) => true))

  (for-all
    [[elems1 elems2] (gen/list-distinct (gen/vector gen/int) {:num-elements 2})]
    {:num-tests 1000}
    (fact "when they are not"
      (sut/same-not-regarding-order? elems1 elems2) => false))

  (fact
    "when they are not because of repeated elements"
    (sut/same-not-regarding-order?
      [1 2 3] [1 1 2 3]) => false))