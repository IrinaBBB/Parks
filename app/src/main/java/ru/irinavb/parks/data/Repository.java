package ru.irinavb.parks.data;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ru.irinavb.parks.controller.AppController;
import ru.irinavb.parks.model.Image;
import ru.irinavb.parks.model.Park;
import ru.irinavb.parks.util.Util;

public class Repository {
    static List<Park> parkList = new ArrayList<>();

    public static void getParks(final AsyncResponse callback) {
        JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.GET, Util.PARKS_URL, null, response -> {

                    try {
                        JSONArray jsonArray = response.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Park park = new Park();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            park.setId(jsonObject.getString("id"));
                            park.setFullName(jsonObject.getString("fullName"));
                            park.setLatitude(jsonObject.getString("latitude"));
                            park.setLongitude(jsonObject.getString("longitude"));
                            park.setParkCode(jsonObject.getString("parkCode"));
                            park.setStates(jsonObject.getString("states"));
                            park.setWeatherInfo(jsonObject.getString("weatherInfo"));
                            park.setName(jsonObject.getString("name"));
                            park.setDesignation(jsonObject.getString("designation"));

                            JSONArray imageList = jsonObject.getJSONArray("images");
                            List<Image> list = new ArrayList<>();
                            for (int j = 0; j < imageList.length(); j++) {
                                Image image = new Image();
                                image.setCredit(imageList.getJSONObject(j).getString("credit"));
                                image.setTitle(imageList.getJSONObject(j).getString("title"));
                                image.setUrl(imageList.getJSONObject(j).getString("url"));
                                list.add(image);
                            }
                            park.setImages(list);
                            parkList.add(park);
                        }
                        if (null != callback) {
                            callback.processPark(parkList);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }, Throwable::printStackTrace);

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
