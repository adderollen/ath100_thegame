package com.ath100.ath100thegame;

import android.app.Activity;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by andreas rolen on 26/06/15.
 */
public class Settings extends Activity {

    private Spinner nbrOfPlayers;
    private EditText city;
    private String cityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.settings);
        nbrOfPlayers = (Spinner)findViewById(R.id.nbrOfPlayers);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.playerAmount, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        nbrOfPlayers.setAdapter(adapter);

        city = (EditText) findViewById(R.id.city);

        cityText =  city.getText().toString();


        Button startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                if (!cityText.isEmpty()) {
                    intent.putExtra("EXTRA_CITY", cityText);
                }
                intent.putExtra("EXTRA_NBR_OF_PLAYERS", Integer.parseInt(nbrOfPlayers.getSelectedItem().toString()));
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}
