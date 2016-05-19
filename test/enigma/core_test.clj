(ns enigma.core-test
  (:require [clojure.test :refer :all]
            [enigma.core :refer :all]
            [enigma.static-parts :refer :all]
            [enigma.rotor-ops :refer :all]))



(deftest index-functions
  (testing "index-of returns the correct number"
    (is (= 0 (index-of \A raw-alphabet))))

  (testing "char-at returns the correct number"
    (is (= \A (char-at 0 raw-alphabet)))))

(deftest rotor-functions
  (testing "rotate actually rotates"
    (is (= '(\B \C \D \E \F \G \H \I \J \K \L \M \N \O \P \Q \R \S \T \U \V \W \X \Y \Z \A) (rotate-wheel raw-alphabet))))

  (testing "sets ground and translates"
    (is (= 2 (translate-letter \L (set-ground \K right-rotor))))))

(deftest grounding
  (testing "set-ground rotates to the given character"
    (is (= \K (first ((set-ground \K right-rotor) :alphabet))))))

(deftest ground-all-the-rotors
  (testing "sets the ground for all three rotors"
    (is (= [\K \C \M] (map first (map :alphabet (ground-all [right-rotor center-rotor left-rotor])))))))

(deftest chaining-rotors
  (testing "traverses the rotors from right to left"
    (is (= 19 (right-to-left \B (ground-all [right-rotor center-rotor left-rotor])))))

  (testing "traverses the rotors from left to right"
    (is (= \S (left-to-right 20 (ground-all [right-rotor center-rotor left-rotor]))))))

(deftest reflecting
  (testing "reflects the correct index"
    (is (= 20 (reflect 2)))))
