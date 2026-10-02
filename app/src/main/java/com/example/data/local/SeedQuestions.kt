package com.example.data.local

import android.content.Context
import android.util.Log
import com.example.data.model.QuestionEntity
import org.json.JSONArray
import java.io.InputStreamReader

object SeedQuestions {
    private const val TAG = "SeedQuestions"

    fun loadAllQuestions(context: Context): List<QuestionEntity> {
        val list = mutableListOf<QuestionEntity>()
        try {
            context.assets.open("questions.json").use { stream ->
                InputStreamReader(stream, "UTF-8").use { reader ->
                    val content = reader.readText()
                    val jsonArray = JSONArray(content)
                    for (i in 0 until jsonArray.length()) {
                        val obj = jsonArray.getJSONObject(i)
                        val optsArr = obj.getJSONArray("options")
                        val optsJsonStr = optsArr.toString()

                        list.add(
                            QuestionEntity(
                                questionId = obj.getString("questionId"),
                                chapterId = obj.getInt("chapterId"),
                                chapter = obj.getString("chapter"),
                                topic = obj.getString("topic"),
                                testType = obj.getString("testType"),
                                questionType = obj.optString("questionType", "MCQ"),
                                questionText = obj.getString("questionText"),
                                optionsJson = optsJsonStr,
                                correctAnswer = obj.getInt("correctAnswer"),
                                explanation = obj.getString("explanation"),
                                marks = obj.optInt("marks", 1),
                                difficulty = obj.optString("difficulty", "Medium"),
                                competency = obj.optString("competency", "Conceptual Understanding")
                            )
                        )
                    }
                }
            }
            Log.d(TAG, "Successfully loaded ${list.size} questions from assets/questions.json")
        } catch (e: Exception) {
            Log.e(TAG, "Error loading questions from assets: ${e.message}", e)
        }
        return list
    }
}
