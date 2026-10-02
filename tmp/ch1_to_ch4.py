# -*- coding: utf-8 -*-

def add_ch1_to_ch4(add_q):
    # ==========================================
    # CHAPTER 1: Chemical Reactions and Equations (30)
    # ==========================================
    # PRACTICE (6)
    add_q("C1_P_1", 1, "Chemical Reactions and Equations", "Thermal Decomposition", "PRACTICE", "MCQ",
          "When solid lead nitrate is heated strongly in a dry test tube, brown fumes of a gas are evolved along with a yellow residue. Identify the gas and residue.",
          ["NO2 and PbO", "NO and PbO2", "N2O and Pb3O4", "O2 and Pb"], 0,
          "2Pb(NO3)2(s) -> 2PbO(s) [yellow residue] + 4NO2(g) [brown fumes] + O2(g).", 1, "Medium", "Observation & Recall")
    add_q("C1_P_2", 1, "Chemical Reactions and Equations", "Combination Reactions", "PRACTICE", "MCQ",
          "Quicklime reacts vigorously with water to produce slaked lime with release of high heat. This reaction is:",
          ["Combination and Endothermic", "Combination and Exothermic", "Decomposition and Exothermic", "Displacement and Endothermic"], 1,
          "CaO(s) + H2O(l) -> Ca(OH)2(aq) + Heat. Combination of two reactants releasing heat (Exothermic).", 1, "Easy", "Classification")
    add_q("C1_P_3", 1, "Chemical Reactions and Equations", "Balancing Equations", "PRACTICE", "MCQ",
          "What are the stoichiometric coefficients a, b, c, d to balance: a Fe + b H2O -> c Fe3O4 + d H2?",
          ["a=3, b=4, c=1, d=4", "a=1, b=2, c=1, d=2", "a=2, b=3, c=1, d=3", "a=3, b=2, c=1, d=2"], 0,
          "Balanced equation: 3Fe(s) + 4H2O(g) -> Fe3O4(s) + 4H2(g).", 1, "Medium", "Balancing Skill")
    add_q("C1_P_4", 1, "Chemical Reactions and Equations", "Precipitation Reactions", "PRACTICE", "MCQ",
          "Mixing aqueous solutions of sodium sulphate and barium chloride results in an insoluble white precipitate of:",
          ["Barium sulphate (BaSO4)", "Sodium chloride (NaCl)", "Barium sulphite (BaSO3)", "Sodium sulphate"], 0,
          "Na2SO4(aq) + BaCl2(aq) -> BaSO4(s) [white precipitate] + 2NaCl(aq).", 1, "Easy", "Precipitation Identification")
    add_q("C1_P_5", 1, "Chemical Reactions and Equations", "Photolytic Decomposition", "PRACTICE", "MCQ",
          "White silver chloride turns grey in sunlight. This photodecomposition is used in:",
          ["Black and white photography", "Bleaching cotton textiles", "Electroplating silver", "Water purification"], 0,
          "2AgCl(s) (in sunlight) -> 2Ag(s) [grey] + Cl2(g). Used in black and white photography.", 1, "Easy", "Practical Application")
    add_q("C1_P_6", 1, "Chemical Reactions and Equations", "Corrosion of Metals", "PRACTICE", "MCQ",
          "Rusting of iron requires the simultaneous presence of which two substances?",
          ["Moisture (water) and Oxygen (air)", "Only nitrogen gas", "Only carbon dioxide", "Dry oxygen without moisture"], 0,
          "Iron rusts to form hydrated iron(III) oxide (Fe2O3.xH2O) only in the presence of both moisture and oxygen.", 1, "Easy", "Environmental Chemistry")

    # TEST_1 (6)
    add_q("C1_T1_1", 1, "Chemical Reactions and Equations", "Redox Reactions", "TEST_1", "MCQ",
          "In the reaction CuO + H2 -> Cu + H2O, which substance undergoes reduction and which acts as reducing agent?",
          ["CuO is reduced; H2 is reducing agent", "H2 is reduced; CuO is reducing agent", "Cu is oxidized; H2O is reduced", "Both are oxidized"], 0,
          "CuO loses oxygen to form Cu (reduction). H2 gains oxygen to form H2O (oxidation). The oxidized substance H2 is the reducing agent.", 1, "Medium", "Redox Analysis")
    add_q("C1_T1_2", 1, "Chemical Reactions and Equations", "Rancidity Prevention", "TEST_1", "ASSERTION_REASON",
          "Assertion (A): Nitrogen gas is flushed into potato chips packets.\nReason (R): Nitrogen prevents oxidation and rancidity of oils and fats in chips.",
          ["Both A and R are true, and R is correct explanation of A", "Both A and R are true, but R is NOT correct explanation", "A is true but R is false", "A is false but R is true"], 0,
          "Nitrogen is an inert unreactive gas that displaces oxygen, preventing oily foods from turning rancid.", 1, "Medium", "Reasoning & Inquiry")
    add_q("C1_T1_3", 1, "Chemical Reactions and Equations", "Thermal Decomposition of Ferrous Sulphate", "TEST_1", "MCQ",
          "On heating green ferrous sulphate crystals (FeSO4.7H2O), gases with suffocating burning sulphur smell are evolved. These are:",
          ["SO2 and SO3", "SO2 only", "H2S and SO2", "CO2 and SO3"], 0,
          "2FeSO4(s) (heat) -> Fe2O3(s) + SO2(g) + SO3(g). Sulphur dioxide and sulphur trioxide cause the pungent smell.", 1, "Medium", "Laboratory Observation")
    add_q("C1_T1_4", 1, "Chemical Reactions and Equations", "Exothermic Respiration", "TEST_1", "MCQ",
          "Respiration is considered an exothermic process because:",
          ["Glucose combines with oxygen in cells releasing energy", "It absorbs heat from surroundings", "Carbon dioxide is absorbed by cells", "Water vapor condenses"], 0,
          "C6H12O6 + 6O2 -> 6CO2 + 6H2O + Energy (in form of ATP). Release of energy makes it exothermic.", 1, "Easy", "Biochemical Understanding")
    add_q("C1_T1_5", 1, "Chemical Reactions and Equations", "Displacement Reaction", "TEST_1", "MCQ",
          "When zinc granules are added to dilute sulphuric acid, a colourless odorless gas burns with a 'pop' sound. The gas is:",
          ["Hydrogen (H2)", "Oxygen (O2)", "Carbon dioxide (CO2)", "Sulphur dioxide (SO2)"], 0,
          "Zn(s) + H2SO4(aq) -> ZnSO4(aq) + H2(g). Hydrogen gas burns with a characteristic pop sound.", 1, "Easy", "Gas Identification")
    add_q("C1_T1_6", 1, "Chemical Reactions and Equations", "Corrosion Prevention", "TEST_1", "MCQ",
          "The method of protecting iron from rusting by coating it with a thin protective layer of zinc is called:",
          ["Galvanisation", "Alloying", "Anodising", "Tinning"], 0,
          "Galvanisation coats iron with sacrificial zinc which oxidises preferentially, shielding the iron substrate.", 1, "Easy", "Industrial Metallurgy")

    # TEST_2 (6)
    add_q("C1_T2_1", 1, "Chemical Reactions and Equations", "Displacement with Copper Sulphate", "TEST_2", "COMPETENCY_BASED",
          "An iron nail dipped in blue CuSO4 solution turns the solution pale green and coats the nail with a reddish-brown layer. The pale green colour is due to:",
          ["Formation of FeSO4 in solution", "Formation of CuCl2", "Precipitation of copper oxide", "Oxidation of Fe to Fe2O3"], 0,
          "Fe(s) + CuSO4(aq)[blue] -> FeSO4(aq)[light green] + Cu(s)[red-brown coating]. Iron is more reactive than copper.", 1, "Medium", "Reactivity Application")
    add_q("C1_T2_2", 1, "Chemical Reactions and Equations", "Electrolysis of Water", "TEST_2", "COMPETENCY_BASED",
          "During electrolysis of acidified water, volume of gas collected at cathode is double that at anode because:",
          ["Water molecule contains hydrogen and oxygen in 2:1 ratio by volume", "Oxygen gas is heavier and dissolves completely", "Hydrogen is released at anode", "Current only acts on hydrogen"], 0,
          "2H2O(l) -> 2H2(g)[at cathode] + O2(g)[at anode]. Stoichiometric molar and volume ratio is 2:1.", 1, "Hard", "Quantitative Chemistry")
    add_q("C1_T2_3", 1, "Chemical Reactions and Equations", "Whitewashing Chemistry", "TEST_2", "COMPETENCY_BASED",
          "Walls whitewashed with slaked lime Ca(OH)2 develop a shiny white finish after 2 to 3 days due to formation of:",
          ["Calcium carbonate (CaCO3)", "Calcium oxide (CaO)", "Calcium hydrogencarbonate", "Calcium sulphate"], 0,
          "Ca(OH)2(aq) + CO2(g)[from air] -> CaCO3(s)[shiny limestone layer] + H2O(l).", 1, "Medium", "Real-world Phenomenon")
    add_q("C1_T2_4", 1, "Chemical Reactions and Equations", "Oxidizing Agent Identification", "TEST_2", "COMPETENCY_BASED",
          "In the reaction: MnO2 + 4HCl -> MnCl2 + 2H2O + Cl2, which substance is the oxidizing agent?",
          ["MnO2", "HCl", "MnCl2", "Cl2"], 0,
          "MnO2 supplies oxygen and removes electrons from Cl- (oxidising HCl to Cl2), while MnO2 is reduced to MnCl2.", 1, "Hard", "Electron Transfer Insight")
    add_q("C1_T2_5", 1, "Chemical Reactions and Equations", "Endothermic Reactions", "TEST_2", "COMPETENCY_BASED",
          "Which of the following processes is strictly endothermic in nature?",
          ["Decomposition of calcium carbonate into quicklime and CO2", "Burning of natural gas", "Dilution of sulphuric acid in water", "Neutralisation of acid with base"], 0,
          "Thermal decomposition of limestone: CaCO3(s) + Heat -> CaO(s) + CO2(g) requires continuous absorption of heat.", 1, "Medium", "Thermodynamics")
    add_q("C1_T2_6", 1, "Chemical Reactions and Equations", "Color of Silver Bromide", "TEST_2", "COMPETENCY_BASED",
          "Light yellow silver bromide crystals darken upon exposure to sunlight because of:",
          ["Formation of metallic silver by photolytic decomposition", "Absorption of moisture from atmosphere", "Oxidation of bromine gas", "Sublimation of silver salt"], 0,
          "2AgBr(s)[pale yellow] (sunlight) -> 2Ag(s)[grey] + Br2(g). Used extensively in photographic films.", 1, "Medium", "Observation Interpretation")

    # TEST_3 (6)
    add_q("C1_T3_1", 1, "Chemical Reactions and Equations", "Assertion-Reason on Corrosion", "TEST_3", "ASSERTION_REASON",
          "Assertion (A): Silver articles become black after some days when exposed to air.\nReason (R): Silver reacts with sulphur in the air to form a black coating of silver sulphide (Ag2S).",
          ["Both A and R are true, and R is correct explanation of A", "Both A and R are true, but R is NOT correct explanation", "A is true but R is false", "A is false but R is true"], 0,
          "2Ag(s) + H2S(g) -> Ag2S(s)[black] + H2(g). Hydrogen sulphide in air tarnishes silver.", 1, "Medium", "Board Pattern A/R")
    add_q("C1_T3_2", 1, "Chemical Reactions and Equations", "Corrosion of Copper", "TEST_3", "CASE_BASED",
          "A copper statue exposed to humid air for months develops a green coating. This green layer chemically consists of:",
          ["Basic copper carbonate [CuCO3.Cu(OH)2]", "Copper oxide [CuO]", "Copper sulphate [CuSO4]", "Copper chloride [CuCl2]"], 0,
          "Copper reacts with moist CO2 and O2 in air to form basic copper carbonate (CuCO3.Cu(OH)2), which is green.", 1, "Hard", "Corrosion Science")
    add_q("C1_T3_3", 1, "Chemical Reactions and Equations", "Precipitation Evaluation", "TEST_3", "CASE_BASED",
          "Which of the following statements is TRUE regarding all precipitation reactions?",
          ["They involve exchange of ions between reactants without change in oxidation states", "They are always redox reactions", "They always produce gaseous products", "They cannot occur in aqueous medium"], 0,
          "Double displacement precipitation involves exchange of cations and anions without changing valency/oxidation numbers.", 1, "Hard", "Theoretical Evaluation")
    add_q("C1_T3_4", 1, "Chemical Reactions and Equations", "Conservation of Mass", "TEST_3", "CASE_BASED",
          "Why is balancing a chemical equation strictly necessary according to the laws of chemistry?",
          ["To satisfy the Law of Conservation of Mass", "To make coefficients integers", "To indicate reaction rate", "To calculate temperature"], 0,
          "Atoms can neither be created nor destroyed in a chemical reaction; hence atom count for each element must balance.", 1, "Medium", "Fundamental Principle")
    add_q("C1_T3_5", 1, "Chemical Reactions and Equations", "Decomposition Classification", "TEST_3", "CASE_BASED",
          "Which of the following is an example of an electrolytic decomposition reaction?",
          ["Electrolysis of molten sodium chloride to produce sodium metal and chlorine gas", "Heating ferrous sulphate crystals", "Decomposition of silver chloride by sunlight", "Heating lead nitrate"], 0,
          "Passing electric current through molten NaCl decomposes it: 2NaCl(l) -> 2Na(s) + Cl2(g).", 1, "Medium", "Reaction Categorisation")
    add_q("C1_T3_6", 1, "Chemical Reactions and Equations", "Oxidation in Daily Life", "TEST_3", "CASE_BASED",
          "Fats and oils contain unsaturated bonds that when oxidized by atmospheric air produce foul odor and bad taste. The chemical process is called:",
          ["Rancidity", "Saponification", "Fermentation", "Calcination"], 0,
          "Oxidation of unsaturated fatty acids produces volatile foul-smelling aldehydes and ketones (rancidity).", 1, "Easy", "Daily Chemistry")

    # REVISION (6)
    add_q("C1_REV_1", 1, "Chemical Reactions and Equations", "Quick Recall - Combustion", "REVISION", "MCQ",
          "Combustion of methane gas (CH4 + 2O2 -> CO2 + 2H2O + heat) is an example of:",
          ["Exothermic combination/redox reaction", "Endothermic reaction", "Precipitation reaction", "Photochemical decomposition"], 0,
          "Combustion oxidizes hydrocarbon releasing significant thermal energy, making it exothermic.", 1, "Easy", "Rapid Recall")
    add_q("C1_REV_2", 1, "Chemical Reactions and Equations", "Quick Recall - Catalyst", "REVISION", "MCQ",
          "In hydrogenation of vegetable oils into vanaspati ghee, which metal is commonly used as a catalyst?",
          ["Nickel (Ni) or Palladium (Pd)", "Copper (Cu)", "Aluminium (Al)", "Gold (Au)"], 0,
          "Nickel catalyst facilitates addition of H2 across carbon-carbon double bonds.", 1, "Easy", "Rapid Recall")
    add_q("C1_REV_3", 1, "Chemical Reactions and Equations", "Quick Recall - Lime Water Test", "REVISION", "MCQ",
          "When CO2 gas is passed through clear lime water for a short time, it turns milky due to:",
          ["Insoluble calcium carbonate (CaCO3)", "Soluble calcium hydrogencarbonate", "Calcium oxide precipitate", "Calcium hydroxide"], 0,
          "Ca(OH)2 + CO2 -> CaCO3(s) [white insoluble suspension] + H2O.", 1, "Easy", "Gas Test Recall")
    add_q("C1_REV_4", 1, "Chemical Reactions and Equations", "Quick Recall - Excess CO2 in Lime Water", "REVISION", "MCQ",
          "When excess CO2 is passed into milky lime water, the milkiness disappears because of formation of:",
          ["Soluble calcium hydrogencarbonate [Ca(HCO3)2]", "Calcium chloride", "Calcium metal", "Calcium sulphate"], 0,
          "CaCO3 + H2O + CO2 -> Ca(HCO3)2(aq) which is clear and water-soluble.", 1, "Medium", "Reaction Sequence")
    add_q("C1_REV_5", 1, "Chemical Reactions and Equations", "Quick Recall - Magnesium Ribbon Burning", "REVISION", "MCQ",
          "Before burning magnesium ribbon in air, it is cleaned with sandpaper to remove a protective layer of:",
          ["Basic magnesium oxide / carbonate", "Magnesium chloride", "Magnesium sulphate", "Magnesium nitride"], 0,
          "Cleaning removes the passive oxide layer so the fresh metal ignites smoothly with a dazzling white flame.", 1, "Easy", "Lab Technique")
    add_q("C1_REV_6", 1, "Chemical Reactions and Equations", "Quick Recall - Antioxidants", "REVISION", "MCQ",
          "Substances added to fatty foods to retard oxidation and prevent rancidity are known as:",
          ["Antioxidants (e.g. BHA, BHT, Vitamin E)", "Preservative salts", "Bleaching agents", "Emulsifiers"], 0,
          "Antioxidants preferentially react with free radicals and oxygen, preserving food freshness.", 1, "Easy", "Vocabulary")

    # ==========================================
    # CHAPTER 2: Acids, Bases and Salts (30)
    # ==========================================
    # PRACTICE (6)
    add_q("C2_P_1", 2, "Acids, Bases and Salts", "Tooth Decay pH", "PRACTICE", "MCQ",
          "Tooth enamel made of calcium hydroxyapatite begins to decay when the pH of mouth falls below:",
          ["5.5", "6.8", "7.4", "8.0"], 0,
          "Mouth bacteria degrade sugar into acids; when pH drops below 5.5, tooth enamel dissolves.", 1, "Easy", "Everyday Chemistry")
    add_q("C2_P_2", 2, "Acids, Bases and Salts", "Water of Crystallization", "PRACTICE", "MCQ",
          "Which of the following salts does NOT contain water of crystallization in its formula?",
          ["Baking Soda (NaHCO3)", "Washing Soda (Na2CO3.10H2O)", "Gypsum (CaSO4.2H2O)", "Blue Vitriol (CuSO4.5H2O)"], 0,
          "Baking soda is anhydrous sodium hydrogen carbonate (NaHCO3) with no water of crystallization.", 1, "Medium", "Formula Recognition")
    add_q("C2_P_3", 2, "Acids, Bases and Salts", "Plaster of Paris", "PRACTICE", "MCQ",
          "On heating gypsum at 373 K (100°C), it loses water molecules and forms Plaster of Paris with formula:",
          ["CaSO4.1/2H2O", "CaSO4.2H2O", "CaSO4.5H2O", "CaO"], 0,
          "CaSO4.2H2O (gypsum) -(heat at 373 K)-> CaSO4.1/2H2O (calcium sulphate hemihydrate) + 1.5 H2O.", 1, "Medium", "Chemical Reaction")
    add_q("C2_P_4", 2, "Acids, Bases and Salts", "Chlor-Alkali Products", "PRACTICE", "MCQ",
          "During the electrolysis of brine (concentrated NaCl solution), the gas liberated at the anode is:",
          ["Chlorine (Cl2)", "Hydrogen (H2)", "Oxygen (O2)", "Nitrogen (N2)"], 0,
          "At anode: 2Cl- -> Cl2 + 2e- (oxidation). At cathode: 2H+ + 2e- -> H2 (reduction). NaOH remains in solution.", 1, "Medium", "Industrial Chemistry")
    add_q("C2_P_5", 2, "Acids, Bases and Salts", "Baking Powder Components", "PRACTICE", "MCQ",
          "Baking powder used in cakes is a mixture of baking soda (NaHCO3) and which mild edible acid?",
          ["Tartaric acid", "Hydrochloric acid", "Acetic acid", "Sulphuric acid"], 0,
          "Tartaric acid neutralizes Na2CO3 formed during baking, preventing a bitter taste.", 1, "Easy", "Practical Application")
    add_q("C2_P_6", 2, "Acids, Bases and Salts", "Bleaching Powder Formula", "PRACTICE", "MCQ",
          "Bleaching powder produced by action of chlorine on dry slaked lime Ca(OH)2 has chemical formula:",
          ["CaOCl2", "CaCl2", "Ca(ClO3)2", "CaCO3"], 0,
          "Ca(OH)2 + Cl2 -> CaOCl2 (calcium oxychloride) + H2O.", 1, "Easy", "Formula Recall")

    # TEST_1 (6)
    add_q("C2_T1_1", 2, "Acids, Bases and Salts", "Olfactory Indicators", "TEST_1", "MCQ",
          "Which of the following substances can act as an olfactory indicator for visually impaired students?",
          ["Vanilla essence or clove oil", "Blue litmus paper", "Phenolphthalein solution", "Turmeric paper"], 0,
          "Vanilla, onion, and clove oil change odor in basic solutions, making them olfactory indicators.", 1, "Medium", "Indicator Science")
    add_q("C2_T1_2", 2, "Acids, Bases and Salts", "Acid-Metal Reaction", "TEST_1", "MCQ",
          "When zinc metal reacts with sodium hydroxide (NaOH) solution, the salt formed is:",
          ["Sodium zincate (Na2ZnO2)", "Zinc chloride", "Sodium oxide", "Zinc hydroxide"], 0,
          "Zn(s) + 2NaOH(aq) -> Na2ZnO2(aq) [sodium zincate] + H2(g). Amphoteric metal reacting with strong base.", 1, "Medium", "Inorganic Reaction")
    add_q("C2_T1_3", 2, "Acids, Bases and Salts", "pH Scale Range", "TEST_1", "MCQ",
          "A solution turns red litmus blue. Its pH is likely to be:",
          ["10", "1", "4", "5"], 0,
          "Bases turn red litmus blue; bases have pH greater than 7.", 1, "Easy", "Acid-Base Basics")
    add_q("C2_T1_4", 2, "Acids, Bases and Salts", "Sting Neutralisation", "TEST_1", "MCQ",
          "Nettle leaf sting injects which acid causing burning pain, and is traditionally relieved by rubbing dock plant leaves?",
          ["Methanoic acid (Formic acid)", "Oxalic acid", "Citric acid", "Lactic acid"], 0,
          "Nettle hair injects methanoic acid (HCOOH). Dock plant leaves contain mild basic sap that neutralizes it.", 1, "Medium", "Natural Remedies")
    add_q("C2_T1_5", 2, "Acids, Bases and Salts", "Washing Soda Preparation", "TEST_1", "MCQ",
          "Washing soda (Na2CO3.10H2O) is obtained by recrystallization of sodium carbonate obtained from heating:",
          ["Baking soda (NaHCO3)", "Sodium hydroxide", "Bleaching powder", "Gypsum"], 0,
          "2NaHCO3 -(heat)-> Na2CO3 + H2O + CO2. Recrystallization yields Na2CO3.10H2O.", 1, "Medium", "Preparation Method")
    add_q("C2_T1_6", 2, "Acids, Bases and Salts", "Acid Dilution Safety", "TEST_1", "MCQ",
          "While diluting concentrated sulphuric acid, why must acid always be added slowly to water with constant stirring?",
          ["The process is highly exothermic; adding water to acid can cause sudden boiling and splashing of hot acid", "Water dissolves faster in acid", "To prevent acid from cooling too fast", "To evaporate excess water"], 0,
          "Hydration of conc. H2SO4 generates immense heat; adding acid to bulk water dissipates heat safely.", 1, "Easy", "Lab Safety")

    # TEST_2 (6)
    add_q("C2_T2_1", 2, "Acids, Bases and Salts", "Universal Indicator", "TEST_2", "COMPETENCY_BASED",
          "Solutions A, B, C, D have pH 2, 7, 9, 12 respectively. Which solution has the highest concentration of H+ ions?",
          ["Solution A (pH 2)", "Solution B (pH 7)", "Solution C (pH 9)", "Solution D (pH 12)"], 0,
          "Lower pH corresponds to higher [H+] ion concentration. pH 2 has 10^-2 M H+, highest among all.", 1, "Medium", "pH Interpretation")
    add_q("C2_T2_2", 2, "Acids, Bases and Salts", "Antacid Chemistry", "TEST_2", "COMPETENCY_BASED",
          "During indigestion due to hyperacidity in stomach, which mild base is medically recommended as an antacid?",
          ["Milk of Magnesia [Mg(OH)2] or Baking Soda", "Caustic soda (NaOH)", "Calcium oxide (CaO)", "Potassium hydroxide (KOH)"], 0,
          "Magnesium hydroxide Mg(OH)2 is a mild non-corrosive base that safely neutralizes excess stomach HCl.", 1, "Medium", "Medical Application")
    add_q("C2_T2_3", 2, "Acids, Bases and Salts", "Dry HCl Gas Test", "TEST_2", "COMPETENCY_BASED",
          "Dry HCl gas does not change the colour of dry blue litmus paper, but moist blue litmus turns red. Why?",
          ["Acids furnish H+ (or H3O+) ions only in the presence of water to exhibit acidic properties", "Dry paper absorbs gas", "Litmus requires nitrogen to change color", "HCl gas decomposes in light"], 0,
          "HCl + H2O -> H3O+ + Cl-. Hydrogen ions cannot exist without water molecules forming hydronium ions.", 1, "Hard", "Ionisation Concept")
    add_q("C2_T2_4", 2, "Acids, Bases and Salts", "Salt Hydrolysis", "TEST_2", "COMPETENCY_BASED",
          "An aqueous solution of ammonium chloride (NH4Cl) is acidic (pH < 7) because it is a salt of:",
          ["Strong acid (HCl) and Weak base (NH4OH)", "Weak acid and Strong base", "Strong acid and Strong base", "Weak acid and Weak base"], 0,
          "NH4Cl hydrolyses to produce strong HCl and weak NH4OH, resulting in excess H+ ions.", 1, "Hard", "Salt Hydrolysis")
    add_q("C2_T2_5", 2, "Acids, Bases and Salts", "Gypsum and Fireproofing", "TEST_2", "COMPETENCY_BASED",
          "Plaster of Paris must be stored in moisture-proof containers because:",
          ["It absorbs atmospheric moisture to set into hard rock-like gypsum, losing its plastic properties", "It decomposes into toxic gas", "It catches fire", "It sublimes into vapour"], 0,
          "CaSO4.1/2H2O + 1.5 H2O -> CaSO4.2H2O (hard solid mass). Must be sealed dry.", 1, "Medium", "Storage Chemistry")
    add_q("C2_T2_6", 2, "Acids, Bases and Salts", "Phenolphthalein and Methyl Orange", "TEST_2", "COMPETENCY_BASED",
          "What are the colours of phenolphthalein indicator in dilute HCl and dilute NaOH respectively?",
          ["Colourless in HCl; Pink in NaOH", "Pink in HCl; Colourless in NaOH", "Yellow in HCl; Red in NaOH", "Blue in HCl; Green in NaOH"], 0,
          "Phenolphthalein is colourless in acidic/neutral media and turns deep magenta pink in basic medium.", 1, "Medium", "Indicator Transitions")

    # TEST_3 (6)
    add_q("C2_T3_1", 2, "Acids, Bases and Salts", "Chlor-Alkali Assertion", "TEST_3", "ASSERTION_REASON",
          "Assertion (A): During electrolysis of brine, Cl2 gas is liberated at the anode and H2 at the cathode.\nReason (R): Cl- ions undergo oxidation at the anode and H+ ions undergo reduction at the cathode.",
          ["Both A and R are true, and R is correct explanation of A", "Both A and R are true, but R is NOT correct explanation", "A is true but R is false", "A is false but R is true"], 0,
          "2Cl- -> Cl2 + 2e- (anodic oxidation) and 2H+ + 2e- -> H2 (cathodic reduction).", 1, "Hard", "Electrochemical Logic")
    add_q("C2_T3_2", 2, "Acids, Bases and Salts", "Acid Rain Definition", "TEST_3", "CASE_BASED",
          "Rainwater is termed 'acid rain' when its pH value drops below:",
          ["5.6", "7.0", "6.5", "8.2"], 0,
          "Atmospheric SO2 and NO2 dissolve in raindrops forming H2SO4 and HNO3; pH < 5.6 qualifies as acid rain.", 1, "Medium", "Environmental Standard")
    add_q("C2_T3_3", 2, "Acids, Bases and Salts", "Soil pH Adjustment", "TEST_3", "CASE_BASED",
          "A farmer finds his field soil is too acidic for crop growth. To treat the soil, he should add:",
          ["Quicklime (CaO) or Slaked lime [Ca(OH)2] or Chalk (CaCO3)", "Sulphuric acid", "Common salt (NaCl)", "Gypsum"], 0,
          "Basic calcium compounds neutralize acidic soil to restore ideal pH for plant nutrient absorption.", 1, "Medium", "Agricultural Application")
    add_q("C2_T3_4", 2, "Acids, Bases and Salts", "Water of Crystallization Proof", "TEST_3", "CASE_BASED",
          "Blue vitriol crystals (CuSO4.5H2O) turn white when heated in a dry test tube because:",
          ["They lose water of crystallization becoming anhydrous CuSO4", "Copper decomposes into gas", "Sulphate evaporates", "Copper is reduced to metal"], 0,
          "CuSO4.5H2O [blue] -(heat)-> CuSO4 [white powder] + 5H2O. Adding water restores blue colour.", 1, "Medium", "Hydrate Science")
    add_q("C2_T3_5", 2, "Acids, Bases and Salts", "Bleaching Action Mechanism", "TEST_3", "CASE_BASED",
          "Bleaching powder acts as a disinfectant for drinking water primarily because of the release of:",
          ["Nascent chlorine / oxygen that kills bacteria and germs", "Calcium ions", "Carbon dioxide", "Sodium ions"], 0,
          "CaOCl2 + H2O -> Ca(OH)2 + Cl2. Chlorine is an effective germicide and oxidizing bleaching agent.", 1, "Medium", "Disinfection Chemistry")
    add_q("C2_T3_6", 2, "Acids, Bases and Salts", "Sodium Carbonate Uses", "TEST_3", "CASE_BASED",
          "Which of the following is NOT an industrial use of washing soda (Na2CO3.10H2O)?",
          ["As an electrolyte in lead storage car batteries", "In glass, soap, and paper industries", "For removing permanent hardness of water", "Manufacture of borax"], 0,
          "Car batteries use dilute sulphuric acid (H2SO4), not washing soda.", 1, "Hard", "Industrial Applications")

    # REVISION (6)
    add_q("C2_REV_1", 2, "Acids, Bases and Salts", "Natural Acid in Vinegar", "REVISION", "MCQ",
          "The natural acid present in commercial vinegar is:",
          ["Acetic acid (Ethanoic acid, CH3COOH)", "Citric acid", "Tartaric acid", "Oxalic acid"], 0,
          "Vinegar is a 5-8% aqueous solution of ethanoic acid.", 1, "Easy", "Rapid Recall")
    add_q("C2_REV_2", 2, "Acids, Bases and Salts", "Natural Acid in Tamarind", "REVISION", "MCQ",
          "Tamarind (imli) contains which natural organic acid?",
          ["Tartaric acid", "Lactic acid", "Methanoic acid", "Citric acid"], 0,
          "Tamarind is rich in tartaric acid.", 1, "Easy", "Rapid Recall")
    add_q("C2_REV_3", 2, "Acids, Bases and Salts", "Natural Acid in Curd", "REVISION", "MCQ",
          "Sour milk or curd contains which acid produced by Lactobacillus bacteria?",
          ["Lactic acid", "Citric acid", "Oxalic acid", "Formic acid"], 0,
          "Lactobacillus ferments lactose into lactic acid, causing curdling.", 1, "Easy", "Rapid Recall")
    add_q("C2_REV_4", 2, "Acids, Bases and Salts", "Tomato Acid", "REVISION", "MCQ",
          "Tomatoes contain which naturally occurring organic acid?",
          ["Oxalic acid", "Acetic acid", "Malic acid", "Tartaric acid"], 0,
          "Tomatoes contain oxalic acid and citric acid in significant amounts.", 1, "Easy", "Rapid Recall")
    add_q("C2_REV_5", 2, "Acids, Bases and Salts", "Alkali Definition", "REVISION", "MCQ",
          "An 'alkali' is specifically defined in chemistry as:",
          ["A base that is completely soluble in water (e.g. NaOH, KOH)", "Any acid with pH > 7", "An insoluble metallic oxide", "A neutral salt"], 0,
          "All alkalis are bases, but all bases are not alkalis; only water-soluble bases are alkalis.", 1, "Easy", "Core Definition")
    add_q("C2_REV_6", 2, "Acids, Bases and Salts", "Bee Sting Remedy", "REVISION", "MCQ",
          "A honeybee sting causes acute pain due to acidic venom. Immediate relief is obtained by applying:",
          ["A mild base such as baking soda paste (NaHCO3)", "Lemon juice", "Concentrated sulphuric acid", "Vinegar"], 0,
          "Baking soda neutralizes the acidic venom injected by the bee sting.", 1, "Easy", "First Aid Chemistry")

    # ==========================================
    # CHAPTER 3: Metals and Non-metals (30)
    # ==========================================
    # PRACTICE (6)
    add_q("C3_P_1", 3, "Metals and Non-metals", "Liquid Metal and Non-metal", "PRACTICE", "MCQ",
          "Which metal and non-metal exist as liquids at room temperature respectively?",
          ["Mercury (Hg) and Bromine (Br2)", "Gallium (Ga) and Iodine (I2)", "Sodium (Na) and Chlorine (Cl2)", "Lead (Pb) and Carbon (C)"], 0,
          "Mercury is the only liquid metal and bromine is the only liquid non-metal at standard conditions.", 1, "Easy", "Physical Properties")
    add_q("C3_P_2", 3, "Metals and Non-metals", "Amphoteric Oxides", "PRACTICE", "MCQ",
          "Which pair of metal oxides reacts with both acids and strong bases to yield salt and water?",
          ["Al2O3 and ZnO", "Na2O and K2O", "MgO and CaO", "CuO and Fe2O3"], 0,
          "Aluminium oxide (Al2O3) and zinc oxide (ZnO) exhibit both acidic and basic character (amphoteric).", 1, "Medium", "Chemical Properties")
    add_q("C3_P_3", 3, "Metals and Non-metals", "Thermite Process", "PRACTICE", "MCQ",
          "The thermite reaction used to weld railway tracks involves the reduction of iron(III) oxide by:",
          ["Aluminium powder", "Copper powder", "Carbon powder", "Sodium metal"], 0,
          "Fe2O3(s) + 2Al(s) -> 2Fe(l) + Al2O3(s) + Intense Heat. Molten iron joins fractured rails.", 1, "Hard", "Metallurgy")
    add_q("C3_P_4", 3, "Metals and Non-metals", "Ionic Compound Properties", "PRACTICE", "MCQ",
          "Solid sodium chloride (NaCl) does not conduct electricity, but molten NaCl conducts because:",
          ["Electrostatic forces are overcome in molten state allowing free ions to move", "Solid NaCl has no electrons", "Molten NaCl becomes covalent", "Water is absorbed"], 0,
          "Conduction requires mobile charge carriers; molten state frees Na+ and Cl- ions to migrate.", 1, "Medium", "Structure-Property")
    add_q("C3_P_5", 3, "Metals and Non-metals", "Lustrous Non-metal", "PRACTICE", "MCQ",
          "Although non-metals are generally non-lustrous, which non-metal possesses a lustrous metallic shine?",
          ["Iodine (I2)", "Sulphur (S8)", "Phosphorus (P4)", "Carbon (coal)"], 0,
          "Iodine crystals display a distinctive purple-metallic crystalline lustre.", 1, "Easy", "Exceptions in Properties")
    add_q("C3_P_6", 3, "Metals and Non-metals", "Storage in Kerosene", "PRACTICE", "MCQ",
          "Sodium and Potassium metals are stored immersed under kerosene oil because:",
          ["They react vigorously with moisture and oxygen in air catching fire", "They dissolve in air", "They evaporate readily", "To prevent them from turning brittle"], 0,
          "Alkali metals Na and K react violently with atmospheric air and moisture releasing combustible H2 gas.", 1, "Easy", "Reactivity Series")

    # TEST_1 (6)
    add_q("C3_T1_1", 3, "Metals and Non-metals", "Aqua Regia", "TEST_1", "MCQ",
          "Aqua regia, which can dissolve noble metals like gold and platinum, is a fresh mixture of conc. HCl and conc. HNO3 in the ratio:",
          ["3 : 1", "1 : 3", "2 : 1", "1 : 1"], 0,
          "Aqua regia (royal water) consists of 3 parts conc. HCl and 1 part conc. HNO3 by volume.", 1, "Medium", "Reagents")
    add_q("C3_T1_2", 3, "Metals and Non-metals", "Roasting vs Calcination", "TEST_1", "MCQ",
          "Heating a sulphide ore strongly in the presence of excess air to convert it into a metal oxide is known as:",
          ["Roasting", "Calcination", "Smelting", "Refining"], 0,
          "Roasting converts sulphide ores in excess air (e.g. 2ZnS + 3O2 -> 2ZnO + 2SO2). Calcination heats carbonate ores in limited air.", 1, "Medium", "Metallurgy Terminology")
    add_q("C3_T1_3", 3, "Metals and Non-metals", "Cinnabar Ore", "TEST_1", "MCQ",
          "Cinnabar is the natural sulphide ore of which metal?",
          ["Mercury (HgS)", "Copper (Cu2S)", "Zinc (ZnS)", "Lead (PbS)"], 0,
          "Cinnabar is mercuric sulphide (HgS). On heating in air it reduces to mercury metal.", 1, "Easy", "Ores of Metals")
    add_q("C3_T1_4", 3, "Metals and Non-metals", "Anodising of Aluminium", "TEST_1", "MCQ",
          "The industrial process of forming a thick protective oxide layer on aluminium using electrolysis is called:",
          ["Anodising", "Galvanising", "Alloying", "Electroplating"], 0,
          "Anodising thickens the natural Al2O3 layer, rendering aluminium corrosion-resistant and dye-receptive.", 1, "Easy", "Corrosion Prevention")
    add_q("C3_T1_5", 3, "Metals and Non-metals", "Metal Reacting with Steam", "TEST_1", "MCQ",
          "Which of the following metals does NOT react with cold water or hot water, but reacts only with steam to liberate hydrogen?",
          ["Iron (Fe)", "Sodium (Na)", "Calcium (Ca)", "Magnesium (Mg)"], 0,
          "3Fe(s) + 4H2O(g)[steam] -> Fe3O4(s) + 4H2(g). Sodium reacts violently with cold water, Mg with hot water.", 1, "Medium", "Reactivity Nuances")
    add_q("C3_T1_6", 3, "Metals and Non-metals", "Best and Poorest Conductors", "TEST_1", "MCQ",
          "The best conductor of electricity among metals and one of the poorest conductors are respectively:",
          ["Silver (Ag) and Lead (Pb)", "Copper (Cu) and Aluminium (Al)", "Gold (Au) and Iron (Fe)", "Iron (Fe) and Mercury (Hg)"], 0,
          "Silver has the highest electrical conductivity; lead and mercury are comparatively poor thermal and electrical conductors.", 1, "Easy", "Comparative Conductance")

    # TEST_2 (6)
    add_q("C3_T2_1", 3, "Metals and Non-metals", "Electrolytic Refining of Copper", "TEST_2", "COMPETENCY_BASED",
          "In the electrolytic refining of blister copper, what are used as the anode, cathode, and electrolyte?",
          ["Anode: Impure copper; Cathode: Pure copper strip; Electrolyte: Acidified CuSO4", "Anode: Pure copper; Cathode: Impure copper; Electrolyte: CuCl2", "Anode: Platinum; Cathode: Copper; Electrolyte: Water", "Anode: Graphite; Cathode: Zinc; Electrolyte: CuSO4"], 0,
          "Impure Cu dissolves at anode (oxidation); pure Cu plates onto cathode (reduction). Insoluble impurities settle as anode mud.", 1, "Hard", "Electrolytic Refining")
    add_q("C3_T2_2", 3, "Metals and Non-metals", "Alloy Composition - Brass and Bronze", "TEST_2", "COMPETENCY_BASED",
          "Brass is an alloy of ______ and Bronze is an alloy of ______ respectively.",
          ["Copper and Zinc; Copper and Tin", "Copper and Tin; Copper and Zinc", "Iron and Carbon; Lead and Tin", "Copper and Nickel; Aluminium and Copper"], 0,
          "Brass = Cu + Zn. Bronze = Cu + Sn. Solder = Pb + Sn.", 1, "Medium", "Alloy Formulation")
    add_q("C3_T2_3", 3, "Metals and Non-metals", "Non-metal Diamond Allotrope", "TEST_2", "COMPETENCY_BASED",
          "Diamond is an allotrope of carbon that is the hardest natural substance with very high melting point, but does not conduct electricity because:",
          ["All 4 valence electrons of each carbon are locked in rigid 3D covalent bonds with no free electrons", "It contains ionic bonds", "It is an amorphous form", "It dissolves in organic solvents"], 0,
          "In diamond, sp3 tetrahedrally bonded carbons leave zero free mobile electrons, unlike graphite which has delocalized pi electrons.", 1, "Medium", "Allotropes Insight")
    add_q("C3_T2_4", 3, "Metals and Non-metals", "Metal Nitric Acid Exception", "TEST_2", "COMPETENCY_BASED",
          "Metals typically do not produce H2 gas when reacting with HNO3 because nitric acid is a strong oxidizing agent that oxidizes H2 to H2O. However, which two metals react with very dilute HNO3 to liberate H2?",
          ["Magnesium (Mg) and Manganese (Mn)", "Copper (Cu) and Zinc (Zn)", "Iron (Fe) and Lead (Pb)", "Aluminium (Al) and Silver (Ag)"], 0,
          "Very dilute (1%) HNO3 reacts with Mg and Mn to evolve hydrogen gas: Mg + 2HNO3 -> Mg(NO3)2 + H2.", 1, "Hard", "Exceptions in Chemistry")
    add_q("C3_T2_5", 3, "Metals and Non-metals", "Low Melting Metals", "TEST_2", "COMPETENCY_BASED",
          "Which two metals have such low melting points that they melt when held on the palm of your hand?",
          ["Gallium (Ga) and Caesium (Cs)", "Sodium (Na) and Potassium (K)", "Tin (Sn) and Lead (Pb)", "Mercury (Hg) and Zinc (Zn)"], 0,
          "Gallium (m.p. 29.8°C) and Caesium (m.p. 28.4°C) melt at human body temperature (37°C).", 1, "Easy", "Physical Anomaly")
    add_q("C3_T2_6", 3, "Metals and Non-metals", "Corrosion of Iron in Salt Water", "TEST_2", "COMPETENCY_BASED",
          "Why do ships in marine ocean water suffer rusting much faster than iron bridges over freshwater rivers?",
          ["Salt water contains dissolved ions which increase the electrical conductivity of water, accelerating electrochemical rusting", "Ocean water has no oxygen", "Freshwater contains protective oils", "Salt acts as an antioxidant"], 0,
          "Electrolytes in saline seawater speed up galvanic cell reactions responsible for rust formation.", 1, "Medium", "Applied Electrochemistry")

    # TEST_3 (6)
    add_q("C3_T3_1", 3, "Metals and Non-metals", "Reactivity Series Order", "TEST_3", "CASE_BASED",
          "Which of the following represents the correct decreasing order of chemical reactivity of metals?",
          ["K > Na > Ca > Mg > Al > Zn > Fe > Pb > Cu", "Cu > Fe > Zn > Al > Mg > Ca > Na > K", "Na > K > Mg > Ca > Fe > Zn > Pb", "Al > Zn > Fe > K > Na > Ca"], 0,
          "Potassium is most reactive, followed by sodium, calcium, magnesium, aluminium, zinc, iron, lead, and copper.", 1, "Medium", "Reactivity Mastery")
    add_q("C3_T3_2", 3, "Metals and Non-metals", "Ionic Bond Formation", "TEST_3", "CASE_BASED",
          "In the formation of magnesium chloride (MgCl2), magnesium atom achieves stable octet by:",
          ["Losing 2 electrons to two chlorine atoms (forming Mg2+ and 2 Cl-)", "Sharing 2 pairs of electrons with chlorine", "Gaining 2 electrons from chlorine", "Forming coordinate covalent bonds"], 0,
          "Mg (2,8,2) transfers two valence electrons to two Cl (2,8,7) atoms, creating ionic MgCl2.", 1, "Medium", "Bond Mechanism")
    add_q("C3_T3_3", 3, "Metals and Non-metals", "Calcination Example", "TEST_3", "CASE_BASED",
          "Zinc carbonate (Calamine ore, ZnCO3) is converted to zinc oxide by which thermal process?",
          ["Calcination (heating strongly in absence/limited air)", "Roasting (heating in excess air)", "Electrolytic reduction", "Zone refining"], 0,
          "ZnCO3 -(calcination)-> ZnO + CO2(g). Carbonate ores are calcined to expel carbon dioxide.", 1, "Medium", "Ore Dressing")
    add_q("C3_T3_4", 3, "Metals and Non-metals", "Carbon Reduction Limits", "TEST_3", "CASE_BASED",
          "Why can carbon NOT be used to reduce oxides of sodium, magnesium, or aluminium to their respective metals?",
          ["These highly reactive metals have much greater affinity for oxygen than carbon does", "Carbon is too expensive", "Carbon forms toxic carbonates", "Oxides are gaseous"], 0,
          "Alkali and alkaline earth metals are strong reducing agents; their oxides require electrolytic reduction (e.g. Hall-Heroult for Al).", 1, "Hard", "Thermodynamic Affinity")
    add_q("C3_T3_5", 3, "Metals and Non-metals", "Amalgam Definition", "TEST_3", "CASE_BASED",
          "If one of the constituent metals in an alloy is mercury (Hg), the alloy is specifically termed an:",
          ["Amalgam", "Solder", "Bronze", "Brass"], 0,
          "An alloy containing mercury is known as an amalgam (e.g. silver-tin-mercury dental amalgam).", 1, "Easy", "Terminology")
    add_q("C3_T3_6", 3, "Metals and Non-metals", "24 Carat Gold Purity", "TEST_3", "CASE_BASED",
          "Pure 24 carat gold is not suitable for making jewellery because it is too soft. It is alloyed with 2 parts of copper or silver to make:",
          ["22 carat gold", "18 carat bronze", "White brass", "Rolled gold"], 0,
          "22 parts pure gold alloyed with 2 parts Cu/Ag hardens the metal for durable jewellery fabrication.", 1, "Easy", "Practical Metallurgy")

    # REVISION (6)
    add_q("C3_REV_1", 3, "Metals and Non-metals", "Malleability Definition", "REVISION", "MCQ",
          "The property of metals that allows them to be beaten into thin sheets without fracturing is:",
          ["Malleability", "Ductility", "Sonority", "Viscosity"], 0,
          "Gold and silver are the most malleable metals, hammered into paper-thin foils.", 1, "Easy", "Rapid Recall")
    add_q("C3_REV_2", 3, "Metals and Non-metals", "Ductility Definition", "REVISION", "MCQ",
          "The property of metals that allows them to be drawn into thin wires is known as:",
          ["Ductility", "Malleability", "Tensile brittleness", "Conductivity"], 0,
          "Gold is the most ductile metal: 1 gram of gold can be drawn into a wire of about 2 km length.", 1, "Easy", "Rapid Recall")
    add_q("C3_REV_3", 3, "Metals and Non-metals", "Graphite Conduction", "REVISION", "MCQ",
          "Graphite conducts electricity unlike other non-metals because:",
          ["Each carbon has one free delocalized valence electron in hexagonal layers", "It contains metallic impurities", "It has open pores for air", "It forms ionic bonds"], 0,
          "In graphite, each carbon atom bonds to 3 others, leaving the fourth electron free to conduct electricity.", 1, "Easy", "Rapid Recall")
    add_q("C3_REV_4", 3, "Metals and Non-metals", "Solder Alloy Use", "REVISION", "MCQ",
          "Solder alloy (Lead + Tin) has a low melting point and is universally used for:",
          ["Welding electrical wires together", "Making surgical blades", "Building aircraft frames", "Coating cookware"], 0,
          "Low melting point of Pb-Sn alloy allows clean joining of electrical connections without overheating components.", 1, "Easy", "Rapid Recall")
    add_q("C3_REV_5", 3, "Metals and Non-metals", "Stainless Steel Composition", "REVISION", "MCQ",
          "Stainless steel does not rust because iron is mixed with which elements?",
          ["Nickel and Chromium", "Copper and Tin", "Zinc and Lead", "Mercury and Silver"], 0,
          "Chromium forms a self-healing passive chromium oxide surface film preventing oxidation.", 1, "Easy", "Rapid Recall")
    add_q("C3_REV_6", 3, "Metals and Non-metals", "Gangue Definition", "REVISION", "MCQ",
          "The earthy and siliceous rocky impurities (sand, clay) present in naturally mined ores are called:",
          ["Gangue (or Matrix)", "Slag", "Flux", "Anode mud"], 0,
          "Gangue is removed during concentration of ore prior to metal extraction.", 1, "Easy", "Terminology")

    # ==========================================
    # CHAPTER 4: Carbon and its Compounds (30)
    # ==========================================
    # PRACTICE (6)
    add_q("C4_P_1", 4, "Carbon and its Compounds", "Covalent Nature of Carbon", "PRACTICE", "MCQ",
          "Carbon forms covalent compounds rather than forming C4+ or C4- ionic species because:",
          ["Gaining 4 electrons (C4-) is difficult for 6 protons, and losing 4 electrons (C4+) requires huge ionization energy", "Carbon is radioactive", "Carbon has 8 valence electrons", "Carbon is a noble gas"], 0,
          "Holding 10 electrons with 6 protons is unstable, and removing 4 electrons requires prohibitive energy; sharing electrons is energetically favourable.", 1, "Medium", "Core Electronic Theory")
    add_q("C4_P_2", 4, "Carbon and its Compounds", "Homologous Series Difference", "PRACTICE", "MCQ",
          "Any two successive members of a homologous series differ in their molecular formula and mass by:",
          ["-CH2- unit and 14 u", "-CH3- unit and 15 u", "-CH- unit and 13 u", "-C2H4- unit and 28 u"], 0,
          "Members differ by one carbon and two hydrogen atoms (12 + 2 = 14 atomic mass units).", 1, "Easy", "Series Fundamentals")
    add_q("C4_P_3", 4, "Carbon and its Compounds", "Butane Isomers", "PRACTICE", "MCQ",
          "How many structural isomers are possible for the saturated alkane Butane (C4H10)?",
          ["2 (n-butane and isobutane)", "3", "4", "5"], 0,
          "Butane has straight chain n-butane and branched isobutane (2-methylpropane).", 1, "Medium", "Isomerism")
    add_q("C4_P_4", 4, "Carbon and its Compounds", "Soap Micelle Structure", "PRACTICE", "MCQ",
          "In a soap micelle in water, how are the ionic head and hydrocarbon tail oriented?",
          ["Hydrophobic hydrocarbon tail inwards towards oily dirt; hydrophilic ionic head outwards facing water", "Hydrophilic head inwards; hydrophobic tail outwards", "Both point towards water", "Both dissolve in oil"], 0,
          "Non-polar tail dissolves in oil droplet, while negatively charged carboxylate head interacts with water.", 1, "Medium", "Micelle Mechanics")
    add_q("C4_P_5", 4, "Carbon and its Compounds", "Esterification Reaction", "PRACTICE", "MCQ",
          "Ethanoic acid reacts with absolute ethanol in the presence of concentrated H2SO4 to form a sweet fruity-smelling compound named:",
          ["Ethyl ethanoate (an ester)", "Ethanal", "Sodium ethanoate", "Ethanoic anhydride"], 0,
          "CH3COOH + C2H5OH -(conc H2SO4)-> CH3COOC2H5 (ethyl ethanoate) + H2O. Used in perfumes and flavorings.", 1, "Medium", "Organic Synthesis")
    add_q("C4_P_6", 4, "Carbon and its Compounds", "Functional Group in Propanone", "PRACTICE", "MCQ",
          "The functional group present in acetone/propanone (CH3COCH3) is:",
          ["Ketone (>C=O)", "Aldehyde (-CHO)", "Carboxylic acid (-COOH)", "Alcohol (-OH)"], 0,
          "The carbonyl group >C=O is bonded to two alkyl groups in ketones.", 1, "Easy", "Functional Groups")

    # TEST_1 (6)
    add_q("C4_T1_1", 4, "Carbon and its Compounds", "Versatility - Catenation", "TEST_1", "MCQ",
          "Carbon exhibits unique property to form stable long chains, branched chains and rings by bonding with other carbon atoms. This property is:",
          ["Catenation", "Polymerisation", "Allotropy", "Isomerisation"], 0,
          "C-C single bond energy is high (strong and stable), giving carbon unique catenation capacity.", 1, "Easy", "Core Concept")
    add_q("C4_T1_2", 4, "Carbon and its Compounds", "Saturated vs Unsaturated Flame", "TEST_1", "MCQ",
          "When burnt in air, saturated hydrocarbons generally give a ______ flame, whereas unsaturated hydrocarbons give a ______ flame.",
          ["Clean blue non-sooty; Yellow sooty", "Yellow sooty; Clean blue", "Green flame; Red flame", "Colorless; Violet"], 0,
          "Unsaturated hydrocarbons have higher carbon percentage that does not burn completely in air, producing unburnt carbon soot.", 1, "Medium", "Combustion Observation")
    add_q("C4_T1_3", 4, "Carbon and its Compounds", "Oxidation of Ethanol", "TEST_1", "MCQ",
          "Ethanol is oxidised to ethanoic acid by warming with which alkaline/acidified oxidizing agent?",
          ["Alkaline KMnO4 or Acidified K2Cr2O7", "Nickel catalyst", "Dilute hydrochloric acid", "Sodium hydroxide"], 0,
          "CH3CH2OH + 2[O] -(alkaline KMnO4 + heat)-> CH3COOH + H2O.", 1, "Medium", "Oxidation Mechanism")
    add_q("C4_T1_4", 4, "Carbon and its Compounds", "Addition Reaction", "TEST_1", "MCQ",
          "Unsaturated hydrocarbons add hydrogen in the presence of nickel catalyst to give saturated hydrocarbons. This reaction is used industrially for:",
          ["Hydrogenation of vegetable oils into vanaspati ghee", "Making soap", "Distillation of petroleum", "Fermentation of sugar"], 0,
          "Vegetable oils contain unsaturated carbon chains that are liquid; hydrogenation solidifies them into vanaspati fats.", 1, "Easy", "Industrial Organic Chemistry")
    add_q("C4_T1_5", 4, "Carbon and its Compounds", "Reaction with Sodium Metal", "TEST_1", "MCQ",
          "When a small piece of sodium is dropped into ethanol, rapid effervescence of which gas is observed?",
          ["Hydrogen gas (burns with pop sound)", "Oxygen gas", "Carbon dioxide gas", "Ethane gas"], 0,
          "2C2H5OH + 2Na -> 2C2H5ONa (sodium ethoxide) + H2(g).", 1, "Medium", "Functional Identification")
    add_q("C4_T1_6", 4, "Carbon and its Compounds", "Saponification Reaction", "TEST_1", "MCQ",
          "Heating an ester with an alkali like sodium hydroxide (NaOH) yields alcohol and sodium salt of carboxylic acid. This reaction is:",
          ["Saponification (Soap preparation)", "Esterification", "Combustion", "Fermentation"], 0,
          "CH3COOC2H5 + NaOH -> CH3COONa (soap component) + C2H5OH. Reverse of esterification.", 1, "Easy", "Soap Chemistry")

    # TEST_2 (6)
    add_q("C4_T2_1", 4, "Carbon and its Compounds", "Hard Water Scum with Soap", "TEST_2", "COMPETENCY_BASED",
          "Soaps do not lather effectively in hard water and produce an insoluble sticky precipitate (scum). This scum is formed due to reaction of soap with:",
          ["Calcium (Ca2+) and Magnesium (Mg2+) ions in hard water", "Sodium ions", "Chlorine ions", "Dissolved oxygen"], 0,
          "2C17H35COONa + Ca2+ -> (C17H35COO)2Ca (insoluble calcium stearate scum) + 2Na+.", 1, "Medium", "Hard Water Chemistry")
    add_q("C4_T2_2", 4, "Carbon and its Compounds", "Detergents Advantage", "TEST_2", "COMPETENCY_BASED",
          "Synthetic detergents can lather easily even in hard water because their charged ends are sodium salts of sulphonic acids which:",
          ["Do not form insoluble precipitates with calcium and magnesium ions", "Absorb calcium permanently", "Decompose into gas", "Acidify the water"], 0,
          "Calcium and magnesium sulphonates remain completely water-soluble, preventing scum formation.", 1, "Medium", "Detergent Chemistry")
    add_q("C4_T2_3", 4, "Carbon and its Compounds", "Vinegar and Glacial Acetic Acid", "TEST_2", "COMPETENCY_BASED",
          "Pure ethanoic acid freezes into ice-like crystals at 290 K (17°C) in cold climates. For this reason, pure ethanoic acid is termed:",
          ["Glacial acetic acid", "Dry ice", "Formic acid", "Solid ether"], 0,
          "Freezing point of pure CH3COOH is 16.6°C (290 K), yielding glacier-like crystal sheets.", 1, "Easy", "Physical Characteristics")
    add_q("C4_T2_4", 4, "Carbon and its Compounds", "Distinguishing Ethanol and Ethanoic Acid", "TEST_2", "COMPETENCY_BASED",
          "Which reagent can be used to chemically distinguish between ethanol and ethanoic acid by observing brisk effervescence of CO2 gas?",
          ["Sodium hydrogen carbonate (NaHCO3)", "Blue litmus paper only", "Water", "Sodium chloride solution"], 0,
          "CH3COOH reacts with NaHCO3 to evolve CO2 gas with brisk effervescence; ethanol does not react with carbonates.", 1, "Hard", "Chemical Distinction")
    add_q("C4_T2_5", 4, "Carbon and its Compounds", "Electron Dot Structure of Nitrogen", "TEST_2", "COMPETENCY_BASED",
          "In a molecule of nitrogen gas (N2), how many electrons are shared between the two nitrogen atoms to achieve noble gas configuration?",
          ["6 electrons (3 pairs forming a triple covalent bond)", "2 electrons", "4 electrons", "8 electrons"], 0,
          "Nitrogen has 5 valence electrons and shares 3 electrons with another N atom, forming a N#N triple bond.", 1, "Medium", "Lewis Structure")
    add_q("C4_T2_6", 4, "Carbon and its Compounds", "Substitution Reaction of Methane", "TEST_2", "COMPETENCY_BASED",
          "Methane reacts with chlorine in the presence of sunlight via substitution reaction to replace hydrogen atoms one by one. The catalyst is:",
          ["Sunlight (UV light)", "Iron powder", "Nickel", "Platinum"], 0,
          "CH4 + Cl2 -(sunlight)-> CH3Cl + HCl. Photochemical initiation creates reactive chlorine free radicals.", 1, "Medium", "Reaction Mechanism")

    # TEST_3 (6)
    add_q("C4_T3_1", 4, "Carbon and its Compounds", "Covalent Compounds Low Melting Points", "TEST_3", "ASSERTION_REASON",
          "Assertion (A): Covalent compounds like methane and ethanol have low melting and boiling points.\nReason (R): The intermolecular forces between covalent molecules are relatively weak.",
          ["Both A and R are true, and R is correct explanation of A", "Both A and R are true, but R is NOT correct explanation", "A is true but R is false", "A is false but R is true"], 0,
          "While covalent bonds within molecules are strong, weak van der Waals forces between molecules break easily at low temperatures.", 1, "Medium", "Board Pattern A/R")
    add_q("C4_T3_2", 4, "Carbon and its Compounds", "Denatured Alcohol", "TEST_3", "CASE_BASED",
          "Commercial alcohol is rendered unfit for drinking by adding poisonous methanol, pyridine, and copper sulphate dye. This mixture is called:",
          ["Denatured alcohol (Methylated spirit)", "Absolute alcohol", "Rectified spirit", "Power alcohol"], 0,
          "Denaturing prevents misuse of untaxed industrial ethanol for liquor consumption.", 1, "Medium", "Social & Industrial Chemistry")
    add_q("C4_T3_3", 4, "Carbon and its Compounds", "Alkene and Alkyne General Formulas", "TEST_3", "CASE_BASED",
          "The general molecular formulas for Alkanes, Alkenes, and Alkynes are respectively:",
          ["CnH2n+2, CnH2n, and CnH2n-2", "CnH2n, CnH2n+2, and CnH2n-2", "CnH2n-2, CnH2n, and CnH2n+2", "CnH2n+1, CnH2n, and CnH2n-1"], 0,
          "Alkanes have single bonds (CnH2n+2), alkenes double bond (CnH2n), alkynes triple bond (CnH2n-2).", 1, "Medium", "Nomenclature Rules")
    add_q("C4_T3_4", 4, "Carbon and its Compounds", "Combustion Gas Products", "TEST_3", "CASE_BASED",
          "When a gas stove burns with a yellow flame and soots cooking vessels, it indicates that:",
          ["Air holes are blocked resulting in incomplete combustion due to insufficient oxygen", "Fuel is 100% pure", "Temperature is too high", "Water has mixed into fuel"], 0,
          "Insufficient oxygen causes incomplete combustion, producing yellow glowing carbon particles that soot pans.", 1, "Easy", "Daily Application")
    add_q("C4_T3_5", 4, "Carbon and its Compounds", "Functional Group in Ethanal", "TEST_3", "CASE_BASED",
          "What is the IUPAC name and functional group in CH3CHO?",
          ["Ethanal; Aldehyde (-CHO)", "Ethanol; Alcohol (-OH)", "Ethanoic acid; Carboxyl (-COOH)", "Ethyne; Alkyne"], 0,
          "CH3CHO is the 2-carbon aldehyde named ethanal (acetaldehyde).", 1, "Medium", "IUPAC Nomenclature")
    add_q("C4_T3_6", 4, "Carbon and its Compounds", "Decolourization of Bromine Water", "TEST_3", "CASE_BASED",
          "Which of the following compounds will decolourize red-brown bromine water, confirming presence of unsaturation?",
          ["Ethene (C2H4)", "Ethane (C2H6)", "Methane (CH4)", "Propane (C3H8)"], 0,
          "Alkenes and alkynes undergo addition with Br2 breaking double bonds and discharging bromine's brown colour.", 1, "Hard", "Unsaturation Test")

    # REVISION (6)
    add_q("C4_REV_1", 4, "Carbon and its Compounds", "Quick Recall - Methane Formula", "REVISION", "MCQ",
          "The simplest hydrocarbon and major component of CNG and biogas is:",
          ["Methane (CH4)", "Ethane (C2H6)", "Butane (C4H10)", "Propane (C3H8)"], 0,
          "Methane (CH4) forms over 75% of compressed natural gas and biogas.", 1, "Easy", "Rapid Recall")
    add_q("C4_REV_2", 4, "Carbon and its Compounds", "Quick Recall - Absolute Alcohol", "REVISION", "MCQ",
          "100% pure ethanol free from any trace of water is known as:",
          ["Absolute alcohol", "Rectified spirit (95.6%)", "Denatured spirit", "Power alcohol"], 0,
          "100% pure ethyl alcohol is termed absolute alcohol.", 1, "Easy", "Terminology")
    add_q("C4_REV_3", 4, "Carbon and its Compounds", "Quick Recall - Buckminsterfullerene", "REVISION", "MCQ",
          "Buckminsterfullerene is an allotrope of carbon consisting of how many carbon atoms arranged in a football cage shape?",
          ["60 carbon atoms (C60)", "40 carbon atoms", "80 carbon atoms", "100 carbon atoms"], 0,
          "C60 fullerene has 20 hexagons and 12 pentagons arranged like a geodesic dome/soccer ball.", 1, "Easy", "Allotropes")
    add_q("C4_REV_4", 4, "Carbon and its Compounds", "Quick Recall - Alcohol Functional Group", "REVISION", "MCQ",
          "The alcohol functional group is represented by the formula:",
          ["-OH (Hydroxyl group)", "-CHO", "-COOH", "-Cl"], 0,
          "-OH bonded to an sp3 alkyl carbon defines alcohols (e.g. methanol, ethanol).", 1, "Easy", "Functional Groups")
    add_q("C4_REV_5", 4, "Carbon and its Compounds", "Quick Recall - Saturated Hydrocarbon Definition", "REVISION", "MCQ",
          "Hydrocarbons in which all carbon atoms are linked only by single covalent bonds are termed:",
          ["Saturated hydrocarbons (Alkanes)", "Unsaturated hydrocarbons", "Aromatic compounds", "Cyclic alkynes"], 0,
          "Alkanes have maximum possible hydrogen atoms linked by single C-C bonds.", 1, "Easy", "Definitions")
    add_q("C4_REV_6", 4, "Carbon and its Compounds", "Quick Recall - Cyclohexane Formula", "REVISION", "MCQ",
          "The molecular formula of the saturated cyclic hydrocarbon cyclohexane is:",
          ["C6H12", "C6H14", "C6H6", "C6H10"], 0,
          "Ring closure removes two end hydrogens from hexane: formula is C6H12 (isomeric with hexene).", 1, "Medium", "Cycloalkanes")

    print("Chapters 1-4 added (120 questions).")
