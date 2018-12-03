package main;

import javafx.stage.Stage;
import javafx.util.Duration;
import java.text.DecimalFormat;
import java.util.LinkedList;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	//Declare window size, generate a StackPane for the layout and a scene to render objects in
	private final int WINDOW_LENGTH = 700;
	private final int WINDOW_HEIGHT = 500;
	StackPane mainMenu = new StackPane();
	Scene scene = new Scene(mainMenu, WINDOW_LENGTH, WINDOW_HEIGHT, Color.BLACK);
	
	//Main Menu UI
	Text title = new Text("SSBM Frame Data Analysis Tool");
	Text subtitle = new Text("Tian Brown - CSE 260 - Paul Fodor");
	Font menuFont = new Font("Leelawadee UI", 42);
	Font buttonFont = new Font("Gyparody Rg", 36);
	Text tm = new Text("Tech Accuracy Mode");
	Text im = new Text("Input Analysis Tool");
	Button techMode = new Button(tm.getText());
	Button inputMode = new Button(im.getText());
	Button exit = new Button("Close");
	static Image shineImage = new Image("img/shine.png");
	static ImageView shine = new ImageView(shineImage);
	int count = 0;
	
	//Effects and Shapes
	DropShadow shad = new DropShadow(5.0, 3.0, 3.0, Color.DARKVIOLET);
	DropShadow shad2 = new DropShadow(20.0, 0.0, 8.0, Color.WHITE);
	DropShadow shad3 = new DropShadow(15.0, 0.0, 8.0, Color.BLACK);
	Rectangle line = new Rectangle(550, 5, Color.WHITE);
	Rectangle background = new Rectangle(WINDOW_LENGTH*2, WINDOW_HEIGHT*2, Color.BLACK);
	RotateTransition rt = new RotateTransition(Duration.millis(6000), shine);
	FadeTransition ft = new FadeTransition(Duration.millis(3000), shine);
	
	//Recording
	Text rStart = new Text("Start Recording");
	Text rStop = new Text("Stop Recording");
	Button startRecording = new Button(rStart.getText());
	Button stopRecording = new Button(rStop.getText());
	Text record = new Text("REC");
	boolean LAM = false;
	boolean IAT = false;
	
	//Character Preset Select
	Button fox = new Button("Fox");
	Button falco = new Button("Falco");
	Button luigi = new Button("Luigi");
	Text choose = new Text("Choose Your Character Preset");
	String ch = "";
	
	//Num. Players UI
	Button p1 = new Button("One Player");
	Button p2 = new Button("Two Players");
	Text choosePlayerCount = new Text("Choose the Number of Players to Record");
	
	//Counting Frames
	boolean twoPlayers = false;
	public long startRecTime = 0;
	public long stopRecTime = 0;
	int recordFrames = 0;
	DecimalFormat df = new DecimalFormat("0.00##");
	int totalAvg = 0;
	
	//input recorders
	LinkedList<String> p1inputs;
	LinkedList<Integer> p1times;
	
	//error
	Text error = new Text();
	
