(ns enigma.static-parts)

(def alphabet  "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
(def raw-alphabet (seq alphabet))

(def disc-1   "EKMFLGDQVZNTOWYHXUSPAIBRCJ")
(def disc-2   "AJDKSIRUXBLHWTMCQGZNPYFVOE")
(def disc-3   "BDFHJLCPRTXVZNYEIWGAKMUSQO")

(def reflector-a "EJMZALYXVBWFCRQUONTSPIKHGD")
(def reflector-b "YRUHQSLDPXNGOKMIEBFZCWVJAT")
(def reflector-c "FVPJIAOYEDRZXWGCTKUQSBNMHL")
