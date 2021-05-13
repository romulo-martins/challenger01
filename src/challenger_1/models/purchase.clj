(ns challenger-1.models.purchase
  (:require [challenger-1.db :as c.db]
            [challenger-1.helpers.date-helper :as c.date]))

(defn all [] c.db/purchases)

(defn by-company
  [company]
  (filter #(= company (get % :company)) c.db/purchases))

(defn by-month
  ([date]
   (filter #(c.date/same-month? date (% :date)) c.db/purchases))
  ([date purchases]
   (filter #(c.date/same-month? date (% :date)) purchases)))

(defn by-customer
  ([customer-id]
   (filter #(= customer-id (% :customer-id)) c.db/purchases))
  ([customer-id purchases]
   (filter #(= customer-id (% :customer-id)) purchases)))