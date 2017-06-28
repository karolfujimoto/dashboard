(ns dashboard.html.index
  (:require [dashboard.html.common :as common-html]))

(defn index
  [& addons]
  (common-html/layout
   [:div {:class "panel panel-default"}
    [:h1 "Hello dear, angel from my nightmare"]]))

