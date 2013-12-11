package fr.fchantrel.myfreego.activity;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fr.fchantrel.myfreego.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ProductsListView extends Activity {
	// All static variables
	// XML node keys
	static final String KEY_SONG = "song"; // parent node
	static final String KEY_ID = "id";
	static final String KEY_TITLE = "title";
	static final String KEY_ARTIST = "artist";
	static final String KEY_DURATION = "duration";
	static final String KEY_THUMB_URL = "thumb_url";
	
	ListView list;
    LazyAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_products);
		
		final ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();

		//XMLParser parser = new XMLParser();
		//String xml = parser.getXmlFromUrl(URL); // getting XML from URL
		//Document doc = parser.getDomElement(xml); // getting DOM element
		
		//NodeList nl = doc.getElementsByTagName(KEY_SONG);
		// looping through all song nodes <song>
		//for (int i = 0; i < nl.getLength(); i++) {
			// creating new HashMap
			HashMap<String, String> map = new HashMap<String, String>();
			// adding each child node to HashMap key => value
			map.put(KEY_ID, "1");
			map.put(KEY_TITLE, "Orange");
			map.put(KEY_ARTIST, "7 oranges en stock.");
			map.put(KEY_DURATION, "13/11/2013");
			map.put(KEY_THUMB_URL, String.valueOf(R.drawable.orange));
			songsList.add(map);
			
			// On refait la manip plusieurs fois avec des données différentes pour
			// former les items de notre ListView
			map = new HashMap<String, String>();
			map.put(KEY_ID, "2");
			map.put(KEY_TITLE, "Fraise");
			map.put(KEY_ARTIST, "1.2 kg de fraises en stock.");
			map.put(KEY_DURATION, "13/11/2013");
			map.put(KEY_THUMB_URL, String.valueOf(R.drawable.fraise));
			songsList.add(map);
			
			map = new HashMap<String, String>();
			map.put(KEY_ID, "3");
			map.put(KEY_TITLE, "Banane");
			map.put(KEY_ARTIST, "4 bananes en stock.");
			map.put(KEY_DURATION, "13/11/2013");
			map.put(KEY_THUMB_URL, String.valueOf(R.drawable.banane));
			songsList.add(map);
			
			map = new HashMap<String, String>();
			map.put(KEY_ID, "4");
			map.put(KEY_TITLE, "Pomme");
			map.put(KEY_ARTIST, "0.8 kg de pommes en stock.");
			map.put(KEY_DURATION, "13/11/2013");
			map.put(KEY_THUMB_URL, String.valueOf(R.drawable.pomme));
			songsList.add(map);
			
			map = new HashMap<String, String>();
			map.put(KEY_ID, "5");
			map.put(KEY_TITLE, "Kiwi");
			map.put(KEY_ARTIST, "6 kiwis en stock.");
			map.put(KEY_DURATION, "13/11/2013");
			map.put(KEY_THUMB_URL, String.valueOf(R.drawable.kiwi));
			songsList.add(map);
			
			map = new HashMap<String, String>();
			map.put(KEY_ID, "6");
			map.put(KEY_TITLE, "Tomate");
			map.put(KEY_ARTIST, "5 tomates en stock.");
			map.put(KEY_DURATION, "13/11/2013");
			map.put(KEY_THUMB_URL, String.valueOf(R.drawable.tomate));
			songsList.add(map);
			
			map = new HashMap<String, String>();
			map.put(KEY_ID, "7");
			map.put(KEY_TITLE, "Noix de coco");
			map.put(KEY_ARTIST, "1/2 noix de coco en stock.");
			map.put(KEY_DURATION, "13/11/2013");
			map.put(KEY_THUMB_URL, String.valueOf(R.drawable.coco));
			songsList.add(map);
			
			map = new HashMap<String, String>();
			map.put(KEY_ID, "8");
			map.put(KEY_TITLE, "Citron");
			map.put(KEY_ARTIST, "3 citrons en stock.");
			map.put(KEY_DURATION, "13/11/2013");
			map.put(KEY_THUMB_URL, String.valueOf(R.drawable.citron));
			songsList.add(map);
			
			map = new HashMap<String, String>();
			map.put(KEY_ID, "9");
			map.put(KEY_TITLE, "Pastèque");
			map.put(KEY_ARTIST, "1 pastèque en stock.");
			map.put(KEY_DURATION, "13/11/2013");
			map.put(KEY_THUMB_URL, String.valueOf(R.drawable.pasteque));
			songsList.add(map);

			// adding HashList to ArrayList
			//songsList.add(map);
		//}
		

		list=(ListView)findViewById(R.id.list);
		
		// Getting adapter by passing xml data ArrayList
        adapter=new LazyAdapter(this, songsList);
        list.setAdapter(adapter);

        // Click event for single list row
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			@SuppressWarnings("unchecked")
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				// on récupère la HashMap contenant les infos de notre item
				// (titre, description, img)
				Object myObject = list.getItemAtPosition(2);
				HashMap<String, String> map = (HashMap<String, String>) songsList.get(position);
				//HashMap<String, String> map = (HashMap<String, String>) list
				//		.getItemAtPosition(position);
				// on créer une boite de dialogue
				AlertDialog.Builder adb = new AlertDialog.Builder(
						ProductsListView.this);
				// on attribut un titre à notre boite de dialogue
				adb.setTitle("Sélection Item");
				// on insère un message à notre boite de dialogue, et ici on
				// affiche le titre de l'item cliqué
				adb.setMessage("Votre choix : " + map.get("title"));
				// on indique que l'on veut le bouton ok à notre boite de
				// dialogue
				adb.setPositiveButton("Ok", null);
				// on affiche la boite de dialogue
				adb.show();
			}
		});		
	}	
}