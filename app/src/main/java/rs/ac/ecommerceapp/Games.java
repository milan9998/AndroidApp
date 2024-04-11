package rs.ac.ecommerceapp;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Games extends AppCompatActivity {
    //private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);


       // textView = findViewById(R.id.textView);


        Toast.makeText(this, "Opening...", Toast.LENGTH_LONG).show();

        new NetworkTask().execute();

    }


    private class NetworkTask extends AsyncTask<Void, Void, List<GameNews>> {

        @Override
        protected List<GameNews> doInBackground(Void... voids) {
            try {
                URL url = new URL("https://mmo-games.p.rapidapi.com/latestnews");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");
                connection.setRequestProperty("X-RapidAPI-Key", "dc95ffe4d2msh6913ec30d4bdfaap1e0b4ajsn3bedd13e7fe0");
                connection.setRequestProperty("X-RapidAPI-Host", "mmo-games.p.rapidapi.com");

                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    return objectMapper.readValue(connection.getInputStream(), new TypeReference<List<GameNews>>() {
                    });
                } else {
                    Log.e("NetworkTask", "HTTP request failed, response code: " + responseCode);
                    return null;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<GameNews> articles) {

            if (articles == null || articles.isEmpty())
                return;


            LinearLayout linearLayout = findViewById(R.id.linearLayout);

            for (GameNews article : articles) {
                String cleanedContent = removeHtmlTags(article.getArticleContent());

                //  ImageView za prikaz slike (pre teksta)
                ImageView imageView = new ImageView(getApplicationContext());
                Picasso.get().load(article.getMainImage()).into(imageView);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setAdjustViewBounds(true);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));
                linearLayout.addView(imageView);

                // TextView za prikaz teksta
                TextView textView = new TextView(getApplicationContext());
                textView.setText(Html.fromHtml("<b>Title:</b> " + article.getTitle() + "<br>" +
                        "<b>Content:</b> " + cleanedContent + "<br>"));

                linearLayout.addView(textView);

                // View (razmak između slika)
                //vrlo malo odvajanje zbog peglednosti
                View space = new View(getApplicationContext());
                space.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        10
                ));
                linearLayout.addView(space);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                // Auto-linkify URLs
                Linkify.addLinks(textView, Linkify.WEB_URLS);
            }


            // Handle errors if there's an issue fetching data

        }

        private String removeHtmlTags(String input) {
            return android.text.Html.fromHtml(input).toString();
        }
    }
}
