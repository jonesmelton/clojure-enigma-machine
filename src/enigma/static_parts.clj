(ns enigma.static-parts)

(def alphabet  "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
(def raw-alphabet (seq alphabet))

(def disc-1   "EKMFLGDQVZNTOWYHXUSPAIBRCJ")
(def disc-2   "AJDKSIRUXBLHWTMCQGZNPYFVOE")
(def disc-3   "BDFHJLCPRTXVZNYEIWGAKMUSQO")

(def reflector-a "EJMZALYXVBWFCRQUONTSPIKHGD")
(def reflector-b "YRUHQSLDPXNGOKMIEBFZCWVJAT")
(def reflector-c "FVPJIAOYEDRZXWGCTKUQSBNMHL")

(def reflector '(24 17 20 7 16 18 11 3 15 23 13 6 14 10 12 8 4 1 5 25 2 22 21 9 0 19))
