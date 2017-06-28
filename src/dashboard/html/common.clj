(ns dashboard.html.common
  (:require
   [hiccup.core :as html]
   [hiccup.page :as page]))

(defn layout
  [& html]
  (page/html5
   (page/include-css "bootstrap/css/bootstrap.min.css" "stylesheets/style.css")
   (page/include-js "bootstrap/js/bootstrap.min.js" "jquery-3.1.1.min.js")
   (html/html [:body
               [:nav {:class "navbar navbar-inverse navbar-fixed-top"}]
               [:div {:class "container"}
                [:div {:class "navbar-header"}
                 [:a {:class "navbar-brand" :href "#"} "Projeto"]]
                [:div {:class "collapse navbar-collapse"}]
                html]])))


(defn error
  [message]
  [:div {:class "alert alert-danger"} message])
