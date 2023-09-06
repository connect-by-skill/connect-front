package com.example.presentation.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import androidx.navigation.NavHostController
import com.example.presentation.model.Screen


object SpeechTool {
    var isSupported = true
    var tts: TextToSpeech? = null
    var speechIntent: Intent? = null
    var mRecognizer: SpeechRecognizer? = null
    var navController: NavHostController? = null

    fun speakOut(text: String) {
        tts!!.setPitch(1.toFloat())
        tts!!.setSpeechRate(0.8.toFloat())
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1")
    }

    fun speechStart(context: Context) {
        mRecognizer = SpeechRecognizer.createSpeechRecognizer(context) // 음성인식 객체
        mRecognizer!!.setRecognitionListener(listener) // 음성인식 리스너 등록
        mRecognizer!!.startListening(speechIntent)
    }

    private val listener: RecognitionListener = object : RecognitionListener {
        override fun onReadyForSpeech(params: Bundle) {

        }

        override fun onBeginningOfSpeech() {}
        override fun onRmsChanged(rmsdB: Float) {}
        override fun onBufferReceived(buffer: ByteArray) {}
        override fun onEndOfSpeech() {}
        override fun onError(error: Int) {
            val message: String
            message = when (error) {
                SpeechRecognizer.ERROR_AUDIO -> "오디오 에러"
                SpeechRecognizer.ERROR_CLIENT -> "클라이언트 에러"
                SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "퍼미션 없음"
                SpeechRecognizer.ERROR_NETWORK -> "네트워크 에러"
                SpeechRecognizer.ERROR_NETWORK_TIMEOUT -> "네트웍 타임아웃"
                SpeechRecognizer.ERROR_NO_MATCH -> "찾을 수 없음"
                SpeechRecognizer.ERROR_RECOGNIZER_BUSY -> "RECOGNIZER가 바쁨"
                SpeechRecognizer.ERROR_SERVER -> "서버가 이상함"
                SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "말하는 시간초과"
                else -> "알 수 없는 오류임"
            }

        }

        override fun onResults(results: Bundle) {
            val matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
            var resultStr = ""

            for (i in matches!!.indices) {
                resultStr += matches[i]
            }

            if (resultStr.length < 1) return
            resultStr = resultStr.replace(" ", "")
            doSpeech(resultStr)
        }

        override fun onPartialResults(partialResults: Bundle) {}
        override fun onEvent(eventType: Int, params: Bundle) {}
    }

    fun doSpeech(resultStr: String) {
        if (resultStr.indexOf("회원가입") > -1) {
            speakOut("회원가입으로 넘어갑니다.")
            if(navController !=null){
                navController!!.navigate(Screen.SignUp.name) {
                    popUpTo(Screen.Login.name) {inclusive = true}
                }
            }
        }
        else if(resultStr.indexOf("로그인") > -1) {
            speakOut("아이디를 말해주세요.")

        }
    }

    fun offTool(context:Context){
        val getSharedPreferences = context.getSharedPreferences("SpeechTool", Context.MODE_PRIVATE)
        val editor = getSharedPreferences.edit()
        editor.putBoolean("isSupported", false)
        editor.apply()
    }
}

