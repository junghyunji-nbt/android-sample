package co.adison.offerwall.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.adison.Adison;

public class MainActivity extends AppCompatActivity {

    public static final String APP_ID = "h5TKfDvtMnBN9WnszgpjVvrG";

    private TextView uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("AdiSON 오퍼월");

        Adison.init(getApplicationContext(), APP_ID);

        uid = findViewById(R.id.uid);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button button = findViewById(R.id.btn_offerwall);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = uid.getText().toString();
                if (!TextUtils.isEmpty(text)) {
                    Adison.setUid(text);
                } else {
                    Adison.setUid(null);
                }
                Adison.showOfferwall();
            }
        });
    }
}
