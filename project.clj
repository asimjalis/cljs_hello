(defproject cljs_hello "1.0.3"
  :description "ClojureScript hello world project with browser REPL."
  :dependencies [
    [org.clojure/clojure "1.5.1"]
    [org.clojure/clojurescript "0.0-2202"] ]
  :plugins [
    [lein-cljsbuild "1.0.3"]
    [com.cemerick/clojurescript.test "0.3.1"] ]
  :hooks [leiningen.cljsbuild]
  :cljsbuild {
    :builds {
      :dev
      {:source-paths ["."]
       :compiler {:output-to "cljs_hello.js"
                  :optimizations :whitespace
                  :pretty-print true}}
      :prod
      {:source-paths ["."]
       :compiler {:output-to "cljs_hello.js"
                  :optimizations :advanced
                  :pretty-print false}}}})
