/**
 * 
 */
package fr.fchantrel.myfreego.activity;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import fr.fchantrel.myfreego.R;

/**
 * @author FredASI Activity exemple avec ListView
 * 
 */
public class OldListViewExampleActivity extends Activity {

	private ListView maListViewPerso;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listviewexample);
		
		// On récupère les données saisies à l'activité AccueilActivity
        Intent intent = getIntent();
        TextView loginDisplay = (TextView) findViewById(R.id.email_display);
        TextView passwordDisplay = (TextView) findViewById(R.id.password_display);

		// Récupération de la listview créée dans le fichier main.xml
		maListViewPerso = (ListView) findViewById(R.id.listviewperso);

		// Création de la ArrayList qui nous permettra de remplire la listView
		ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();

		// On déclare la HashMap qui contiendra les informations pour un item
		HashMap<String, String> map;

		// Création d'une HashMap pour insérer les informations du premier item
		// de notre listView
		map = new HashMap<String, String>();
		// on insère un élément titre que l'on récupérera dans le textView titre
		// créé dans le fichier affichageitem.xml
		map.put("titre", "Orange");
		// on insère un élément description que l'on récupérera dans le textView
		// description créé dans le fichier affichageitem.xml
		map.put("description", "7 oranges en stock.");
		// on insère la référence à l'image (convertit en String car normalement
		// c'est un int) que l'on récupérera dans l'imageView créé dans le
		// fichier affichageitem.xml
		map.put("img", String.valueOf(R.drawable.orange));
		// enfin on ajoute cette hashMap dans la arrayList
		listItem.add(map);

		// On refait la manip plusieurs fois avec des données différentes pour
		// former les items de notre ListView

		map = new HashMap<String, String>();
		map.put("titre", "Fraise");
		map.put("description", "1.2 kg de fraises en stock");
		map.put("img", String.valueOf(R.drawable.fraise));
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Banane");
		map.put("description", "4 bananes en stock.");
		map.put("img", String.valueOf(R.drawable.banane));
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Pomme");
		map.put("description", "0.8 kg de pommes en stock.");
		map.put("img", String.valueOf(R.drawable.pomme));
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Kiwi");
		map.put("description", "6 kiwis en stock.");
		map.put("img", String.valueOf(R.drawable.kiwi));
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Tomate");
		map.put("description", "5 tomates en stock.");
		map.put("img", String.valueOf(R.drawable.tomate));
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Noix de coco");
		map.put("description", "1/2 noix de coco en stock");
		map.put("img", String.valueOf(R.drawable.coco));
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Citron");
		map.put("description", "3 citrons en stock.");
		map.put("img", String.valueOf(R.drawable.citron));
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("titre", "Pastèque");
		map.put("description", "1 pastèque en stock.");
		map.put("img", String.valueOf(R.drawable.pasteque));
		listItem.add(map);

		// Création d'un SimpleAdapter qui se chargera de mettre les items
		// présent dans notre list (listItem) dans la vue affichageitem
		SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(),
				listItem, R.layout.affichageitemlistview, new String[] { "img",
						"titre", "description" }, new int[] { R.id.img,
						R.id.titre, R.id.description });

		// On attribut à notre listView l'adapter que l'on vient de créer
		maListViewPerso.setAdapter(mSchedule);

		// Enfin on met un écouteur d'évènement sur notre listView
		maListViewPerso.setOnItemClickListener(new OnItemClickListener() {
			@Override
			@SuppressWarnings("unchecked")
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				// on récupère la HashMap contenant les infos de notre item
				// (titre, description, img)
				HashMap<String, String> map = (HashMap<String, String>) maListViewPerso
						.getItemAtPosition(position);
				// on créer une boite de dialogue
				AlertDialog.Builder adb = new AlertDialog.Builder(
						OldListViewExampleActivity.this);
				// on attribut un titre à notre boite de dialogue
				adb.setTitle("Sélection Item");
				// on insère un message à notre boite de dialogue, et ici on
				// affiche le titre de l'item cliqué
				adb.setMessage("Votre choix : " + map.get("titre"));
				// on indique que l'on veut le bouton ok à notre boite de
				// dialogue
				adb.setPositiveButton("Ok", null);
				// on affiche la boite de dialogue
				adb.show();
			}
		});

	}
}
