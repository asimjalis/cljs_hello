(ns cljs_hello
  (:use
    [clojure.string :only [join]]
    [clojure.walk :only [keywordize-keys]]
    ) 
  (:require 
    [clojure.browser.repl :as repl]
    [cemerick.cljs.test :as t]
    )
  (:require-macros 
    [clojure.template :as template]
    [cemerick.cljs.test
      :refer (is deftest with-test run-tests testing test-var)]
      ))

(deftest test-something
  (is (= 3 3)))

(repl/connect "http://localhost:9000/repl")

(defn form->map [] 
  "Convert form inputs with names to name-value map." 
  (->> (js/$ "form") 
    (.serializeArray) (js->clj) 
    (map #(hash-map (% "name") (% "value")))
    (keywordize-keys) (apply merge)))

(defn str->int 
  "Convert string to int or return default."
  [default x] 
  (let [x (js/parseInt x)] 
    (if (js/isNaN x) default x)))

(defn html->output [html] 
  (.html (js/$ "#output") html))

(defn main []
  (html->output "Hello world from ClojureScript!"))
