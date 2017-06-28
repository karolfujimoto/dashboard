(ns dashboard.html.login
  (:require [hiccup.form :as form]
            [dashboard.html.common :as common-html]))


(defn auth-form
  [& addons]
  (common-html/layout
   [:div {:class "panel panel-default col-sm-4 col-sm-offset-4" :id "auth-form"}
    [:form {:class "form-horizontal" :action "/login" :method "post"}
     [:h3 "LOGIN"]
     addons
     [:div {:class "panel-body"}
      [:div {:class "form-group input-group input-group-lg"}
       [:span {:class "input-group-addon glyphicon glyphicon-user" :type "text"}]
       (form/text-field {:class "form-control" :placeholder "Usuário"} "username")]
      [:div {:class "form-group input-group input-group-lg"}
       [:span {:class "input-group-addon glyphicon glyphicon-lock"}]
       (form/text-field {:class "form-control" :type "password" :placeholder "Senha"} "password")]
      [:button {:class "btn btn-lg btn-block" :type "submit"} "Entrar"]]]]))


