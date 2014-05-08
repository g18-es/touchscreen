package Musica;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application implements omxPlayer {
	private Process p;
	
	@Override
	public void start(Stage primaryStage) {
	
		try {
			Group root = new Group();
			Scene scene = new Scene(root,1280,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Label randyLabel = new Label("test");
		
			//add event handlers			
			Button playPause = new Button("I> / ||");
			playPause.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent arg0) {
					Play();
				}
				
			});
			
			Button volumeUp = new Button("+");
			volumeUp.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					IncreaseVol();
				}
				
			});
			
			Button volumeDown = new Button("-");
			volumeDown.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					DecreaseVol();
				}
				
			});
			
			Button previous = new Button("<-");
			previous.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					Previous();
				}
								
			});
			
			Button next = new Button("->");
			next.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					Next();
				}
								
			});
			
			
			Button btn = new Button();
			btn.setText("I / O");
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					//close omx player
					Exit();
					Platform.exit();
					System.exit(0);
				}
			});

			HBox hbox = new HBox(28);
			
			((Group)scene.getRoot()).getChildren().addAll(randyLabel, playPause, volumeUp, volumeDown, previous, next, btn);
			hbox.getChildren().addAll(randyLabel, playPause, volumeUp, volumeDown, previous, next, btn);
			
			root.getChildren().add(hbox);
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			String command;
			
			if(! System.getProperty("os.name").startsWith("Windows 8")){
				
				command = "omxplayer DuttyLove.mp3";
			//	Process p;
				try{
					p = Runtime.getRuntime().exec(command);
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			else{
				System.out.print("running Win8...");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void Play() {
		try{
			p.
			p.getOutputStream().write(arg0);.exec("p");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}


	@Override
	public void Exit(){
		try{
			p.exec("q");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void IncreaseVol() {
		try{
			p.exec("+");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	@Override
	public void DecreaseVol() {
		try{
			p.exec("-");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	@Override
	public void Previous() {
		try{
			p.exec("j");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	@Override
	public void Next() {
		try{
			p.exec("k");
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

}
