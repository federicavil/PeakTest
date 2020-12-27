package logic.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOProvaFirebase {
	
	FirebaseDatabase db;
	DatabaseReference reference;
	
	public void initializeConn() {
		FileInputStream serviceAccount;
		try {
			serviceAccount = new FileInputStream(new java.io.File( "." ).getCanonicalPath() + "\\src\\logic\\model\\peakland-54c42-firebase-adminsdk-cihqn-dace282633.json");
			FirebaseOptions options = FirebaseOptions.builder()
				    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				    .setDatabaseUrl("https://peakland-54c42-default-rtdb.europe-west1.firebasedatabase.app/")
				    // Or other region, e.g. <databaseName>.europe-west1.firebasedatabase.app
				    .build();
			FirebaseApp.initializeApp(options);
			
			String current = new java.io.File( "." ).getCanonicalPath() + "\\src\\logic\\model\\peakland-54c42-firebase-adminsdk-cihqn-dace282633.json" ;
	        System.out.println("Current dir:"+current);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Errore file");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Errore generico");
		}

		// Initialize the app with a service account, granting admin privileges
		
	}
	
	public void saveOnDb() {
		
		db = FirebaseDatabase.getInstance();
		reference = db.getReference("peakland-54c42-default-rtdb");
		
		
		//DatabaseReference mountainPathRef = reference.child("Mountain Path");
		Map<String, String> paths = new HashMap<>();
		paths.put("NewPath", "Eccolo");
		
		reference.setValueAsync(paths);
		
		
	}
	
}
