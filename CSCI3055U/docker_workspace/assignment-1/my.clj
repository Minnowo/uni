(def ... nil)
(def authors [{:id 100
               :name "Albert Einstein"
               :interest "Physics"}
              {:id 200
               :name "Alan Turing"
               :interest "Computer Science"}
              {:id 300
               :name "Jeff Dean"
               :interest "Programming"}])
(def articles [{:title "Intro to science"
                :authors [100 200]
                :likes 3}
               {:title "Programming machines"
                :authors [200 300]
                :likes 5}
               {:title "The digital age"
                :authors [300]
                :likes 6}
               {:title "Quantum computing"
                :authors [300 100]
                :likes 4}])