//HELPER METHODS-----------------------------------------------------------------------------------------------------
	
	//Format the main menu and button text to look nice
	public void makeText(Text n) {
		n.setFont(menuFont);
		n.setScaleX(0.95);
		n.setScaleY(1);
		n.setTextAlignment(TextAlignment.CENTER);
		n.setStyle("-fx-font-weight: normal;");
		n.setFill(Color.WHITE);
		n.setEffect(shad);
	}
	public void makeResultText(Text [] n) {
		for (int i = 0; i < n.length; i++) {
			n[i].setFont(menuFont);
			n[i].setScaleX(0.5);
			n[i].setScaleY(0.5);
			n[i].setTextAlignment(TextAlignment.LEFT);
			n[i].setStyle("-fx-font-weight: normal;");
			n[i].setFill(Color.WHITE);
		}
	}
	
	
	//Button effects for when the mouse hovers over
	public void buttonMouseEnter (Button b) {
		if (b.getText().equals("Fox") || b.getText().equals("Falco") || b.getText().equals("Luigi")) {
			b.setStyle("-fx-background-color: #f2f2f2; ");
			b.setTextFill(Color.BLACK);
		}
		else {
			b.setStyle("-fx-background-color: #9f35d4");
			b.setTextFill(Color.WHITE);
			b.setEffect(shad2);
		}
		
	}	
	public void mainMenuButtonMouseExit (Button b) {
		b.setStyle("-fx-background-color: #ffffff; ");
		b.setEffect(null);
		if (b.getText().equals("Tech Accuracy Mode"))
			b.setTextFill(Color.RED);
		else if (b.getText().equals("Input Analysis Tool"))
			b.setTextFill(Color.BLUE);
		else
			b.setTextFill(Color.BLACK);
		
	}
	public void recordButtonMouseExit (Button b) {
		b.setStyle("-fx-background-color: #ffffff; ");
		b.setEffect(null);
		if (b.getText().equals("Start Recording"))
			b.setTextFill(Color.RED);
		else if (b.getText().equals("Stop Recording"))
			b.setTextFill(Color.BLUE);
		else
			b.setTextFill(Color.BLACK);
	}
	public void presetButtonMouseExit (Button b) {
		b.setStyle("-fx-background-color: #ffffff; ");
		b.setTextFill(Color.BLACK);
		if (b.getText().equals("Fox"))
			b.setStyle("-fx-background-color: #FF9029; ");
		else if (b.getText().equals("Falco")) {
			b.setStyle("-fx-background-color: #2121FF; ");
			b.setTextFill(Color.WHITE);
		}
		else if (b.getText().equals("Luigi")) {
			b.setStyle("-fx-background-color: #00B803; ");
		b.setTextFill(Color.WHITE);
		}
		else
			b.setStyle("-fx-background-color: #f2f2f2; ");
	}
	public void playerButtonMouseExit (Button b) {
		b.setStyle("-fx-background-color: #ffffff; ");
		b.setTextFill(Color.BLACK);
		if (b.getText().equals("One Player"))
			b.setStyle("-fx-background-color: #FF0000; ");
		else if (b.getText().equals("Two Players")) {
			b.setStyle("-fx-background-color: #0011FF; ");
			b.setTextFill(Color.WHITE);
		}
	}
	
	//format the buttons
	public void makeMainMenuButton (Button b) {
		b.setFont(buttonFont);
		b.setScaleX(0.5);
		b.setScaleY(0.5);
		b.setStyle("-fx-background-color: #f2f2f2; ");
		b.setOnMouseEntered(e -> { buttonMouseEnter(b); });
		b.setOnMouseExited(e -> { mainMenuButtonMouseExit(b); });
	}
	public void makeRecordButton (Button b) {
		b.setFont(buttonFont);
		b.setScaleX(0.5);
		b.setScaleY(0.5);
		b.setStyle("-fx-background-color: #f2f2f2; ");
		if (b.getText().equals("Start Recording"))
			b.setTextFill(Color.RED);
		if (b.getText().equals("Stop Recording"))
			b.setTextFill(Color.BLUE
					);
		b.setOnMouseEntered(e -> { buttonMouseEnter(b); });
		b.setOnMouseExited(e -> { recordButtonMouseExit(b); });
	}
	public void makePresetButton (Button b) {
		b.setFont(buttonFont);
		b.setScaleX(0.5);
		b.setScaleY(0.5);
		b.setEffect(shad3);
		b.setOnMouseEntered(e -> { buttonMouseEnter(b); });
		b.setOnMouseExited(e -> { presetButtonMouseExit(b); });
		if (b.getText().equals("Fox"))
			b.setStyle("-fx-background-color: #FF9029; ");
		else if (b.getText().equals("Falco")) {
			b.setStyle("-fx-background-color: #2121FF; ");
			b.setTextFill(Color.WHITE);
		}
		else if (b.getText().equals("Luigi")) {
			b.setStyle("-fx-background-color: #00B803; ");
			b.setTextFill(Color.WHITE);
		}
	}
	public void makePlayerButton (Button b) {
		b.setFont(buttonFont);
		b.setScaleX(0.5);
		b.setScaleY(0.5);
		b.setEffect(shad3);
		b.setOnMouseEntered(e -> { buttonMouseEnter(b); });
		b.setOnMouseExited(e -> { playerButtonMouseExit(b); });
		if (b.getText().equals("One Player"))
			b.setStyle("-fx-background-color: #FF0000; ");
		else if (b.getText().equals("Two Players")) {
			b.setStyle("-fx-background-color: #0011FF; ");
			b.setTextFill(Color.WHITE);
		}
	}
	
	//Set the shapes for the controller buttons to their starting (non-pressed) location and opacity value
	public void setUpShape (Shape button, double a, double b, double c) {
		button.setOpacity(a);
		button.setTranslateX(b);
		button.setTranslateY(c);
	}
	
	//Blanket method to apply translation(x, y) and scaling(x, y) without using four individual methods
	public void edit (Node n, double x, double y, double sX, double sY) {
		n.setTranslateX(x);
		n.setTranslateY(y);
		n.setScaleX(sX);
		n.setScaleY(sY);
	}
	
	
	
