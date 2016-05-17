(ns enigma.core
  (:gen-class))


  (def alphabet  "ABCDEFGHIJKLMNOPQRSTUVWXYZ")

  (def rotor-1   "EKMFLGDQVZNTOWYHXUSPAIBRCJ")
  (def rotor-2   "AJDKSIRUXBLHWTMCQGZNPYFVOE")
  (def rotor-3   "BDFHJLCPRTXVZNYEIWGAKMUSQO")

  (def reflector-a "EJMZALYXVBWFCRQUONTSPIKHGD")
  (def reflector-b "YRUHQSLDPXNGOKMIEBFZCWVJAT")
  (def reflector-c "FVPJIAOYEDRZXWGCTKUQSBNMHL")

  (defn rotor-into-wheel [rotor]
    (seq rotor))

  (defn rotate-wheel [wheel]
    (concat (rest wheel) [(first wheel)]))

  (defn index-of [char wheel]
    (.indexOf wheel char))

  (defn char-at [index wheel]
    (nth wheel index))

(defn -main
  [& rest]
  (def wheel-1 (rotor-into-wheel rotor-1))
  (println (char-at 4 wheel-1))

)
