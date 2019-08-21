package bipulsarkar.com.notifications;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class FcmTokenRegistrationService extends IntentService {

    public FcmTokenRegistrationService() {
        super("FcmTokenRegistrationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {

                            Logg.d("Firebase getInstanceId failed " + task.getException());
                            Toast.makeText(FcmTokenRegistrationService.this, ""+ task.getException(), Toast.LENGTH_SHORT).show();
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                        Logg.d("Firebase registrationToken=" + token);

                        //TODO register token to your server.

                    }
                });
    }
}
