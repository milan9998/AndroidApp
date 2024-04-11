package rs.ac.ecommerceapp.reqApi;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import rs.ac.ecommerceapp.R;

public class AllGamesList extends AppCompatActivity {
    private TextView textView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_games_list);

        textView = findViewById(R.id.textView);

        linearLayout = findViewById(R.id.linearLayout);

        Log.d("TAG", "radi");
        new GameTask().execute();
    }


    private class GameTask extends AsyncTask<Void, Void, AppList> {


        @Override
        protected AppList doInBackground(Void... voids) {
            try {
                URL appListUrl = new URL("https://api.steampowered.com/ISteamApps/GetAppList/v2/");
                HttpURLConnection connection = (HttpURLConnection) appListUrl.openConnection();

                connection.setRequestMethod("GET");
                connection.setRequestProperty("X-RapidAPI-Key", "dc95ffe4d2msh6913ec30d4bdfaap1e0b4ajsn3bedd13e7fe0");
                connection.setRequestProperty("X-RapidAPI-Host", "mmo-games.p.rapidapi.com");

                int responseCode = connection.getResponseCode();
                System.out.println(responseCode);
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    //  String str = slurp(connection.getInputStream(),512);

                    ObjectMapper objectMapper = new ObjectMapper();
                    //  AppList appList = objectMapper.readValue(str, AppList.class);
                    var x = connection.getInputStream();
                    var x2= objectMapper.readValue(connection.getInputStream(), new TypeReference<AppList>() {
                    });
                    return objectMapper.readValue(connection.getInputStream(), new TypeReference<AppList>() {
                    });


                } else {
                    Log.e("GameTask", "HTTP request failed, response code: " + responseCode);
                    return null;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }


        @Override
        protected void onPostExecute(AppList appList) {
            if (appList != null && appList.getApplist() != null && !appList.getApplist().getLista().isEmpty()) {
                LinearLayout linearLayout = findViewById(R.id.linearLayout);

                for (App app : appList.getApplist().getLista()) {
                    int appid = app.getAppid();
                    String name = app.getName();

                    // Primena removeHtmlTags metode na appid i name
                    String cleanedAppid = removeHtmlTags(String.valueOf(appid));
                    String cleanedName = removeHtmlTags(name);

                    TextView textView = new TextView(getApplicationContext());
                    textView.setText(Html.fromHtml("<b>AppID:</b> " + cleanedAppid + "<br>" +
                            "<b>Name:</b> " + cleanedName + "<br>"));

                    linearLayout.addView(textView);
                    View space = new View(getApplicationContext());
                    space.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            10
                    ));
                    linearLayout.addView(space);
                }
            } else {
                // Handle errors if there's an issue fetching data
                Log.e("GameTask", "Failed to fetch game data.");
            }
        }
/*protected void onPostExecute(AppList appList) {
    int maxItemsToShow = 10;  // Set your desired limit

    if (appList != null && appList.getApplist() != null && !appList.getApplist().getLista().isEmpty()) {
        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        int itemsShown = 0;

        for (App app : appList.getApplist().getLista()) {
            if (itemsShown >= maxItemsToShow) {
                break;  // Break the loop if the limit is reached
            }

            int appid = app.getAppid();
            String name = app.getName();

            // Primena removeHtmlTags metode na appid i name
            String cleanedAppid = removeHtmlTags(String.valueOf(appid));
            String cleanedName = removeHtmlTags(name);

            TextView textView = new TextView(getApplicationContext());
            textView.setText(Html.fromHtml("<b>AppID:</b> " + cleanedAppid + "<br>" +
                    "<b>Name:</b> " + cleanedName + "<br>"));

            linearLayout.addView(textView);
            View space = new View(getApplicationContext());
            space.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    10
            ));
            linearLayout.addView(space);

            itemsShown++;
        }
    } else {
        // Handle errors if there's an issue fetching data
        Log.e("GameTask", "Failed to fetch game data.");
    }
}*/

        private String removeHtmlTags(String input) {
            return android.text.Html.fromHtml(input).toString();
        }
    }
}
//        @Override
//        protected void onPostExecute(AppList appList) {
//            if (appList != null && appList.getListApi() != null && appList.getListApi().getLista().size() > 0) {
//                for (AppList app : appList.getListApi()) {
//                    String appid = String.valueOf(app.getAppid());
//                    String name = app.getName();
//
//                    // Primena removeHtmlTags metode na appid i name
//                    String cleanedAppid = removeHtmlTags(appid);
//                    String cleanedName = removeHtmlTags(name);
//
//                    TextView textView = new TextView(getApplicationContext());
//                    textView.setText(Html.fromHtml("<b>AppID:</b> " + cleanedAppid + "<br>" +
//                            "<b>Name:</b> " + cleanedName + "<br>"));
//
//                    linearLayout.addView(textView);
//                }
//            } else {
//                // Handle errors if there's an issue fetching data
//                Log.e("GameTask", "Failed to fetch game data.");
//            }
//        }