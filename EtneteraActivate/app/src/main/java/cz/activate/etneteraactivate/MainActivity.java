package cz.activate.etneteraactivate;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String urlJobs = "https://www.startupjobs.cz/startup/etnetera-activate";
    String urlBlog = "https://www.activate.cz/blog/";
    String contactNr = "+420233326810";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void seeBlog(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlBlog));
        startActivity(intent);
    }

    public void seeJobs(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlJobs));
        startActivity(intent);
    }

    public void makeCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", contactNr, null));

        startActivity(intent);
    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","activate@etnetera.cz", null));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
