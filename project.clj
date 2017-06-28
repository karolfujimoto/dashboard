(defproject dashboard "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/java.jdbc "0.7.0-alpha3"]
                 [postgresql/postgresql "9.3-1102.jdbc41"]
                 [honeysql "0.9.0-beta2"]
                 [hiccup "1.0.5"]
                 [io.pedestal/pedestal.service "0.5.2"]
                 [io.pedestal/pedestal.jetty   "0.5.2"]]
  :main ^:skip-aot dashboard.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
