(ns marketentry.facts "Qatar market-entry catalog.")
(def catalog
  {"QAT" {:name "Qatar"
          :owner-authority "Ministry of Finance / Government Procurement Portal"
          :legal-basis "Tenders and Auctions Law"
          :national-spec "e-procurement + commercial registration"
          :provenance "https://www.mof.gov.qa/"
          :required-evidence ["CR number record" "e-procurement registration record" "CR extract" "Authorized-representative record"]
          :rep-owner-authority "contracting authorities / MoF"
          :rep-legal-basis "Qatari commercial registration typically required for government awards"
          :rep-provenance "https://www.mof.gov.qa/"
          :corporate-number-owner-authority "MOCI / GTA"
          :corporate-number-legal-basis "Commercial Registration number"
          :corporate-number-provenance "https://www.moci.gov.qa/"}
   "USA" {:name "United States" :owner-authority "GSA/SAM.gov" :legal-basis "FAR" :national-spec "SAM.gov" :provenance "https://sam.gov/"
          :required-evidence ["EIN record" "SAM.gov registration record" "State business registration record" "SAM UEI verification record"]}
   "ARE" {:name "UAE" :owner-authority "MoF e-procurement" :legal-basis "Federal procurement" :national-spec "e-procurement" :provenance "https://www.mof.gov.ae/"
          :required-evidence ["Trade license" "e-procurement registration" "DED extract" "Authorized-representative record"]}
   "SAU" {:name "Saudi Arabia" :owner-authority "Etimad" :legal-basis "GTPL" :national-spec "Etimad" :provenance "https://tenders.etimad.sa/"
          :required-evidence ["CR number" "Etimad registration" "CR extract" "Authorized-representative record"]}})

(defn spec-basis [iso3] (get catalog iso3))
(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note "R0 catalog seed"})))
(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))
(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))
(defn rep-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))
(defn corporate-number-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority :corporate-number-legal-basis :corporate-number-provenance]))))
