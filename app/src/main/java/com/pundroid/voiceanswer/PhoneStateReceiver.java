package com.pundroid.voiceanswer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

/**
 * Created by pumba30 on 07.08.2015.
 */
public class PhoneStateReceiver extends BroadcastReceiver {

    private TelephonyManager telephonyManager;
    private PhoneListener phoneStateListener;
    static boolean alreadyListening = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        phoneStateListener = new PhoneListener(context);
        telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        // do not add the listener more than once
        if (!alreadyListening) {
            telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
            alreadyListening = true;

        }
    }

//    @Override
//    public IBinder peekService(Context myContext, Intent service) {
//        return super.peekService(myContext, service);
//    }
}
