(ns com.phronemophobic.membrane-skija-example
  (:require [membrane.skija :as skija]
            [membrane.ui :as ui]
            [membrane.component :as component]
            [membrane.example.todo :as td])
  (:gen-class))

(defonce counter (atom 0))

(defn test-ui []
  (ui/vertical-layout
   (ui/label "Hello World")
   (ui/on
    :mouse-down
    (fn [_]
      (swap! counter inc)
      nil)
    (ui/label (str "count: " @counter)))))

(defn run-test-ui [ & args]
  (skija/run #'test-ui))

(defn run-todo-app [& args]

  (skija/run (component/make-app #'td/todo-app
                                 {:todos
                                  [{:complete? false
                                    :description "first"}
                                   {:complete? false
                                    :description "second"}
                                   {:complete? true
                                    :description "third"}]
                                  :next-todo-text ""}))
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (run-test-ui))
