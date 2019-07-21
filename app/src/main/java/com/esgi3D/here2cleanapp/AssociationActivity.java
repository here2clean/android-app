package com.esgi3D.here2cleanapp;

import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AssociationActivity extends AppCompatActivity {
    Association association;
    TextView tvDescription;
    Button shopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        association = (Association) getIntent().getExtras().get(String.valueOf(R.string.ASSOCIATION));
        tvDescription = (TextView)findViewById(R.id.tv_assoc_description_detail);
        tvDescription.setText(association.getDescription());


        setContentView(R.layout.activity_association);

        shopButton = findViewById(R.id.ShopBtn);

        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navToShop(Constants.SHOP_URL);
            }
        });
    }

    private void navToShop(String s) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.SHOP_URL));
        startActivity(browserIntent);
    }


}
