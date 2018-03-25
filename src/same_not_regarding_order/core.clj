(ns same-not-regarding-order.core)

(defn same-not-regarding-order? [s1 s2]
  (and
    (= (count s1) (count s2))
    (= (set s1) (set s2))))