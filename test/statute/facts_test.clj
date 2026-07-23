(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest qat-has-spec-basis
  (let [sb (facts/spec-basis "QAT")]
    (is (= 4 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["QAT" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["qat.law-13-2016-personal-data-privacy-protection-law"]
         (mapv :statute/id (facts/by-topic "QAT" :privacy))))
  (is (= ["qat.law-14-2004-labour-law"]
         (mapv :statute/id (facts/by-topic "QAT" :labor))))
  (is (= ["qat.law-24-2015-tenders-and-auctions-law"]
         (mapv :statute/id (facts/by-topic "QAT" :public-procurement))))
  (is (= ["qat.law-11-2015-commercial-companies-law"]
         (mapv :statute/id (facts/by-topic "QAT" :corporate-governance))))
  (is (empty? (facts/by-topic "QAT" :tax)))
  (is (empty? (facts/by-topic "ATL" :privacy))))
