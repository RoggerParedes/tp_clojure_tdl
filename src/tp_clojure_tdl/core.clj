(ns tp-clojure-tdl.core
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as string])
)

(defn validate_extension_file [name_file]
    ( let  [extension_file 
      (second (re-find #"(\.[a-zA-Z0-9]+)$" name_file))]
     ( if (= ".json" extension_file)
      true
      false
    )))

(defn is_empty_name [doc]
  ( if (not-empty doc)
    true
    false
  )
)

(defn file_exists [name_file]
  (if (= true (.exists (io/file name_file)) ) true false)
)

(def line (atom {:value "s[]"}))

(defn remove_character_ [a b c] 
  (swap! c assoc :value (string/replace (@c :value) a b)))
   
(defn remove_character
  "array_of_character_to_remove:Vector{:character character :newCharacter newCharacter} 
   atom_string:{:value value}"
  [array_of_character_to_remove atom_string]
  (doseq [res array_of_character_to_remove]
    (remove_character_ (get res :character) 
                       (get res :newCharacter) atom_string)))

(def vector_array (vector 
         {:character "]" :newCharacter ""} 
         {:character "[" :newCharacter ""}))

(defn read_line [nameFile]
  (with-open [rdr (io/reader nameFile)]
    (doseq [line_ (line-seq rdr)]
      (swap! line assoc :value line_)
      (remove_character vector_array line)
      (println (string/split (get @line :value) #" "))
    )
  )
)

(defn init_service [] 
  
    ( loop []
        (println "Ingrese la ruta del Archivo:")
        (let [document (read-line) validate (is_empty_name document)] 
            (if (true? (and validate (file_exists document)))
              (read_line document)
              (do (println "Ruta invalida") (recur))
            )
        )
    )
  
)

(defn reemplazar-en-cadena [cadena a-reemplazar reemplazo]
  (clojure.string/replace cadena
                          (re-pattern (if (< 1 (count a-reemplazar))
                                        a-reemplazar
                                        (str "[" a-reemplazar "]")
                                        ))
                          reemplazo))

(defn -main
  [& args]
  (init_service)
)
;;/home/rogger/Documents/tp_clojure_tdl/doc/prueba.txt