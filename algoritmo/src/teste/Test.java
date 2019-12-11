package teste;

import basico.ConnectComponents;
import basico.RepositorioPessoa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

	 RepositorioPessoa rep = RepositorioPessoa.getInstance();
	 
	    
	public void start(Stage primaryStage) {
		rep.iniciarPessoas();
		rep.iniciarPClique();
		System.out.println(rep.getCidades().isEmpty());
		System.out.println(rep.getCidades());
		System.out.println(rep.getPessoas());
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/telas/fxmls/Tela1.fxml"));
			Scene cena = new Scene(root);
			primaryStage.setScene(cena);
			primaryStage.setTitle("Alg");
			primaryStage.show();
			} catch(Exception e) {
			e.printStackTrace();
			
		}	
	}
	public static void main(String[] args) {
		 ConnectComponents c = new ConnectComponents();
		 System.out.println(c.retornarCC());
		launch(args);
	}
}
