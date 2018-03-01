package cz.activate.userprofile;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView name = (TextView) findViewById(R.id.name);
        TextView birthday = findViewById(R.id.birthday);
        TextView country = findViewById(R.id.country);
        name.setText(R.string.name);
        birthday.setText(R.string.birthday);
        country.setText(R.string.country);
        name.setAllCaps(true);
        name.setTypeface(null, Typeface.BOLD);
        ImageView userPhoto = findViewById(R.id.profile_picture);
        userPhoto.setImageResource(R.drawable.user_photo1);

    }
}
