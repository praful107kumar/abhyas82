# -*- coding: utf-8 -*-
import json
import os

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

print("Helper defined.")
