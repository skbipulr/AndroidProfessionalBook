package bipulsarkar.com.notifications;

import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Logg.d();

        final Map<String, String> data = remoteMessage.getData();
        final String val1 = data.get("myKey1");
        final String val2 = data.get("myKey2");

        Logg.d("Message received val1=" + val1 + " val2=" + val2);


        Handler handler = new Handler(getMainLooper());
        handler.post(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(MyFirebaseMessagingService.this.getApplicationContext(),
                        "Message received " + "val1=" + val1 + " val2=" + val2, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onNewToken(String registrationToken) {


        Logg.d("Firebase #onNewToken registrationToken=" + registrationToken);

        startService(new Intent(this, FcmTokenRegistrationService.class));
    }

}
