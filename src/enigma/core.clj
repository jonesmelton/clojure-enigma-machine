(ns enigma.core
  (:require [enigma.static-parts :refer :all]
            [enigma.rotor-ops :refer :all])
  (:gen-class))

  (defn index-of [char wheel]
    (.indexOf wheel char))

  (defn char-at [index wheel]
    (nth wheel index))

(def right-rotor {:alphabet (disc-into-wheel alphabet),
                :wheel (disc-into-wheel disc-3),
                :notch \V} )

(def center-rotor {:alphabet (disc-into-wheel alphabet),
                :wheel (disc-into-wheel disc-2),
                :notch \C} )

(def left-rotor {:alphabet (disc-into-wheel alphabet),
                :wheel (disc-into-wheel disc-1),
                :notch \M} )


;; right-rotor

(defn translate-letter [char rotor]
  (index-of (char-at (index-of char raw-alphabet) (rotor :wheel)) (rotor :alphabet)))

(defn -main
  [& rest]
  (println (rotate-wheel raw-alphabet))
)

(defn right-to-left
  "Inputs a character and moves up to the reflector"
  [char]
  )
