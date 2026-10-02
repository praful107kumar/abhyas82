# -*- coding: utf-8 -*-
import json
import sys
import os

sys.path.append("tmp")
sys.path.append("/app/applet/tmp")
from ch1_to_ch4 import add_ch1_to_ch4
from ch5_to_ch8 import add_ch5_to_ch8
from ch9_to_ch13 import add_ch9_to_ch13

all_questions = []

def add_q(qid, ch_id, ch_name, topic, test_type, q_type, q_text, options, correct_idx, expl, marks=1, diff="Medium", comp="Conceptual Understanding"):
    all_questions.append({
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

print("Collecting questions...")
add_ch1_to_ch4(add_q)
add_ch5_to_ch8(add_q)
add_ch9_to_ch13(add_q)

# Add 10 Grand Mock Questions covering all areas
mock_questions = [
    ("MOCK_1", 1, "Chemical Reactions and Equations", "Comprehensive Redox", "FULL_MOCK", "MCQ",
     "Identify the oxidized and reduced substances in: MnO2 + 4HCl -> MnCl2 + 2H2O + Cl2",
     ["HCl is oxidized to Cl2; MnO2 is reduced to MnCl2", "MnO2 is oxidized; HCl is reduced", "Both are oxidized", "H2O is oxidized"],
     0, "HCl loses hydrogen and electrons (oxidation); MnO2 loses oxygen (reduction).", 1, "Medium", "Board Pattern"),
    ("MOCK_2", 2, "Acids, Bases and Salts", "pH and Salt Analysis", "FULL_MOCK", "MCQ",
     "Which of the following salts gives an aqueous solution with pH > 7 (basic)?",
     ["Sodium acetate (CH3COONa)", "Ammonium chloride (NH4Cl)", "Sodium chloride (NaCl)", "Potassium sulphate (K2SO4)"],
     0, "Salt of weak acid (CH3COOH) and strong base (NaOH) hydrolyses to form basic solution (pH > 7).", 1, "Medium", "Salt Hydrolysis"),
    ("MOCK_3", 3, "Metals and Non-metals", "Reactivity and Extraction", "FULL_MOCK", "MCQ",
     "Which metal oxide can be reduced to metal by heating with carbon in a furnace?",
     ["Zinc oxide (ZnO + C -> Zn + CO)", "Aluminium oxide (Al2O3)", "Sodium oxide (Na2O)", "Magnesium oxide (MgO)"],
     0, "Zinc is in middle of reactivity series; its oxide is reduced by carbon/coke. High reactivity metals need electrolysis.", 1, "Medium", "Metallurgy"),
    ("MOCK_4", 4, "Carbon and its Compounds", "Covalent Isomerism", "FULL_MOCK", "MCQ",
     "How many covalent bonds are present in a molecule of ethane (C2H6)?",
     ["7 covalent bonds (6 C-H bonds + 1 C-C bond)", "6 covalent bonds", "8 covalent bonds", "9 covalent bonds"],
     0, "Ethane has one central C-C single bond and six surrounding C-H single bonds = 7 covalent bonds total.", 1, "Easy", "Structural Analysis"),
    ("MOCK_5", 5, "Life Processes", "Heart Circulation Pathway", "FULL_MOCK", "MCQ",
     "What is the correct pathway of oxygenated blood returning from the lungs to the body tissues?",
     ["Lungs -> Pulmonary veins -> Left atrium -> Left ventricle -> Systemic aorta -> Tissues", "Lungs -> Pulmonary artery -> Right atrium -> Tissues", "Lungs -> Vena cava -> Left atrium", "Lungs -> Right ventricle -> Aorta"],
     0, "Pulmonary veins carry oxygenated blood to left atrium -> left ventricle -> aorta to systemic tissues.", 1, "Medium", "Cardiovascular Cycle"),
    ("MOCK_6", 6, "Control and Coordination", "Nervous Coordination", "FULL_MOCK", "MCQ",
     "Which part of the human brain controls involuntary reflex coughing and sneezing?",
     ["Medulla oblongata", "Cerebellum", "Cerebrum", "Hypothalamus"],
     0, "Medulla oblongata houses protective autonomic respiratory reflex centers for sneezing and coughing.", 1, "Easy", "Physiological Control"),
    ("MOCK_7", 8, "Heredity", "Monohybrid Cross Probability", "FULL_MOCK", "MCQ",
     "A heterozygous tall pea plant (Tt) is crossed with a dwarf pea plant (tt). What percentage of offspring will be dwarf?",
     ["50%", "25%", "75%", "0%"],
     0, "Tt x tt test cross yields 50% Tt (tall) and 50% tt (dwarf).", 1, "Medium", "Genetic Calculation"),
    ("MOCK_8", 9, "Light – Reflection and Refraction", "Lens Ray Calculation", "FULL_MOCK", "MCQ",
     "A convex lens of focal length 10 cm forms a real image at 20 cm. Where is the object located?",
     ["-20 cm (at 2F1)", "-10 cm", "-30 cm", "-5 cm"],
     0, "1/v - 1/u = 1/f => 1/20 - 1/u = 1/10 => 1/u = 1/20 - 1/10 = -1/20 => u = -20 cm.", 1, "Medium", "Lens Formula"),
    ("MOCK_9", 11, "Electricity", "Circuit Power Resistance", "FULL_MOCK", "MCQ",
     "Two identical 500 W heaters are connected in series across a 220 V supply. The total power consumed by the combination is:",
     ["250 W", "500 W", "1000 W", "125 W"],
     0, "In series, resistance doubles (2R). Power P = V^2 / (2R) = (500 W) / 2 = 250 W.", 1, "Hard", "Circuit Analysis"),
    ("MOCK_10", 13, "Our Environment", "Ecosystem Energy Law", "FULL_MOCK", "MCQ",
     "In a food chain: Grass -> Deer -> Tiger, if plants produce 20,000 kJ of energy, how much energy reaches the tiger?",
     ["200 kJ", "2,000 kJ", "20 kJ", "2 kJ"],
     0, "Grass (20,000 kJ) -> Deer (10% = 2,000 kJ) -> Tiger (10% of 2,000 kJ = 200 kJ).", 1, "Medium", "10% Energy Transfer")
]

for m in mock_questions:
    add_q(m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], 1, "Medium", "Board Examination")

print(f"Total questions compiled: {len(all_questions)}")

# Verify 30 questions per chapter
for ch in range(1, 14):
    ch_qs = [q for q in all_questions if q["chapterId"] == ch and q["testType"] != "FULL_MOCK"]
    print(f"Chapter {ch} questions count: {len(ch_qs)}")
    assert len(ch_qs) == 30, f"Chapter {ch} does not have exactly 30 questions! Has {len(ch_qs)}"

def escape_kt(s):
    return s.replace('\\', '\\\\').replace('"', '\\"').replace('\n', '\\n').replace('\r', '')

# Generate Kotlin file
lines = []
lines.append("package com.example.data.local")
lines.append("")
lines.append("import com.example.data.model.QuestionEntity")
lines.append("import org.json.JSONArray")
lines.append("")
lines.append("object SeedQuestions {")
lines.append("")
lines.append("    private fun makeOptionsJson(vararg options: String): String {")
lines.append("        val array = JSONArray()")
lines.append("        for (opt in options) {")
lines.append("            array.put(opt)")
lines.append("        }")
lines.append("        return array.toString()")
lines.append("    }")
lines.append("")
lines.append("    val questions: List<QuestionEntity> = listOf(")

for i, q in enumerate(all_questions):
    comma = "," if i < len(all_questions) - 1 else ""
    opts_args = ", ".join([f'"{escape_kt(o)}"' for o in q["options"]])
    lines.append("        QuestionEntity(")
    lines.append(f'            questionId = "{q["questionId"]}",')
    lines.append(f'            chapterId = {q["chapterId"]},')
    lines.append(f'            chapter = "{escape_kt(q["chapter"])}",')
    lines.append(f'            topic = "{escape_kt(q["topic"])}",')
    lines.append(f'            testType = "{q["testType"]}",')
    lines.append(f'            questionType = "{q["questionType"]}",')
    lines.append(f'            questionText = "{escape_kt(q["questionText"])}",')
    lines.append(f'            optionsJson = makeOptionsJson({opts_args}),')
    lines.append(f'            correctAnswer = {q["correctAnswer"]},')
    lines.append(f'            explanation = "{escape_kt(q["explanation"])}",')
    lines.append(f'            marks = {q["marks"]},')
    lines.append(f'            difficulty = "{q["difficulty"]}",')
    lines.append(f'            competency = "{escape_kt(q["competency"])}"')
    lines.append(f"        ){comma}")

lines.append("    )")
lines.append("}")
lines.append("")

out_path = "app/src/main/java/com/example/data/local/SeedQuestions.kt"
with open(out_path, "w", encoding="utf-8") as f:
    f.write("\n".join(lines))

print(f"Successfully wrote {len(all_questions)} questions to {out_path}!")
