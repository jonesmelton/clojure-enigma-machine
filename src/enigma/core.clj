(ns enigma.core
  (:require [enigma.static-parts :refer :all]
            [enigma.rotor-ops :refer :all]
            [enigma.input-output :refer :all])
  (:gen-class))

(defn translate-string [string rotatoes]
  (loop [remaining-letters  string
         encoded-letters    []
         rotors             (step rotatoes)]
    (if-not (seq remaining-letters)
      (apply str encoded-letters)
      (let [[first-char & rest] remaining-letters]
        (recur rest (conj encoded-letters (single-lap first-char rotors)) (step rotors))))))

(defn -main
  [& rest]
  (println (translate-string (clojure.string/upper-case (apply str rest)) grounded-rotors ))
  )
