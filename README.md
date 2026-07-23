# cloud-itonami-iso3166-qat

**`:implemented`** for **QAT**. Flagship `qa-entity-missing`, tax `cr-unverified`.

```
clojure -M:dev:test
```

## Market-entry / statute catalogs

- Ministry of Finance / Government Procurement Portal (Monaqasat,
  monaqasat.mof.gov.qa) -- Qatar's unified e-tendering and procurement
  platform. Legal basis: Regulation of Tenders and Auctions Law, Law
  No. (24) of 2015 (confirmed directly via almeezan.qa, Qatar's
  official Ministry of Justice legislation portal).
- Commercial registration: Commercial Registration (CR) via the
  Ministry of Commerce and Industry (MOCI) / General Tax Authority
  (GTA), moci.gov.qa. Legal basis: Commercial Companies Law, Law No.
  (11) of 2015.
- Data protection: Law on Protecting Personal Data Privacy, Law No.
  (13) of 2016 -- widely reported as the first comprehensive
  data-protection law enacted in the GCC region (that superlative was
  not independently re-verified this session; see
  `src/statute/facts.cljc` for the disclosed caveat).
- Labor: Labour Law, Law No. (14) of 2004.

Every citation above was fetched and read directly this session (see
`src/marketentry/facts.cljc` and `src/statute/facts.cljc` docstrings
for exact URLs and verbatim confirmation). almeezan.qa presented no
bot-detection challenge -- every fetch is a direct primary-source read,
not a Wayback Machine fallback. The Tenders and Auctions Law entry in
`statute.facts` extends (never contradicts) this repo's own
pre-existing `marketentry.facts` citation for the same law. Gaps that
could not be independently confirmed this session (a complete
amendment history beyond the specific amending laws named, and the
Personal Data Privacy Protection Law's "first in the GCC" claim) are
disclosed in `src/statute/facts.cljc`, not filled in with an invented
figure.

AGPL-3.0-or-later.

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for Qatar:

- `src/culture/facts.cljc` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.

AGPL-3.0-or-later.
