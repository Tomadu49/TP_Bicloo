package com.example.tpbicloo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends Activity {
	private MainActivity self = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ListView mListArrets = (ListView) findViewById(R.id.listArrets);
		
		RequestQueue queue = Volley.newRequestQueue(this);
		
		String url = "https://api.jcdecaux.com/vls/v1/stations?contract=Nantes&apiKey=c836d6ec4181dd94228a0ffe8597da1f1c173fe1";
		//Response.Listener<JSONArray> response = new Response.Listener<JSONArray>();
		JsonArrayRequest jsObjet = new JsonArrayRequest(url,  new Response.Listener<JSONArray>() {
			@Override
			public void onResponse(JSONArray response) {
				// TODO Auto-generated method stub
				//Log.d("<<<", response.toString());
				try {
					Log.d("TOTO", response.getJSONObject(1).getString("name"));
					final ArrayList<BikeStation> list = new ArrayList<BikeStation>();
				    for(int i = 0; i<response.length();i++){
				    	BikeStation station = new BikeStation(new String(response.getJSONObject(i).getString("name").getBytes("ISO-8859-1"),"UTF-8"), response.getJSONObject(i).getInt("available_bikes"), response.getJSONObject(i).getInt("bike_stands"));
				    	String arrayArret = ""+station.getNomArret()+ "   "+ station.getNbrPlacesLibres()+"/"+station.getNbrPlaces();
				    	list.add(station);
				    	
				    }
				    maListeAdapteur mListe = new maListeAdapteur(self, list);
//				    ArrayAdapter<String> adapter = new ArrayAdapter<String>(self,android.R.layout.simple_list_item_1, list);
//				    mListArrets.setAdapter(adapter);
				    mListArrets.setAdapter(mListe);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				Log.d("xxx", error.toString());				
			}
		});
		
		queue.add(jsObjet);
		
		
		Log.d("TEST", "FIN");
		
	}
	


}