//MENU OPTION METHODS----------------------------------------------------------------------------------
	
	//main start method (starts the program)
	@Override
	public void start(Stage st) {
		
		makeText(title); makeText(subtitle);
		title.setTranslateY(-150);
		edit(subtitle, 0, -80, 0.75, 0.75);	
		line.setTranslateY(-110);
		line.setEffect(shad);
		
		makeMainMenuButton(techMode);
		techMode.setTranslateY(90);
		techMode.setTextFill(Color.RED);
		techMode.setOnMouseClicked(e -> {techAccuracyMode(st, scene);});
		
		makeMainMenuButton(inputMode);
		inputMode.setTranslateY(150);
		inputMode.setTextFill(Color.BLUE);
		inputMode.setOnMouseClicked(e -> {inputAnalysisMode(st, scene);});
		
		makeMainMenuButton(exit);
		edit(exit, 0, 200, 0.5, 0.5);
		exit.setTranslateY(210);
		exit.setTextFill(Color.BLACK);
		exit.setOnMouseClicked(e -> {System.exit(0);});
		
		tm.setFont(buttonFont);
		im.setFont(buttonFont);
		
		shad.setBlurType(null);
		
		mainMenu.getChildren().addAll(background, shine, title, subtitle, line, techMode, inputMode, exit);	
		
		//set up pulsating Shine image
		edit(shine, 0, 0, 0.2, 0.2);	
		
		rt.setByAngle(360);
		rt.setCycleCount(Integer.MAX_VALUE);	

	    ft.setFromValue(0.75);
	    ft.setToValue(0.05);
	    ft.setCycleCount(Integer.MAX_VALUE);
	    ft.setAutoReverse(true);	    
	    rt.play();
	    ft.play();
		
		st.setResizable(false);
		st.setTitle("SSBM Frame Data Analysis Tool");
		st.setScene(scene);
		st.show();		
	}

	
	//method that activates when Ledgedash Accuracy Mode is selected
	public void techAccuracyMode (Stage st, Scene scene) {
		mainMenu.getChildren().clear();
		mainMenu.getChildren().addAll(background, shine, exit, choose, line, fox, falco, luigi);
		exit.setText("Back");
		exit.setOnMouseClicked(e -> {restart(st);});
		ft.stop();
		ft.setFromValue(0.25);
		ft.play();
		
		makePresetButton(fox);
		makePresetButton(falco);
		makePresetButton(luigi);
		makeText(choose);
		
		edit(choose, 0, -150, 0.7, 0.7);
		edit(line, 0, -128, 0.7, 0.7);
		edit(fox, -125, -100, 0.5, 0.5);
		edit(falco, 0, -100, 0.5, 0.5);
		edit(luigi, 125, -100, 0.5, 0.5);
		edit(exit, 300, 215, 0.4, 0.4);	
		
		fox.setOnMouseClicked(e -> { ch = "Fox"; LAM = true; record(st, scene); });
		falco.setOnMouseClicked(e -> { ch = "Falco"; LAM = true; record(st, scene); });
		luigi.setOnMouseClicked(e -> { ch = "Luigi"; LAM = true; record(st, scene); });
	
		
	}
	

	//method for Input Analysis Tool
	public void inputAnalysisMode (Stage st, Scene scene) {
		mainMenu.getChildren().clear();
		mainMenu.getChildren().addAll(background, shine, exit, p1, p2, choosePlayerCount, line);
		exit.setText("Back");
		exit.setOnMouseClicked(e -> {restart(st);});
		ft.stop();
		ft.setFromValue(0.25);
		ft.play();
		
		makePlayerButton(p1);
		makePlayerButton(p2);
		makeText(choosePlayerCount);	
		edit(p1, -100, -95, 0.5, 0.5);
		edit(p2, 100, -95, 0.5, 0.5);
		edit(choosePlayerCount, 0, -150, 0.55, 0.55);
		edit(line, 0, -128, 0.7, 0.7);
		edit(exit, 300, 215, 0.4, 0.4);
		
		p1.setOnMouseClicked(e -> { IAT = true; record(st, scene); });
		p2.setOnMouseClicked(e -> { IAT = true; record(st, scene); });
	}
	
	
	//method to switch to the "recording screen"
	public void record (Stage st, Scene scene) {
		mainMenu.getChildren().clear();
		mainMenu.getChildren().addAll(background, shine, exit, startRecording, stopRecording, record);
		ft.stop();
		ft.setFromValue(0.25);
		ft.play();
		
		edit(startRecording, -260, -150, 1, 1);
		edit(stopRecording, -260, -150, 1, 1);
		stopRecording.setVisible(false);
		
		record.setFont(menuFont);
		edit(record, -305, -110, 0.8, 0.8);
		record.setTextAlignment(TextAlignment.LEFT);
		record.setStyle("-fx-font-weight: bold;");
		record.setFill(Color.RED);
		record.setVisible(false);
		
		GamecubeController gc1 = new GamecubeController();
		makeRecordButton(startRecording);
		makeRecordButton(stopRecording);
		
		//start recording
		startRecording.setOnMouseClicked(e -> {
			shine.setOpacity(0.25);
			startRecording.setVisible(false);
			stopRecording.setVisible(true);
			record.setVisible(true); 
			gc1.activateController(true); 
			
			mainMenu.getChildren().addAll(gc1.a, gc1.b, gc1.x, gc1.y, gc1.z, gc1.start, gc1.l, gc1.r, gc1.joy1, gc1.joyC, gc1.up, 
					gc1.down, gc1.left, gc1.right);
			
			
			gc1.generateControllerGUIAndCountInputs(scene);
			startRecTime = System.currentTimeMillis();
		});		

		
		//stop recording
		stopRecording.setOnMouseClicked(e -> { 
			stopRecTime = System.currentTimeMillis();
			recordFrames = (int)((stopRecTime - startRecTime) * 0.06);
			
			record.setVisible(false); 
			mainMenu.getChildren().clear();
			mainMenu.getChildren().addAll(background, shine, exit);			

			p1inputs = gc1.getInputList();
			
			Text [] text = new Text[8];
			for (int i = 0; i < text.length; i++) {
				text[i] = new Text();
			}
			text[0].setText("Recording time: " + ((double)(stopRecTime - startRecTime)/1000) + " seconds.");
			text[1].setText("Recorded " + recordFrames + " frames.\n");
		
			//IF IN INPUT ANALYSIS MODE
			if (IAT) {
				//get sums of each input in various ways
				Integer [] count = gc1.getNumOfEachInput();
				int aInputs = 0;
				int cInputs = 0;
				for (int i = 11; i < 19; i++)
					aInputs += count[i];
				for (int i = 19; i < count.length; i++) 
					cInputs += count[i];
				
				text[2].setText("Player 1: ");
				text[3].setText("Number of Inputs: " + p1inputs.size());
				text[4].setText("Inputs Per Minute: ~" + String.format("%.2f", gc1.getIPM(stopRecTime, startRecTime)));
				text[5].setText("Inputs Per Second: ~" + String.format("%.2f", gc1.getIPS(stopRecTime, startRecTime)));				
				text[6].setText("Input Frequency: ");			
				text[7].setText("A: " + count[0] + "\n"
						+ "B: " + count[1] + "\n"
						+ "X: " + count[2] + "\n"
						+ "Y: " + count[3] + "\n"
						+ "L: " + count[4] + "\n"
						+ "R: " + count[5] + "\n"
						+ "D-Pad Up: " + count[6] + "\n"
						+ "D-Pad Down: " + count[7] + "\n"
						+ "D-Pad Left: " + count[8] + "\n"
						+ "D-Pad Right: " + count[9] + "\n"
						+ "Z: " + count[10] + "\n"
						+ "Start: " + count[11] + "\n"
						+ "Analog Stick Inputs: " + aInputs + "\n"
						+ "C-Stick Inputs: " + cInputs);
				
				displayStats(st, scene, text);
			}
			
			
			
			
			//IF TESTING LEDGEDASH ACCURACY
			if (LAM) {
				p1times = gc1.getTimes();
				
				//compute frame accuracy
				if (p1times.size() == p1inputs.size()) {
					Integer [] ledgedashInputs = new Integer[4];
					Integer [] frameDifferences;
					
					int leave = p1inputs.indexOf("A.L");
					if (leave == -1 && p1inputs.indexOf("A.D") != -1) 
						leave = p1inputs.indexOf("A.D");
					
					int jump = p1inputs.indexOf("Y");
					if (jump == -1 && p1inputs.indexOf("X") != -1)
						jump = p1inputs.indexOf("X");
					
					int airdodge = p1inputs.indexOf("L");
					if (airdodge == -1 && p1inputs.indexOf("R") != -1)
						airdodge = p1inputs.indexOf("R");
					
					int wd = p1inputs.indexOf("A.DR");
					if (wd == -1 && p1inputs.indexOf("A.DL") != -1)
						wd = p1inputs.indexOf("A.DL");
					
					if (leave == -1 || jump == -1 || airdodge == -1 || wd == -1) {
							System.out.println("ERROR: LEDGEDASH NOT COMPUTED CORRECTLY.");
							displayErrorMessage("Incorrect ledgedash inputs.\n"
									+ "Please close the program and try again.");
					}
									
					ledgedashInputs[0] = p1times.get(leave);
					ledgedashInputs[1] = p1times.get(jump);
					ledgedashInputs[2] = p1times.get(airdodge);
					ledgedashInputs[3] = p1times.get(wd);
						
					frameDifferences = gc1.differences(ledgedashInputs, ch);				
					
					//display setup
					Text [] text2 = new Text[5];
					for (int i = 0; i < text2.length; i++) {
						text2[i] = new Text();
					}
					text2[1].setText("Jump: " + frameDifferences[1].toString() + " frames off.");
					text2[2].setText("Airdodge (Trigger Press): " + frameDifferences[2].toString() + " frames off.");
					text2[3].setText("Airdodge (Stick Angle): " + frameDifferences[3].toString() + " frames off.");
					totalAvg = (int)(frameDifferences[1] + frameDifferences[2] + frameDifferences[3])/3;
					if (totalAvg < 3) 
						text2[4].setText("Looking good!");
					else if (totalAvg >= 3 && totalAvg < 10)
						text2[4].setText("Keep practicing! You're getting it!");
					else if (totalAvg >= 10 && totalAvg < 25)
						text2[4].setText("You've got some work to do, keep going!");
					else
						text2[4].setText("Maybe you should play Puff.");
					
					displayStats(st, scene, text2);
				}
				else
					//error
					displayErrorMessage("ERROR: INPUTS AND TIMES LISTS NOT THE SAME SIZE!\n"
							+ "Something must be wrong with the code :(");
			}			
		});
	}

	
	//display results to the screen
	public void displayStats (Stage st, Scene scene, Text [] text) {
		mainMenu.getChildren().clear();
		mainMenu.getChildren().addAll(background, shine, exit);
		mainMenu.getChildren().addAll(text);
		
		makeResultText(text);	
		//format text on the screen
		
		if (IAT) {
			for (int i = 0; i < 6; i++) {
				edit(text[i], -200, (20*(i+1))-240, text[i].getScaleX(), text[i].getScaleY());
				if (i == 1)
					edit(text[i], text[i].getTranslateX(), -230, text[i].getScaleX(), text[i].getScaleY());
				if (i == 2) {
					edit(text[i], text[i].getTranslateX(), text[i].getTranslateY()+20, text[i].getScaleX(), text[i].getScaleY());
				}
				if (i > 2 && i != 6)
					edit(text[i], text[i].getTranslateX(), (20*(i+1))-220, text[i].getScaleX(), text[i].getScaleY());
				if (i == 6) {
					edit(text[i], text[i].getTranslateX(), (20*(i+1))-220, text[i].getScaleX(), text[i].getScaleY());
				}
					
			}
			edit(text[6], 180, -240, text[6].getScaleX(), text[6].getScaleY());
			edit(text[7], 178, -30, text[7].getScaleX(), text[7].getScaleY());
		}
		
		else if (LAM) {
			for (int i = 0; i < text.length; i++) {
				edit(text[i], 0, (25*(i+1))-250, text[i].getScaleX(), text[i].getScaleY());
			}
		}
		else
			displayErrorMessage("uwu");
		
	}
	
	//render error message to the screen, if something goes wrong
	public void displayErrorMessage (String str) {
		mainMenu.getChildren().clear();
		mainMenu.getChildren().addAll(background, shine, exit);
		error.setText(str);
		makeText(error);
		edit(error, 0, 0, 0.8, 0.8);
		mainMenu.getChildren().add(error);	
	}
	
	
	public void restart (Stage st) {
		mainMenu.getChildren().clear();
		exit.setText("Close");
		start(st);
	}
	
	
	//MAIN METHOD
	public static void main (String [] args) {
		launch();
	}

	
	
	
//end of class
}

