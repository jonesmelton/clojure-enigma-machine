(ns enigma.core
  (:gen-class))


  (def alphabet  "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
  (def raw-alphabet (seq alphabet))

  (def disc-1   "EKMFLGDQVZNTOWYHXUSPAIBRCJ")
  (def disc-2   "AJDKSIRUXBLHWTMCQGZNPYFVOE")
  (def disc-3   "BDFHJLCPRTXVZNYEIWGAKMUSQO")

  (def reflector-a "EJMZALYXVBWFCRQUONTSPIKHGD")
  (def reflector-b "YRUHQSLDPXNGOKMIEBFZCWVJAT")
  (def reflector-c "FVPJIAOYEDRZXWGCTKUQSBNMHL")

  (defn disc-into-wheel [disc]
    (seq disc))

  (defn rotate-wheel [wheel]
    (concat (rest wheel) [(first wheel)]))

  (defn rotate-rotor [rotor]
    {:alphabet (rotate-wheel (rotor :alphabet)),
     :wheel (rotate-wheel (rotor :wheel)),
     :notch (rotor :notch)})

(rotate-rotor right-rotor)

  (defn index-of [char wheel]
    (.indexOf wheel char))

  (defn char-at [index wheel]
    (nth wheel index))


(def right-rotor {:alphabet (disc-into-wheel alphabet),
                :wheel (disc-into-wheel disc-3),
                :notch \V} )
;; right-rotor

(defn translate-letter [char rotor]
  (index-of
    (char-at
      (index-of char raw-alphabet)
      (rotor :wheel))
    (rotor :alphabet)))


(defn -main
  [& rest]
  (println (translate-letter \A right-rotor))
)

(translate-letter \A right-rotor)

(index-of \A raw-alphabet)
(char-at 0 (right-rotor :wheel))
(index-of \B (right-rotor :alphabet))

(index-of \G raw-alphabet)
(char-at 6 (right-rotor :wheel))
(index-of \C (right-rotor :alphabet))
