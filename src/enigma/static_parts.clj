(ns enigma.static-parts
  (:require [enigma.rotor-ops :as rotor]))

(def alphabet  "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
(def raw-alphabet (seq alphabet))

(def disc-1   "EKMFLGDQVZNTOWYHXUSPAIBRCJ")
(def disc-2   "AJDKSIRUXBLHWTMCQGZNPYFVOE")
(def disc-3   "BDFHJLCPRTXVZNYEIWGAKMUSQO")

(def reflector-a "EJMZALYXVBWFCRQUONTSPIKHGD")
(def reflector-b "YRUHQSLDPXNGOKMIEBFZCWVJAT")
(def reflector-c "FVPJIAOYEDRZXWGCTKUQSBNMHL")

(def reflector '(24 17 20 7 16 18 11 3 15 23 13 6 14 10 12 8 4 1 5 25 2 22 21 9 0 19))

(def right-rotor {:alphabet (rotor/disc-into-wheel alphabet),
                :wheel (rotor/disc-into-wheel disc-3),
                :notch \V} )

(def center-rotor {:alphabet (rotor/disc-into-wheel alphabet),
                :wheel (rotor/disc-into-wheel disc-2),
                :notch \E} )

(def left-rotor {:alphabet (rotor/disc-into-wheel alphabet),
                :wheel (rotor/disc-into-wheel disc-1),
                :notch \Q} )

; ground rotors to their defaults of K C M
(def grounded-rotors
 (rotor/ground-all [right-rotor center-rotor left-rotor]))


; parts - static parts
; rotor - rotor ops
