(ns same-not-regarding-order.core)

(defn same-not-regarding-order? [s1 s2]
  (= (set s1) (set s2)))
