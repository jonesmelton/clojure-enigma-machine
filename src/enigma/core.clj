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

; letter -> index
(defn translate-letter [char rotor]
  (index-of (char-at (index-of char raw-alphabet) (rotor :wheel)) (rotor :alphabet)))

; index -> index
(defn translate-index [index rotor]
  (index-of (char-at index (rotor :wheel)) (rotor :alphabet)))

; index <- index
(defn translate-r [index rotor]
  (index-of (char-at index (rotor :alphabet)) (rotor :wheel)))

(def rotors-vector (atom [right-rotor center-rotor left-rotor]))


; (def all-rotors
;   (ground-all [right-rotor center-rotor left-rotor]))

; letter -> index
(defn right-to-left
  "Inputs a character and moves up to the reflector"
  [char rotors]
  (translate-index (translate-index (translate-letter char (rotors 0)) (rotors 1)) (rotors 2)))

; index -> index
(defn reflect
  [index]
  (index-of index reflector))

; index -> character
(defn left-to-right
  [index rotors]
  (char-at (translate-r (translate-r (translate-r index (rotors 2)) (rotors 1)) (rotors 0)) raw-alphabet))

(defn single-lap [char]
  (swap! rotors-vector ground-all)
  (left-to-right (reflect (right-to-left \E @rotors-vector)) @rotors-vector))

(defn -main
  [& rest]
  (println (right-to-left \B))
  )
