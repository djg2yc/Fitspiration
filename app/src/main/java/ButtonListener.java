import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Priya on 2/12/2017.
 */

public class ButtonListener extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(intent.getExtras().getInt("id"));
        Toast.makeText(context, "Button Clicked!", Toast.LENGTH_SHORT).show();
    }
}
