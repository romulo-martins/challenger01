(ns challenger-clojure.db.seed
  (:use [clojure pprint])
  (:require [challenger-clojure.db.core :as db]
            [challenger-clojure.models.customer :as customer]))

(def customers
  [{:name "Júlia Rameira"     :cpf "642441182" :email "julia_rameira@gmail.com"}
   {:name "Arthur Henrique"   :cpf "999969705" :email "arthur_henri@outlook.com"}
   {:name "Amanda Assumpção"  :cpf "240568126" :email "amanda_assump@@hotmail.com"}
   {:name "Leonardo Nogueira" :cpf "336987973" :email "leo_nog@hotmail.com"}
   {:name "Gabriel Batista"   :cpf "814957331" :email "gab_batista@gmail.com"}])

; OBS: customer-id is the customer CPF
(def credit-cards
  [{:number "3528-3070-0184-0293" :cvv "418" :valid-date "2022-06-25" :limit 2000.00 :customer-id "642441182"}
   {:number "6574-2810-2736-4628" :cvv "580" :valid-date "2025-12-12" :limit 4000.00 :customer-id "999969705"}
   {:number "5869-6294-3469-8511" :cvv "112" :valid-date "2023-09-26" :limit 900.00  :customer-id "240568126"}
   {:number "6467-6824-2334-9677" :cvv "350" :valid-date "2024-10-08" :limit 2000.00 :customer-id "336987973"}
   {:number "5694-5858-6567-7730" :cvv "582" :valid-date "2024-10-24" :limit 5000.00 :customer-id "814957331"}])

; OBS: customer-id is the customer CPF
(def purchases
  [{:date "2020-04-21" :amount 320.90  :company "Lojas Americanas" :category "Home"        :customer-id "642441182"}
   {:date "2018-01-17" :amount 700.26  :company "Ri Happy"         :category "Toys"        :customer-id "642441182"}
   {:date "2021-03-20" :amount 781.12  :company "Leroy Merlin"     :category "Home"        :customer-id "642441182"}
   {:date "2021-03-14" :amount 3996.1  :company "Ri Happy"         :category "Toys"        :customer-id "642441182"}
   {:date "2018-08-18" :amount 117.37  :company "Dominos"          :category "Food"        :customer-id "999969705"}
   {:date "2020-01-20" :amount 2300.90 :company "Casas Bahia"      :category "Electronics" :customer-id "999969705"}
   {:date "2016-07-03" :amount 747.73  :company "Natura"           :category "Beauty"      :customer-id "240568126"}
   {:date "2019-11-12" :amount 323.2   :company "Amazon"           :category "Books"       :customer-id "336987973"}
   {:date "2016-08-02" :amount 752.99  :company "Ponto Frio"       :category "Electronics" :customer-id "336987973"}
   {:date "2020-08-11" :amount 48.41   :company "Burguer King"     :category "Food"        :customer-id "814957331"}
   {:date "2017-09-06" :amount 67.4    :company "McDonalds"        :category "Food"        :customer-id "814957331"}
   {:date "2020-04-20" :amount 1297.58 :company "Leroy Merlin"     :category "Home"        :customer-id "814957331"}])

; Running
(defn run
  [conn]

  (println "Seeding database with customers ...")
  (doseq [param customers]
    (let [customer (customer/new param)]
      (db/insert-data conn [customer])))

  (println "Successful seeding!"))
