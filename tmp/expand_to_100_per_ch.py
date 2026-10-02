# -*- coding: utf-8 -*-
import json
import sys
import os

sys.path.append('tmp')
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

add_ch1_to_ch4(add_q)
add_ch5_to_ch8(add_q)
add_ch9_to_ch13(add_q)

print(f"Base questions: {len(all_questions)}")

# Now generate 70 additional questions for each chapter from 1 to 13
from create_question_bank import chapters_meta

