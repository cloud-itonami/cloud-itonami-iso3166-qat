(ns culture.facts
  "Country-level regional-culture catalog for Qatar (QAT) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms, including honestly stating shared/regional
  (GCC-wide, Gulf-wide) origins where the source says so. An item not in
  this table has NO spec-basis, full stop; extend `catalog`, do not
  invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"QAT"
   [{:culture/id "qat.dish.machbous"
     :culture/name "Machbous"
     :culture/country "QAT"
     :culture/kind :dish
     :culture/summary "Rice dish with meat, onions and tomatoes mixed with spices (traditionally the bizar spice mix), listed in the Qatari cuisine article; the dish (also spelled machboos/kabsa) is commonly regarded as a national dish across all Gulf Cooperation Council countries."
     :culture/url "https://en.wikipedia.org/wiki/Qatari_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "qat.dish.harees"
     :culture/name "Harees"
     :culture/country "QAT"
     :culture/kind :dish
     :culture/summary "Dish of ground wheat mixed with ghee, salt and water and prepared with chicken or meat; \"Harees dish: know-how, skills and practices\" is inscribed on UNESCO's Representative List of the Intangible Cultural Heritage of Humanity, with Qatar among the listed countries."
     :culture/url "https://en.wikipedia.org/wiki/Harees"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "qat.dish.luqaimat"
     :culture/name "Luqaimat"
     :culture/country "QAT"
     :culture/kind :dish
     :culture/summary "Leavened and deep-fried dough balls topped with honey or sweet syrup, listed as a dessert in the Qatari cuisine article."
     :culture/url "https://en.wikipedia.org/wiki/Qatari_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "qat.beverage.karak"
     :culture/name "Karak"
     :culture/country "QAT"
     :culture/kind :beverage
     :culture/summary "Tea simmered with spices, cardamom, saffron and sugar, combined with evaporated milk, listed as a beverage in the Qatari cuisine article."
     :culture/url "https://en.wikipedia.org/wiki/Qatari_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "qat.beverage.arabic-coffee"
     :culture/name "Arabic coffee"
     :culture/name-local "Gahwa"
     :culture/country "QAT"
     :culture/kind :beverage
     :culture/summary "Coffee brewed with cardamom, cloves and other traditional ingredients, listed as a beverage in the Qatari cuisine article; the Gulf-style qahwa khaleeji preparation is shared across the Arabian Peninsula."
     :culture/url "https://en.wikipedia.org/wiki/Qatari_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "qat.craft.al-sadu"
     :culture/name "Al Sadu"
     :culture/country "QAT"
     :culture/kind :craft
     :culture/summary "Traditional Bedouin weaving craft; Qatar was included in 2025 in UNESCO's Representative List of the Intangible Cultural Heritage of Humanity inscription for Al Sadu."
     :culture/url "https://en.wikipedia.org/wiki/Al_Sadu"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "qat.heritage.zubarah"
     :culture/name "Zubarah"
     :culture/name-local "Al Zubarah"
     :culture/country "QAT"
     :culture/kind :heritage
     :culture/summary "Archaeological site in Qatar, officially the Al Zubarah Archaeological Site, designated a UNESCO World Heritage Site in 2013."
     :culture/url "https://en.wikipedia.org/wiki/Zubarah"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-qat culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "QAT"))
                 " QAT entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
