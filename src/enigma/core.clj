(ns enigma.core
  (:gen-class))


  (def alphabet  "ABCDEFGHIJKLMNOPQRSTUVWXYZ")

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



;;   (defn rotate-wheel [rotor]
;;     (println (concat (rest (rotor :wheel)) [(first (rotor :wheel))]))
;;     (println (concat (rest (rotor :alphabet)) [(first (rotor :alphabet))]))
;;     "poop")

  (defn index-of [char wheel]
    (.indexOf wheel char))

  (defn char-at [index wheel]
    (nth wheel index))

(defn -main
  [& rest]
  (def wheel-1 (disc-into-wheel rotor-1))
  (println (char-at 4 wheel-1))

)

(def right-rotor {:alphabet (disc-into-wheel alphabet),
                :wheel (disc-into-wheel rotor-1),
                :notch \V} )
;; right-rotor

;; (defn translate-char
;;   [char rotor]
;;   (if (= :notch (first :alphabet))
;;     )
;; )
;; (translate-char \V )

(= "poop" (rotate-wheel right-rotor))

