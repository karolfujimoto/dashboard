(ns dashboard.database.common
  (:require [clojure.java.jdbc :as jdbc]
            [honeysql.core :as sql]
            [honeysql.helpers :refer :all]))

(def db {:dbtype "postgresql"
         :dbname "dashboard"
         :host "localhost"
         :user "postgres"
         :password "logfield@123"})

(defn get-users
  []
  (jdbc/query db ["select * from users"]))

(defn login
  [user password]
  (first (jdbc/query db ["select * from users where username = ? and password = ?" user password])))
