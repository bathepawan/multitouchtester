package com.a0x80bits.multitouchtester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        String about = "<p>Hello mate,  I am Pawan Bathe,<br> I love writing android applications, " +
                "Check my other application which you may like on playstore <br> </ps>" +
                "<a href='https://play.google.com/store/apps/details?id=com.pawanbathe.hardwaresanitytester&hl=en'>Hardware Sanity Tester </a>";
        TextView textabout = (TextView) findViewById(R.id.textabout);
        textabout.setClickable(true);
        textabout.setMovementMethod(LinkMovementMethod.getInstance());
        textabout.setText(Html.fromHtml(about));
    }
}
