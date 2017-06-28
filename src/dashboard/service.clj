(ns dashboard.service
  (:require [clojure.java.io :as io]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.ring-middlewares :as middlewares]
            [ring.util.response :as ring-resp]
            [ring.middleware.session.cookie :as cookie]
            [dashboard.database.common :as db-common]
            [dashboard.html.common :as common-html]
            [dashboard.html.login :as login]
            [dashboard.html.index :as index]))




(def auth-interceptor
  {:name ::login
   :leave (fn [context]
            (let [userdata (get-in context [:request :session])]
              (if (empty? userdata)
                (assoc context :response (ring-resp/redirect "/login"))
                context)))})

(defn index
  [req]
  (ring-resp/response (index/index)))

(defn login
  [req]
  (ring-resp/response (login/auth-form)))


(defn check-auth
  [req]
  (let [username (get-in req [:params :username])
        password (get-in req [:params :password])
        userdata (db-common/login username password)]
    (if (nil? userdata)
      (ring-resp/response (login/auth-form (common-html/error "Usuário e/ou senha incorretos")))
      (-> (ring-resp/redirect "/")
          (assoc :session {:userdata userdata})))))


(def routes
    (route/expand-routes
     [[["/"
        ^:interceptors[auth-interceptor]
        {:get `index}]
       ["/login"
        ^:interceptors[]
        {:get `login :post `check-auth }]]]))

(def service {:env                 :prod
              ::http/routes        routes
              ::http/resource-path "/public/assets"
              ::http/type          :jetty
              ::http/port          8090})

(def interceptors  [(body-params/body-params)
                    http/html-body
                    middlewares/params
                    middlewares/keyword-params
                    (middlewares/session {:store (cookie/cookie-store)})])
