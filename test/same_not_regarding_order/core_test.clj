(ns same-not-regarding-order.core-test
  (:require
    [midje.sweet :refer :all]
    [clojure.test.check.generators :as gen]
    [midje.experimental :refer [for-all]]
    [same-not-regarding-order.core :as sut]))

(facts
  "about identifying when sequence elements are the same not regarding order"

  (facts "when they are"
    (for-all
      [elems (gen/vector-distinct gen/int)]
      {:num-tests 1000}
      (fact "without duplicates"
        (sut/same-not-regarding-order? elems (shuffle elems)) => true))

    (for-all
      [elems (gen/let [v (gen/not-empty (gen/vector gen/int))
                       t (gen/tuple (gen/such-that #(> % 1) gen/s-pos-int) gen/int)]
                      (->> (apply repeat t)
                           (concat v)))]
      (fact "with duplicates"
        (sut/same-not-regarding-order? elems (shuffle elems)) => true)))

  (facts "when they are not"
    (for-all
      [[elems1 elems2] (gen/list-distinct (gen/vector-distinct gen/int) {:num-elements 2})]
      {:num-tests 1000}
      (fact "without duplicates"
        (sut/same-not-regarding-order? elems1 elems2) => false))

    (for-all
      [elems (gen/let [v (gen/not-empty (gen/vector gen/int))
                       t (gen/tuple (gen/such-that #(> % 1) gen/s-pos-int) gen/int)]
                      (->> (apply repeat t)
                           (concat v)))]
      {:num-tests 1000}
      (fact "with duplicates"
        (sut/same-not-regarding-order? elems (distinct elems)) => false))))