(ns maxrot.core)

(defn digits [n]
  (->> n str (map (comp read-string str))))

(defn max-rot [n]
  (let [n-seq (digits n)]
  (concat (rest n-seq) [(first n-seq)])

)
