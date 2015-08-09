package com.pundroid.voiceanswer;

import android.content.Context;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by pumba30 on 07.08.2015.
 */
public class RecognizeSpeech implements RecognitionListener {
    public static final String TAG = RecognizeSpeech.class.getSimpleName();
    private static final int MAX_RESULT = 1;

    private SpeechRecognizer speechRecognizer;
    private String word;
    private RecognitionListener listener;
    private Context context;

    public RecognizeSpeech(Context context) {
        Log.d(TAG, "RecognitionSpeech constructor");
        this.context = context;

    }


    @Override
    public void onReadyForSpeech(Bundle params) {

    }

    @Override
    public void onBeginningOfSpeech() {
        Log.d(TAG, "Beginning Speech");
//        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, MAX_RESULT);
//        speechRecognizer.startListening(intent);
    }

    @Override
    public void onRmsChanged(float rmsdB) {
        Log.d(TAG, "onRmsChanged");
    }

    @Override
    public void onBufferReceived(byte[] buffer) {

    }

    @Override
    public void onEndOfSpeech() {
        Log.d(TAG, "onEndOfSpeech");
        speechRecognizer.destroy();
    }

    @Override
    public void onError(int error) {
        Toast.makeText(context, "Ошибка произношения", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResults(Bundle results) {
        Log.d(TAG, "Recognition onResult");
        ArrayList<String> res = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        word = res.get(0);
    }

    @Override
    public void onPartialResults(Bundle partialResults) {

    }

    @Override
    public void onEvent(int eventType, Bundle params) {

    }

    public String getWord() {
        return word;
    }
}
