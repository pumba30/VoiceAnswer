package com.pundroid.voiceanswer;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by pumba30 on 07.08.2015.
 */
public class PhoneListener extends PhoneStateListener {
    public static final String TAG = PhoneListener.class.getSimpleName();
    private Context context;
    private String commandOffHook = "алло";
    RecognizeSpeech recognizeSpeech;

    public PhoneListener(Context context) {
        this.context = context;
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        super.onCallStateChanged(state, incomingNumber);
        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                Toast.makeText(context, "Idle",
                        Toast.LENGTH_LONG).show();
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                Toast.makeText(context, "Ringing: " + incomingNumber,
                        Toast.LENGTH_SHORT).show();


//                if (command != null && command.equalsIgnoreCase(commandOffHook)) {
//                    //---answer the call---
//                    Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON);
//                    intent.putExtra(Intent.EXTRA_KEY_EVENT,
//                            new KeyEvent(KeyEvent.ACTION_UP,
//                                    KeyEvent.KEYCODE_HEADSETHOOK));
//                    context.sendOrderedBroadcast(intent, null);
//                }
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                Toast.makeText(context, "Off Hook",
                        Toast.LENGTH_LONG).show();
                break;
        }
    }


//    //обработка голосовой команды
//    private void handleVoiceCommand(Context context) {
//        Log.d(TAG, "handleVoiceCommand");
//        recognizeSpeech = new RecognizeSpeech(context);
//    }


}
