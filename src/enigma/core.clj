(ns enigma.core
  (:gen-class))

(defn -main

  (def alphabet  "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
  (def rotor-1   "EKMFLGDQVZNTOWYHXUSPAIBRCJ")
  (def rotor-2   "AJDKSIRUXBLHWTMCQGZNPYFVOE")
  (def rotor-3   "BDFHJLCPRTXVZNYEIWGAKMUSQO")

  (def reflector-a "EJMZALYXVBWFCRQUONTSPIKHGD")
  (def reflector-b "YRUHQSLDPXNGOKMIEBFZCWVJAT")
  (def reflector-c "FVPJIAOYEDRZXWGCTKUQSBNMHL")

)
