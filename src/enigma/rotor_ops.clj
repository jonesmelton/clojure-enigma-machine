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
  (loop [char char
        rotor rotor])
          (if (= (first (rotor :alphabet)) char)
            rotor
            (recur char (rotate-rotor rotor))))
