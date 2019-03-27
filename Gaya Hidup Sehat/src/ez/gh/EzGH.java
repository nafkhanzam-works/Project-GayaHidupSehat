package ez.gh;

import ez.gh.views.EzGHMainView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EzGH extends Application {
	public static Application app;
	public static Stage stage;
	public static Scene mainScene;
	public static EzGHMainView mainView;
	public static void main(String[] args) {
		Application.launch(args);
	}
	public void start(Stage stage) throws Exception {
		EzGH.app = this;
		EzGH.stage = stage;
		FXMLLoader load = new FXMLLoader();
		load.setLocation(EzGH.class.getResource("views/EzGHMainView.fxml"));
		load.setController(mainView = new EzGHMainView());
		stage.setTitle("Gaya Hidup Sehat ITB v1.0");
		stage.setScene(mainScene = new Scene((Pane)load.load()));
		stage.sizeToScene();
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}
}
