(ns com.phronemophobic.drawstring-crash
  (:require [membrane.skija :as skija]
            [membrane.ui :as ui]
            [membrane.component :as component]
            [membrane.example.todo :as td])
  (:gen-class))


(defn -main [& args]
  (skija/run #(ui/translate 30 30
                            (ui/no-events
                             (reify
                               ui/IOrigin
                               (-origin [this]
                                 [0 0])
                               ui/IBounds
                               (-bounds [this]
                                 [0 0])
                               
                               skija/IDraw
                               (draw [this]
                                 (.drawString  skija/*canvas* "hello world" 0 0 (skija/get-font nil) nil)))))))
