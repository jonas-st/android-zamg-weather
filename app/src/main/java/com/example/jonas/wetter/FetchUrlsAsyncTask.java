package com.example.jonas.wetter;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

import static android.support.constraint.Constraints.TAG;

public class FetchUrlsAsyncTask extends AsyncTask<Void, Void, Void> {

    private static String apiUrl = "http://yoni-www.dynv6.net/weather";
    @Override
    protected Void doInBackground(Void... voids) {
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response
        String url = apiUrl;
        String jsonStr = sh.makeServiceCall(url);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Get Temp Data
                JSONArray tempUrlsJson = jsonObj.getJSONArray("temp_urls");
                JSONArray tempDateStringsJson = jsonObj.getJSONArray("temp_dates");
                ArrayList<String> tempUrls = new ArrayList<String>();
                ArrayList<String> tempDateStrings = new ArrayList<String>();
                for (int i = 0; i < tempUrlsJson.length(); i++) {
                    tempUrls.add((String) tempUrlsJson.get(i));
                    tempDateStrings.add((String) tempDateStringsJson.get(i));
                }
                URLProvider.getInstance().setTempUrls(tempUrls);
                URLProvider.getInstance().setTempDateStrings(tempDateStrings);

                // Get cloud Data
                JSONArray cloudUrlsJson = jsonObj.getJSONArray("cloud_urls");
                JSONArray cloudDateStringsJson = jsonObj.getJSONArray("cloud_dates");
                ArrayList<String> cloudUrls = new ArrayList<String>();
                ArrayList<String> cloudDateStrings = new ArrayList<String>();
                for (int i = 0; i < cloudUrlsJson.length(); i++) {
                    cloudUrls.add((String) cloudUrlsJson.get(i));
                    cloudDateStrings.add((String) cloudDateStringsJson.get(i));
                }
                URLProvider.getInstance().setCloudUrls(cloudUrls);
                URLProvider.getInstance().setCloudDateStrings(cloudDateStrings);

                // Get Precip Data
                JSONArray precipUrlsJson = jsonObj.getJSONArray("precip_urls");
                JSONArray precipDateStringsJson = jsonObj.getJSONArray("precip_dates");
                ArrayList<String> precipUrls = new ArrayList<String>();
                ArrayList<String> precipDateStrings = new ArrayList<String>();
                for (int i = 0; i < precipUrlsJson.length(); i++) {
                    precipUrls.add((String) precipUrlsJson.get(i));
                    precipDateStrings.add((String) precipDateStringsJson.get(i));
                }
                URLProvider.getInstance().setPrecipUrls(precipUrls);
                URLProvider.getInstance().setPrecipDateStrings(precipDateStrings);

                // Get wetterkarten Data
                JSONArray wetterkartenUrlsJson = jsonObj.getJSONArray("wetterkarten_urls");
                ArrayList<String> wetterkartenUrls = new ArrayList<String>();
                for (int i = 0; i < wetterkartenUrlsJson.length(); i++) {
                    wetterkartenUrls.add((String) wetterkartenUrlsJson.get(i));
                }
                Collections.reverse(wetterkartenUrls);
                URLProvider.getInstance().setWetterkartenUrls(wetterkartenUrls);

            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());

            }

        } else {
            Log.e(TAG, "Couldn't get json from server.");
        }

        return null;
    }
}
