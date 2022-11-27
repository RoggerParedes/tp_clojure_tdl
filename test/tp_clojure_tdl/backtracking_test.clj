(ns tp-clojure-tdl.backtracking-test
  (:require [clojure.test :refer :all]
            [tp-clojure-tdl.backtracking :refer :all]))

(def grid [[3 0 6 5 0 8 4 0 0]
           [5 2 0 0 0 0 0 0 0]
           [0 8 7 0 0 0 0 3 1]
           [0 0 3 0 1 0 0 8 0]
           [9 0 0 8 6 3 0 0 5]
           [0 5 0 0 9 0 6 0 0]
           [1 3 0 0 0 0 2 5 0]
           [0 0 0 0 0 0 0 7 4]
           [0 0 5 2 0 6 3 0 0]])

(deftest get-row-test
  (testing "Returns the nth row (starting from 0)"
    (is (= [3 0 6 5 0 8 4 0 0] (get-row grid 0)))
    (is (= [0 0 5 2 0 6 3 0 0] (get-row grid 8)))
    )
  )

(deftest get-col-test
  (testing "Returns the nth col (starting from 0)"
    (is (= [3 5 0 0 9 0 1 0 0] (get-col grid 0)))
    (is (= [8 0 0 0 3 0 0 0 6] (get-col grid 5)))
    )
  )

(deftest get-square-test
  (testing "Returns the elements of the square corresponding to a given row and column"
    (is (= [3 0 6 5 2 0 0 8 7] (get-square grid 0 2)))
    (is (= [5 0 8 0 0 0 0 0 0] (get-square grid 2 4)))
    (is (= [2 5 0 0 7 4 3 0 0] (get-square grid 8 8)))
    )
  )

(deftest is-in-test
  (testing "Checks if an element is in an array"
    (is (true? (is-in [1 2 3 5] 5)))
    (is (false? (is-in [1 2 3 5] 4)))
    )
  )