package fr.fchantrel.myfreego.activity;

import java.util.ArrayList;
import java.util.HashMap;

import fr.fchantrel.myfreego.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter {
    
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
    
    public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_products_row, null);

        TextView title = (TextView)vi.findViewById(R.id.title); // title
        TextView artist = (TextView)vi.findViewById(R.id.artist); // artist name
        TextView duration = (TextView)vi.findViewById(R.id.duration); // duration
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image
        
        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);
        
        // Setting all values in listview
        title.setText(song.get(ProductsListView.KEY_TITLE));
        artist.setText(song.get(ProductsListView.KEY_ARTIST));
        duration.setText(song.get(ProductsListView.KEY_DURATION));
        int img_int = R.drawable.no_image;
        try {
            img_int = Integer.parseInt(song.get(ProductsListView.KEY_THUMB_URL));
        } catch (Exception e) { }

        thumb_image.setImageResource(img_int);
        //thumb_image.setImageResource(song.get(ProductsListView.KEY_THUMB_URL));
        //imageLoader.DisplayImage(song.get(ProductsListView.KEY_THUMB_URL), thumb_image);
        return vi;
    }
}