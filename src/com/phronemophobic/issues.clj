(ns com.phronemophobic.issues
  (:require [membrane.skija :as skija]
            [membrane.ui :as ui]
            [membrane.component :as component]
            [membrane.example.todo :as td])
  (:import [org.jetbrains.skija Paint Font FontMgr FontStyle])
  (:gen-class))



(def menlo-font (Font.  (.matchFamilyStyle (FontMgr/getDefault)
                                           "Menlo" FontStyle/NORMAL)
                       (float 14)))

(defn drawstring-works [& args]
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
                                 (.drawString  skija/*canvas* "hello world" 0 0 menlo-font
                                               (Paint.))))))))

(defn drawstring-crash-null-paint [& args]
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
                                 (.drawString  skija/*canvas* "hello world" 0 0 menlo-font nil)))))))


(defn drawstring-crash-null-typeface [& args]
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
                                 (.drawString  skija/*canvas*
                                               "hello world"
                                               0 0
                                               (Font. nil (float 14))
                                               (Paint.))))))))



