# -*- coding: utf-8 -*-
import json

def get_questions():
    q_list = []
    
    # Helper to add question
    def add_q(qid, ch_id, ch_name, topic, test_type, q_type, q_text, options, correct_idx, expl, marks=1, diff="Medium", comp="Conceptual Understanding"):
        q_list.append({
            "questionId": qid,
            "chapterId": ch_id,
            "chapter": ch_name,
            "topic": topic,
            "testType": test_type,
            "questionType": q_type,
            "questionText": q_text,
            "options": options,
            "correctAnswer": correct_idx,
            "explanation": expl,
            "marks": marks,
            "difficulty": diff,
            "competency": comp
        })

    # =========================================================================
    # CHAPTER 1: Chemical Reactions and Equations (30 Questions)
    # =========================================================================
    # PRACTICE (6 Questions)
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

    # TEST_1 (6 Questions)
    add_q("C1_T1_1", 1, "Chemical Reactions and Equations", "Redox Reactions", "TEST_1", "MCQ",
          "In the reaction CuO + H2 -> Cu + H2O, which substance undergoes reduction and which acts as reducing agent?",
          ["CuO is reduced; H2 is reducing agent", "H2 is reduced; CuO is reducing agent", "Cu is oxidized; H2O is reduced", "Both are oxidized"], 0,
          "CuO loses oxygen to form Cu (reduction). H2 gains oxygen to form H2O (oxidation). The oxidized substance H2 is the reducing agent.", 1, "Medium", "Redox Analysis")

    add_q("C1_T1_2", 1, "Chemical Reactions and Equations", "Rancidity Prevention", "TEST_1", "ASSERTION_REASON",
          "Assertion (A): Nitrogen gas is flushed into potato chips packets.\\nReason (R): Nitrogen prevents oxidation and rancidity of oils and fats in chips.",
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

    # TEST_2 (6 Questions)
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

    # TEST_3 (6 Questions)
    add_q("C1_T3_1", 1, "Chemical Reactions and Equations", "Assertion-Reason on Corrosion", "TEST_3", "ASSERTION_REASON",
          "Assertion (A): Silver articles become black after some days when exposed to air.\\nReason (R): Silver reacts with sulphur in the air to form a black coating of silver sulphide (Ag2S).",
          ["Both A and R are true, and R is correct explanation of A", "Both A and R are true, but R is NOT correct explanation", "A is true but R is false", "A is false but R is true"], 0,
          "2Ag(s) + H2S(g) -> Ag2S(s)[black] + H2(g). Hydrogen sulphide in air tarnishes silver.", 1, "Medium", "Board Pattern A/R")

    add_q("C1_T3_2", 1, "Chemical Reactions and Equations", "Case Study on Corrosion of Copper", "TEST_3", "CASE_BASED",
          "A copper statue exposed to humid air for months develops a green coating. This green layer chemically consists of:",
          ["Basic copper carbonate [CuCO3.Cu(OH)2]", "Copper oxide [CuO]", "Copper sulphate [CuSO4]", "Copper chloride [CuCl2]"], 0,
          "Copper reacts with moist CO2 and O2 in air to form basic copper carbonate (CuCO3.Cu(OH)2), which is green.", 1, "Hard", "Corrosion Science")

    add_q("C1_T3_3", 1, "Chemical Reactions and Equations", "Double Displacement vs Redox", "TEST_3", "CASE_BASED",
          "Which of the following statements is TRUE regarding all precipitation reactions?",
          ["They involve exchange of ions between reactants without change in oxidation states", "They are always redox reactions", "They always produce gaseous products", "They cannot occur in aqueous medium"], 0,
          "Double displacement precipitation involves exchange of cations and anions without changing valency/oxidation numbers.", 1, "Hard", "Theoretical Evaluation")

    add_q("C1_T3_4", 1, "Chemical Reactions and Equations", "Law of Conservation of Mass", "TEST_3", "CASE_BASED",
          "Why is balancing a chemical equation strictly necessary according to the laws of chemistry?",
          ["To satisfy the Law of Conservation of Mass (total mass of reactants = total mass of products)", "To make coefficients integers", "To indicate reaction rate", "To calculate temperature"], 0,
          "Atoms can neither be created nor destroyed in a chemical reaction; hence atom count for each element must balance.", 1, "Medium", "Fundamental Principle")

    add_q("C1_T3_5", 1, "Chemical Reactions and Equations", "Decomposition Classification", "TEST_3", "CASE_BASED",
          "Which of the following is an example of an electrolytic decomposition reaction?",
          ["Electrolysis of molten sodium chloride to produce sodium metal and chlorine gas", "Heating ferrous sulphate crystals", "Decomposition of silver chloride by sunlight", "Heating lead nitrate"], 0,
          "Passing electric current through molten NaCl decomposes it: 2NaCl(l) -> 2Na(s) + Cl2(g).", 1, "Medium", "Reaction Categorisation")

    add_q("C1_T3_6", 1, "Chemical Reactions and Equations", "Oxidation in Daily Life", "TEST_3", "CASE_BASED",
          "Fats and oils contain unsaturated bonds that when oxidized by atmospheric air produce foul odor and bad taste. The chemical process is called:",
          ["Rancidity", "Saponification", "Fermentation", "Calcination"], 0,
          "Oxidation of unsaturated fatty acids produces volatile foul-smelling aldehydes and ketones (rancidity).", 1, "Easy", "Daily Chemistry")

    # REVISION (6 Questions)
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

    print("Chapter 1 completed: 30 questions.")
    return q_list

print("Script template ready.")
