(require '[clojure.pprint :refer [pprint]])

(def ... nil)


(defn clean [x]
  (cond (map? x) (into (sorted-map) x)
        (list? x) (map clean x)
        (vector? x) (mapv clean x)
        :else x))

(defn show [x]
  (pprint (clean x)))
