(ns enigma.input-output
  (:require [enigma.static-parts :as parts]
            [enigma.rotor-ops :as rotor]))

; string -> string
(defn validate-str
  [string]
  (clojure.string/upper-case (apply str (re-seq #"[a-zA-Z]" string))))

(defn index-of [char wheel]
  (.indexOf wheel char))

(defn char-at [index wheel]
  (nth wheel index))

; letter -> index
(defn translate-letter [char rotor]
  (index-of (char-at (index-of char parts/raw-alphabet) (rotor :wheel)) (rotor :alphabet)))

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
  (index-of index parts/reflector))

; index -> character
(defn left-to-right
  [index rotors]
  (char-at (translate-r (translate-r (translate-r index (rotors 2)) (rotors 1)) (rotors 0)) parts/raw-alphabet))

(defn single-lap [char rotors]
  (left-to-right (reflect (right-to-left char rotors)) rotors))

(defn rotate? [rotor]
  (= (first (rotor :alphabet)) (rotor :notch))
)

(defn double-step-center [rotor]
  (if (rotate? rotor)
    (rotor/rotate-rotor rotor)
    rotor))

(defn step-center [rotors]
  (if (rotate? (rotors 0))
    (rotor/rotate-rotor (rotors 1))
    (double-step-center (rotors 1))))

(defn step-left [rotors]
  (if (rotate? (rotors 1))
    (rotor/rotate-rotor (rotors 2))
    (rotors 2)))

(defn step-right [rotors]
  (rotor/rotate-rotor (rotors 0)))

(defn step [rotors]
  [(step-right rotors) (step-center rotors) (step-left rotors)])

(defn rotor-position
  [rotors]
  (reverse (map :alphabet rotors)))

(defn rotor-windows
  [wheel]
  (map first (rotor-position wheel)))

(defn translate-rotor [string rotatoes]
  (loop [remaining-letters  (rest (validate-str string))
         encoded-letters    []
         rotors             (step rotatoes)]
    (if-not (seq remaining-letters)
      (rotor-windows rotors)
      (let [[first-char & rest] remaining-letters]
        (recur rest (conj encoded-letters (single-lap first-char rotors)) (step rotors))))))
