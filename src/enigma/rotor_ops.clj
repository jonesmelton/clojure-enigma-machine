(ns enigma.rotor-ops)

(defn disc-into-wheel [disc]
  (seq disc))

(defn rotate-wheel [wheel]
  (concat (rest wheel) [(first wheel)]))

(defn rotate-rotor [rotor]
  {:alphabet (rotate-wheel (rotor :alphabet)),
   :wheel (rotate-wheel (rotor :wheel)),
   :notch (rotor :notch)})

(defn set-ground [char rotor]
  (if (= (rotor :alphabet) char)
  (rotor)
  (rotate-rotor rotor)))
