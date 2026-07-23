(ns statute.facts
  "General-law compliance catalog for Qatar (QAT) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation), sibling namespace to
  `marketentry.facts` / `culture.facts`.

  Every entry below was confirmed this session by directly fetching
  almeezan.qa (Qatar's official Ministry of Justice legal portal,
  https://almeezan.qa/) and reading each law's own page (title metadata,
  promulgation clause and/or English text). No bot-detection challenge or
  CAPTCHA was ever encountered on almeezan.qa this session -- every fetch
  below is a direct, unobstructed read of the primary source, not a
  Wayback Machine fallback:

    - Commercial Companies Law: Law No. (11) of 2015 Promulgating the
      Commercial Companies Law (قانون رقم (11) لسنة 2015 بإصدار قانون
      الشركات التجارية), confirmed via almeezan.qa's own page title
      metadata at https://almeezan.qa/LawPage.aspx?id=6656&language=ar
      (Official Gazette publication date 07/07/2015, per the page's own
      `lblojpubdate` field). This is the DIRECT successor law this
      catalog's `marketentry.facts` docstring already alludes to
      (\"Qatari commercial registration typically required for
      government awards\") -- the law's own promulgation clause
      confirms it supersedes the prior Commercial Companies Law issued
      by Law No. (5) of 2002. An English translation of this law's own
      page was \"in progress\" (Content Not Available) at fetch time;
      the Arabic original was read directly. Separately confirmed via
      almeezan.qa's own cross-reference chain: Law No. (8) of 2021
      (https://almeezan.qa/LawPage.aspx?id=8664&language=ar) amends
      certain provisions of this law -- its own promulgation clause
      names Law No. (11) of 2015 explicitly by number and title.
    - Labour Law: Law No. (14) of 2004 on the promulgation of Labour Law,
      confirmed directly in ENGLISH at
      https://almeezan.qa/LawPage.aspx?id=3961&language=en (Official
      Gazette publication date 06/07/2004). The law's own promulgation
      clause cites its predecessor, Labour Law No. 3 of 1962, and the
      then-current Commercial Companies Law (Law No. 5 of 2002, later
      itself superseded by Law No. 11/2015 above). Separately confirmed
      via almeezan.qa's own cross-reference chain: Law No. (3) of 2014
      (https://almeezan.qa/LawPage.aspx?id=6134&language=ar) amends
      certain provisions of this law -- its own promulgation clause
      names Law No. (14) of 2004 explicitly. Further amendments to this
      law almost certainly exist over its 20+-year life but were not
      separately fetched this session -- a disclosed gap, not a
      fabricated exhaustive amendment list.
    - Personal Data Privacy Protection Law: Law No. (13) of 2016 on
      Protecting Personal Data Privacy (قانون رقم (13) لسنة 2016 بشأن
      حماية خصوصية البيانات الشخصية), confirmed directly in ENGLISH via
      almeezan.qa's own hosted PDF at
      https://almeezan.qa/EnglishLaws//132016.pdf (whose own text opens
      'Law No. (13) of 2016 on Protecting Personal Data Privacy' and
      names the administering Ministry as the Ministry of Transport and
      Communications) -- the same PDF's own footnote cites Official
      Gazette Issue No. (15) of 2016; the page-level Official Gazette
      publication date, read separately from
      https://almeezan.qa/LawPage.aspx?id=7121&language=ar, is
      29/12/2016. This law is WIDELY reported in secondary commentary as
      the first comprehensive data-protection law enacted in the Gulf
      Cooperation Council region -- that superlative claim was NOT
      independently verified against every other GCC jurisdiction this
      session, so it is disclosed here as commonly-reported context, not
      asserted as a catalog fact.
    - Tenders and Auctions Law: Law No. (24) of 2015 on the Promulgation
      of the Regulation of Tenders and Auctions Law, confirmed directly
      in ENGLISH via almeezan.qa's own hosted PDF at
      https://almeezan.qa/EnglishLaws//242015.pdf (Official Gazette
      publication date 13/12/2015, read separately from
      https://almeezan.qa/LawPage.aspx?id=6812&language=ar) -- its own
      Article (2) text (as read) applies the attached Regulation of
      Tenders and Auctions Law to 'Ministries and other government
      bodies, public authorities and institutions', with named
      exclusions to the extent stipulated by their own governing
      instrument. This is the SAME 'Tenders and Auctions Law' this
      repo's OWN `marketentry.facts` already cites as
      `:legal-basis` (provenance `https://www.mof.gov.qa/`, the
      Ministry of Finance's e-procurement portal) -- this entry does
      not contradict or duplicate that citation, it extends it with the
      law's own official number/date/text, confirmed via a second,
      independent official source (the legislation portal, as opposed
      to the procurement-portal citation `marketentry.facts` already
      carries). The law's own promulgation clause confirms it
      supersedes the prior Law Regulating Tenders and Auctions, Law No.
      (26) of 2005. Separately confirmed via almeezan.qa's own
      cross-reference chain: Decree-Law No. (18) of 2018 and Law No.
      (17) of 2024 (https://almeezan.qa/LawPage.aspx?id=9691&language=ar)
      each amend certain provisions of this law.

  Explicitly NOT asserted (disclosed gaps, not fabrications): the exact
  day/month the Emir signed each law (only each law's own Official
  Gazette PUBLICATION date, as recorded on almeezan.qa's own page, is
  used below -- signature and publication dates are close but not
  necessarily identical, and only the latter was directly read this
  session); a complete amendment history for any of the four laws
  beyond the specific amending law(s) named above; and the Personal
  Data Privacy Protection Law's widely-reported 'first in the GCC'
  superlative (disclosed above as unverified commentary, not a catalog
  fact). Per this catalog family's own convention (see e.g.
  `cloud-itonami-iso3166-sau`/`-are` `statute.facts`), the promulgating
  Emir's personal name appears only in each law's own standard
  promulgation clause as read -- it is never persisted into this
  catalog's structured data.

  An entry not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "ISO3166 alpha-3 -> vector of statute entries."
  {"QAT"
   [{:statute/id "qat.law-11-2015-commercial-companies-law"
     :statute/title "Commercial Companies Law"
     :statute/jurisdiction "QAT"
     :statute/kind :law
     :statute/law-number "Law No. (11) of 2015, as amended by Law No. (8) of 2021"
     :statute/url "https://almeezan.qa/LawPage.aspx?id=6656&language=ar"
     :statute/url-provenance :almeezan-qa-official-legislation-portal
     :statute/enacted-date "2015-07-07"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "qat.law-14-2004-labour-law"
     :statute/title "Labour Law"
     :statute/jurisdiction "QAT"
     :statute/kind :law
     :statute/law-number "Law No. (14) of 2004, as amended by Law No. (3) of 2014"
     :statute/url "https://almeezan.qa/LawPage.aspx?id=3961&language=en"
     :statute/url-provenance :almeezan-qa-official-legislation-portal
     :statute/enacted-date "2004-07-06"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:labor}}
    {:statute/id "qat.law-13-2016-personal-data-privacy-protection-law"
     :statute/title "Law on Protecting Personal Data Privacy"
     :statute/jurisdiction "QAT"
     :statute/kind :law
     :statute/law-number "Law No. (13) of 2016"
     :statute/url "https://almeezan.qa/EnglishLaws//132016.pdf"
     :statute/url-provenance :almeezan-qa-official-legislation-portal
     :statute/enacted-date "2016-12-29"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:data-protection :privacy}}
    {:statute/id "qat.law-24-2015-tenders-and-auctions-law"
     :statute/title "Regulation of Tenders and Auctions Law"
     :statute/jurisdiction "QAT"
     :statute/kind :law
     :statute/law-number "Law No. (24) of 2015, as amended by Decree-Law No. (18) of 2018 and Law No. (17) of 2024"
     :statute/url "https://almeezan.qa/EnglishLaws//242015.pdf"
     :statute/url-provenance :almeezan-qa-official-legislation-portal
     :statute/enacted-date "2015-12-13"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:public-procurement :market-entry}}]})

(defn spec-basis [jurisdiction] (get catalog jurisdiction))

(defn coverage
  ([] (coverage (keys catalog)))
  ([jurisdictions]
   (let [have (filter catalog jurisdictions)
         missing (remove catalog jurisdictions)]
     {:requested (count jurisdictions)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-qat statute.facts (ADR-2607141700): "
                 (count (get catalog "QAT")) " Qatar entries seeded "
                 "with almeezan.qa (Qatar Ministry of Justice legal portal) "
                 "citations, fetched directly with no bot-detection "
                 "obstruction this session. Extend "
                 "`statute.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [jurisdiction topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis jurisdiction)))
