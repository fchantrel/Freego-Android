package fr.fchantrel.myfreego.activity;

import fr.fchantrel.myfreego.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author FredASI
 * Activity pour accueil application
 *
 */
public class AccueilActivity extends Activity {
	
	final String EXTRA_LOGIN = "user_login";
	final String EXTRA_PASSWORD = "user_password";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);
		
		final EditText login = (EditText) findViewById(R.id.user_login);
	    final EditText pass = (EditText) findViewById(R.id.user_password);
		
		final Button loginButton = (Button) findViewById(R.id.connect);
		  loginButton.setOnClickListener(new OnClickListener() {
					
		  @Override
		  public void onClick(View v) {
			//Intent intent = new Intent(AccueilActivity.this, LoginDisplayActivity.class);
			//Intent intent = new Intent(AccueilActivity.this, OldListViewExampleActivity.class);
			  Intent intent = new Intent(AccueilActivity.this, ProductsListView.class);
			  
			intent.putExtra(EXTRA_LOGIN, login.getText().toString());
			intent.putExtra(EXTRA_PASSWORD, pass.getText().toString());
			
			startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}

}
