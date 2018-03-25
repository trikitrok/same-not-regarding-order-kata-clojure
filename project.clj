(defproject same-not-regarding-order "0.0.1-SNAPSHOT"
  :description "Playing with property-based testing"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :profiles {:dev {:dependencies [[midje "1.9.1"]
                                  [org.clojure/test.check "0.10.0-alpha2"]]}
             ;; You can add dependencies that apply to `lein midje` below.
             ;; An example would be changing the logging destination for test runs.
             :midje {}})
             ;; Note that Midje itself is in the `dev` profile to support
             ;; running autotest in the repl.
