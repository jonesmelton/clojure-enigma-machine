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
                :notch \E} )

(def left-rotor {:alphabet (disc-into-wheel alphabet),
                :wheel (disc-into-wheel disc-1),
                :notch \Q} )


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

(def rotors-vector
 (ground-all [right-rotor center-rotor left-rotor]))

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

(defn single-lap [char rotors-vector]
  (left-to-right (reflect (right-to-left char rotors-vector)) rotors-vector))

(defn rotate? [rotor]
  (if (= (first (rotor :alphabet)) (rotor :notch))
    true
    false))

(defn step-center [rotors]
  (if (rotate? (rotors 0))
    (rotate-rotor (rotors 1))
    (rotors 1)))

(defn step-left [rotors]
  (if (rotate? (rotors 1))
    (rotate-rotor (rotors 2))
    (rotors 2)))

(defn step-right [rotors]
  (rotate-rotor (rotors 0)))

(defn step [rotors]
  [(step-right rotors) (step-center rotors) (step-left rotors)])

(defn multiple-laps [string rotatoes]
  (loop [remaining-letters  string
         encoded-letters    []
         rotors             (step rotatoes)]
    (if-not (seq remaining-letters)
      (apply str encoded-letters)
      (let [[first-char & rest] remaining-letters]
        (recur rest (conj encoded-letters (single-lap first-char rotors)) (step rotors))))))

(defn -main
  [& rest]
  (println (multiple-laps (clojure.string/upper-case (apply str rest)) rotors-vector ))
  )

