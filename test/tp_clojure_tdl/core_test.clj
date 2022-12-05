(ns tp-clojure-tdl.core-test
  (:require [clojure.test :refer :all]
            [tp-clojure-tdl.core :refer :all]))

(deftest b-test
  (testing "If the Inut file is not empty then return true")
  (is (= true (is_empty_name "data")))
)

(deftest c-test
  (testing "If the Inut file is empty then return False")
  (is (= false (is_empty_name "")))
)

(deftest d-test
  (testing "If we receive file with extension .json then, validate_extension_file return True"
    (is (= true (validate_extension_file "arch.json")))
  )
)

(deftest e-test
  (testing "If we receive file without extension .json then, validate_extension_file return False"
    (is (= false (validate_extension_file "arch.html")))
  )
)

(deftest f-test
  (testing "If file not exists then return false"
    (is (= false (file_exists "prueba2.txt")))
  )  
)


(deftest g-test
  (testing "If file exists then return true"
    (is (= true (file_exists "/home/rogger/prueba.txt")))
  )  
)

(deftest h-test
  (testing "It verify that the file not exists and not equal to true"
    (is (not= true (file_exists "pruebsa.txt")))
  ) 
)

(deftest i-test
  (testing "I want to remove the character '[' and ']'"
    (let [line (atom {:value "casa[]"})
          myVect (vector 
         {:character "]" :newCharacter ""} 
         {:character "[" :newCharacter ""}
        )] (do
             (remove_character myVect line) 
             (is (= "casa" (get @line :value)))))
  ) 
)


(deftest replace-in-str-test
  (testing "replace-in-str replace a substring for a given new string"
    (is (= "HÑÑa" (replace-in-str "Hola" "ol" "ÑÑ")))
    (is (= "Hola" (replace-in-str "Hola" "pa" "ÑÑ")))
    (is (= "167083000" (replace-in-str "167.83..." "." "0")))
    )
  )

(deftest clear-line-test
  (testing "clear special chars and let only numbers"
    (is (= "167083000300050008080000400000020000005000700600030002020007960906000200040002003"
           (clear-line "167.83...|3...5...8|.8....4..|....2....|..5...7..|6...3...2|.2...796.|9.6...2..|.4...2..3")))
    ))

(deftest grid-from-line-test
  (testing "Generates a grid from a string containing 81 positions. If it can't returns nil"
    (is (nil? (grid-from-line "lalala")))
    (is (= [[1 6 7 0 8 3 0 0 0] [3 0 0 0 5 0 0 0 8] [0 8 0 0 0 0 4 0 0]
            [0 0 0 0 2 0 0 0 0] [0 0 5 0 0 0 7 0 0] [6 0 0 0 3 0 0 0 2]
            [0 2 0 0 0 7 9 6 0] [9 0 6 0 0 0 2 0 0] [0 4 0 0 0 2 0 0 3]]
           (grid-from-line "167.83...|3...5...8|.8....4..|....2....|..5...7..|6...3...2|.2...796.|9.6...2..|.4...2..3")))
    )
  )