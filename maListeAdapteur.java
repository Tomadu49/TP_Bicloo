package com.example.tpbicloo;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class maListeAdapteur extends ArrayAdapter<BikeStation> {
	private Context context;
	private ArrayList<BikeStation> allBike;

	private LayoutInflater mInflater;
	private boolean mNotifyOnChange = true;

	public maListeAdapteur(Context context, ArrayList<BikeStation> mListe) {
		super(context, R.layout.layout_arrets);
		this.context = context;
	    this.allBike = new ArrayList<BikeStation>(mListe);
	    this.mInflater = LayoutInflater.from(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getCount() {
	    return allBike .size();
	}

	@Override
	public BikeStation getItem(int position) {
	    return allBike .get(position);
	}

	@Override
	public long getItemId(int position) {
	    // TODO Auto-generated method stub
	    return position;
	}

	@Override
	public int getPosition(BikeStation item) {
	    return allBike .indexOf(item);
	}

	@Override
	public int getViewTypeCount() {
	    return 1; //Number of types + 1 !!!!!!!!
	}

	@Override
	public int getItemViewType(int position) {
	    return 1;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	    final ViewHolder holder;
	    int type = getItemViewType(position);
	    if (convertView == null) {
	        holder = new ViewHolder();
	        switch (type) {
	        case 1:
	            convertView = mInflater.inflate(R.layout.layout_arrets,parent, false);
	            holder.name = (TextView) convertView.findViewById(R.id.nomArret);
	            holder.description = (TextView) convertView.findViewById(R.id.placesArret);
	            break;
	        }
	        convertView.setTag(holder);
	    } else {
	        holder = (ViewHolder) convertView.getTag();
	    }
	    holder.name.setText(allBike.get(position).getNomArret());
	    holder.description.setText(allBike.get(position).getNbrPlacesLibres());
	    holder.pos = position;
	    return convertView;
	}

	@Override
	public void notifyDataSetChanged() {
	    super.notifyDataSetChanged();
	    mNotifyOnChange = true;
	}

	public void setNotifyOnChange(boolean notifyOnChange) {
	    mNotifyOnChange = notifyOnChange;
	}


	//---------------static views for each row-----------//
	     static class ViewHolder {

	         TextView name;
	         TextView description;
	         int pos; //to store the position of the item within the list
	     }

}
