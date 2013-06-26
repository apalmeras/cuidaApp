package cuidaApp.views;



import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.Window;

import com.example.cuidaapp.R;

import cuidaApp.common.ListenerGPS;
import cuidaApp.common.TopBar;
import cuidaApp.controllers.MainController;

public class MainActivity extends FragmentActivity {

	private MainController controller=new MainController();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		TopBar.initializeTopBar(this, View.INVISIBLE, View.VISIBLE, View.VISIBLE,
				"", "main");
		ListenerGPS.getInstance().obtenerUbicacion(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void BtnTakePicture(View v){
//		  AppGlobal.getInstance().dispatcher.open(this, "take", true);
		if((ListenerGPS.getInstance().latitud!=0)&&(ListenerGPS.getInstance().longitud!=0)){
			ListenerGPS.getInstance().stopListener();
			controller.loadCategory(this);
		}else{
//			
		}
		
	}
	public void BtnActivos(View v){
//		Images.init();
//        AppGlobal.getInstance().dispatcher.open(this, "activos", true);
	}
}