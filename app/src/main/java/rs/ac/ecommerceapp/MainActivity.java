package rs.ac.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import rs.ac.ecommerceapp.reqApi.AllGamesList;

public class MainActivity extends AppCompatActivity {
        TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TextView welcome= findViewById(R.id.welcome);
        String email = getIntent().getStringExtra("KEY_EMAIL");
        welcome.setText("Welcome " + email);

    }
public void handleSelection(View view) {
    Toast.makeText(this, "Opening...", Toast.LENGTH_SHORT).show();
   if(view.getId() == R.id.game1){
       openYouTubeVideo("QdBZY2fkU-0&t");
   } else if (view.getId() == R.id.game2) {
       openYouTubeVideo("0ZqMt74hO6U");

   }else if (view.getId() == R.id.game3) {
       openYouTubeVideo("wsf78BS9VE0");

   }else if (view.getId() == R.id.game4) {
       openYouTubeVideo("kJawWyRUOBM");

   }else if (view.getId() == R.id.game5) {
       openYouTubeVideo("RDzw1EKnaIA");

   }else if (view.getId() == R.id.game6) {
       openYouTubeVideo("CHtd3oVt1QE");

   }else if (view.getId() == R.id.game7) {
       openYouTubeVideo("c7nRTF2SowQ");

   }else if (view.getId() == R.id.game8) {
       openYouTubeVideo("8X2kIfS6fb8");

   }else if (view.getId() == R.id.game9) {
       openYouTubeVideo("ASzOzrB-a9E");

   }else if (view.getId() == R.id.game10) {
       openYouTubeVideo("WomAGoEh-Ss");

   }else if (view.getId() == R.id.game11) {
       openYouTubeVideo("hvoD7ehZPcM");

   }else if (view.getId() == R.id.game12) {
       openYouTubeVideo("vzHrjOMfHPY");

   }else if (view.getId() == R.id.game13) {
       openYouTubeVideo("CZLcCeH2dHU");

   }
}

    private void openYouTubeVideo(String videoId) {



        // Kreiranje URL adrese za YouTube video
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=" + videoId);

        // Kreiranje Intent-a za otvaranje YouTube videoa u YouTube aplikaciji ili pregledaču
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);//implicitni intent !!!

        // Provera dostupnosti YouTube aplikacije
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Ako je YouTube aplikacija dostupna, otvorite video u njoj
            startActivity(intent);
        } else {
            // Ako YouTube aplikacija nije dostupna, otvorite video u pregledaču
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + videoId));
            startActivity(intent);
        }
    }
    public void checkOffers(View view){
        startActivity(new Intent(MainActivity.this,Games.class));
    }
    public void CheckReq(View view){
        startActivity(new Intent(MainActivity.this, AllGamesList.class));
    }

}