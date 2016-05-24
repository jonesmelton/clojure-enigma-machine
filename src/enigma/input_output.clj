(ns enigma.input-output
  (:require [enigma.static-parts :refer :all]
            [enigma.rotor-ops :refer :all]))

(defn index-of [char wheel]
  (.indexOf wheel char))

(defn char-at [index wheel]
  (nth wheel index))

; letter -> index
(defn translate-letter [char rotor]
  (index-of (char-at (index-of char raw-alphabet) (rotor :wheel)) (rotor :alphabet)))

; index -> index
(defn translate-l [index rotor]
  (index-of (char-at index (rotor :wheel)) (rotor :alphabet)))

; index <- index
(defn translate-r [index rotor]
  (index-of (char-at index (rotor :alphabet)) (rotor :wheel)))

; letter -> index
(defn right-to-left
  "Inputs a character and moves up to the reflector"
  [char rotors]
  (translate-l (translate-l (translate-letter char (rotors 0)) (rotors 1)) (rotors 2)))

; index -> index
(defn reflect
  [index]
  (index-of index reflector))

; index -> character
(defn left-to-right
  [index rotors]
  (char-at (translate-r (translate-r (translate-r index (rotors 2)) (rotors 1)) (rotors 0)) raw-alphabet))

(defn single-lap [char grounded-rotors]
  (left-to-right (reflect (right-to-left char grounded-rotors)) grounded-rotors))

(defn rotate? [rotor]
  (if (= (first (rotor :alphabet)) (rotor :notch))
    true
    false))

(defn double-step-center [rotor]
  (if (rotate? rotor)
    (rotate-rotor rotor)
    rotor))

(defn step-center [rotors]
  (if (rotate? (rotors 0))
    (rotate-rotor (rotors 1))
    (double-step-center (rotors 1))))

(defn step-left [rotors]
  (if (rotate? (rotors 1))
    (rotate-rotor (rotors 2))
    (rotors 2)))

(defn step-right [rotors]
  (rotate-rotor (rotors 0)))

(defn step [rotors]
  [(step-right rotors) (step-center rotors) (step-left rotors)])
