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
