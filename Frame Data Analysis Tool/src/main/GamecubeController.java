package main;

import java.util.LinkedList;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class GamecubeController extends Main {
	
	//Controller Button Shapes
	Circle a = new Circle(30, Color.GREEN);
	Circle b = new Circle(20, Color.RED);
	Circle x = new Circle(25, Color.GREY);
	Circle y = new Circle(25, Color.GREY);
	Rectangle l = new Rectangle(40, 20, Color.GREY);
	Rectangle r = new Rectangle(40, 20, Color.GREY);
	Circle joy1 = new Circle (40, Color.GREY);
	Rectangle up = new Rectangle(25, 25, Color.GREY);
	Rectangle down = new Rectangle(25, 25, Color.GREY);
	Rectangle left = new Rectangle(25, 25, Color.GREY);
	Rectangle right = new Rectangle(25, 25, Color.GREY);
	Rectangle z = new Rectangle(30, 15, Color.BLUE);
	Circle start = new Circle(10, Color.GREY);
	Circle joyC = new Circle (30, Color.YELLOW);

	LinkedList<String> inputs = new LinkedList<String>();
	LinkedList<Integer> times = new LinkedList<Integer>();
	
	
	public GamecubeController () {
	}
	
	public void setUpCShape (Shape button, double a, double b, double c) {
		button.setOpacity(a);
		button.setTranslateX(b);
		button.setTranslateY(c);
	}
	
	//IAT METHODS
	public LinkedList<String> getInputList () {
		return inputs;
	}
	
	public double getIPM (long stopRecTime, long startRecTime) {
		long recordingTimeMillis = stopRecTime - startRecTime;
		double recordingTimeMinutes = ((double)(recordingTimeMillis/1000))/60;
		long numInputs = inputs.size();
		return (numInputs/recordingTimeMinutes);
	}
	
	public double getIPS (long stopRecTime, long startRecTime) {
		long recordingTimeMillis = stopRecTime - startRecTime;
		double recordingTimeSecs = (double)(recordingTimeMillis/1000);
		long numInputs = inputs.size();
		return (numInputs/recordingTimeSecs);
	}
	
	public Integer [] getNumOfEachInput () {
		Integer [] count = new Integer[28];
		for (int i = 0; i < count.length; i++) 
			count[i] = 0;
		
		for (int i = 0; i < inputs.size(); i++) {
			switch (inputs.get(i)) {
			case "A":
				count[0]++; break;
			case "B":
				count[1]++; break;
			case "X":
				count[2]++; break;
			case "Y":
				count[3]++; break;
			case "L":
				count[4]++; break;
			case "R":
				count[5]++; break;
			case "D-Pad Up":
				count[6]++; break;
			case "D-Pad Down":
				count[7]++; break;
			case "D-Pad Left":
				count[8]++; break;
			case "D-Pad Right":
				count[9]++; break;
			case "Z":
				count[10]++; break;
			case "Start":
				count[11]++; break;
			case "A.L":
				count[12]++; break;
			case "A.UL":
				count[13]++; break;
			case "A.U":
				count[14]++; break;
			case "A.UR":
				count[15]++; break;
			case "A.R":
				count[16]++; break;
			case "A.DR":
				count[17]++; break;
			case "A.D":
				count[18]++; break;
			case "A.DL":
				count[19]++; break;
			case "C.L":
				count[20]++; break;
			case "C.UL":
				count[21]++; break;
			case "C.U":
				count[22]++; break;
			case "C.UR":
				count[23]++; break;
			case "C.R":
				count[24]++; break;
			case "C.DR":
				count[25]++; break;
			case "C.D":
				count[26]++; break;
			case "C.DL":
				count[27]++; break;
			}
		}
		return count;
	}
	
	
	
	//LAM METHODS
	public static int convertFrames (long millis) {
		return (int)(millis*0.06);
	}
	
	public LinkedList<Integer> getTimes () {
		return times;
	}
	
	public Integer [] differences(Integer [] ledgedashInputs, String ch) {
		Integer [] differences = new Integer [4];
		differences[0] = 0;
		
		//idk if my math is right :\ (all values in "differences" array should be 0 if ledgedash was frame-perfect)
		int startFrame = ledgedashInputs[0];

		if (ch == "Fox") {
			differences[1] = ledgedashInputs[1] - startFrame - 1; //frame 2
			differences[2] = ledgedashInputs[2] - startFrame - 4; //frame 5
			differences[3] = ledgedashInputs[3] - startFrame - 5; //frame 6
			return differences;
		}
		if (ch == "Falco") {
			/*differences[1] = ledgedashInputs[1] - startFrame - 1; //frame 2
			differences[2] = ledgedashInputs[2] - startFrame - ;
			differences[3] = ledgedashInputs[3] - startFrame - ;*/	
			return differences;
		}
		else {
			/*differences[1] = ledgedashInputs[1] - startFrame - 1; //frame 2
			differences[2] = ledgedashInputs[2] - startFrame - ;
			differences[3] = ledgedashInputs[3] - startFrame - ;*/	
			return differences;
		}
	}
	
	
	
	//display buttons
	public void activateController (boolean display) {
		if (display == true) {
			setUpCShape(a, 0.25, 0.0, 0.0);
			setUpCShape(b, 0.25, -40, 20);
			setUpCShape(x, 0.25, 50, 0);
			setUpCShape(y, 0.25, 0, -50);
			setUpCShape(l, 0.25, -180, -100);
			setUpCShape(r, 0.25, 0, -130);
			setUpCShape(z, 0.25, 0, -100);
			setUpCShape(start, 0.25, -90, -20);
			setUpCShape(joy1, 0.75, -180, 0);
			setUpCShape(joyC, 0.5, -20, 80);	
			setUpCShape(up, 0.25, -120, 60);
			setUpCShape(down, 0.25, -120, 110);
			setUpCShape(left, 0.25, -145, 85);
			setUpCShape(right, 0.25, -95, 85);				
		}
	}
	
	
	
	
	//IAT - making the buttons move, and record inputs to an ArrayList
	public void generateControllerGUIAndCountInputs (Scene scene) {
		long recTime = System.currentTimeMillis();
		//PRESS
				scene.setOnKeyPressed(e -> { 
					//Buttons
					if (e.getCode().equals(KeyCode.P) && a.getOpacity() == 0.25)	{	
						a.setOpacity(1.0);
						inputs.add("A");	
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.O) && b.getOpacity() == 0.25)	{	
						b.setOpacity(1.0);
						inputs.add("B");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.K) && x.getOpacity() == 0.25)	{	
						x.setOpacity(1.0);
						inputs.add("X");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.DIGIT0) && y.getOpacity() == 0.25)	{	
						y.setOpacity(1.0);
						inputs.add("Y");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.L) && l.getOpacity() == 0.25)	{	
						l.setOpacity(1.0);
						inputs.add("L");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.G) && r.getOpacity() == 0.25)	{	
						r.setOpacity(1.0);
						inputs.add("R");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.DIGIT1) && up.getOpacity() == 0.25)	{	
						up.setOpacity(1.0);
						inputs.add("D-Pad Up");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.DIGIT2) && down.getOpacity() == 0.25)	{	
						down.setOpacity(1.0);
						inputs.add("D-Pad Down");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.DIGIT3) && left.getOpacity() == 0.25)	{	
						left.setOpacity(1.0);
						inputs.add("D-Pad Left");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.DIGIT4) && right.getOpacity() == 0.25)	{	
						right.setOpacity(1.0);
						inputs.add("D-Pad Right");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.S) && z.getOpacity() == 0.25)	{	
						z.setOpacity(1.0);
						inputs.add("Z");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.SEMICOLON) && start.getOpacity() == 0.25)	{	
						start.setOpacity(1.0);
						inputs.add("Start");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					//analog stick
					if (e.getCode().equals(KeyCode.A) && joy1.getTranslateX() == -180)	{	
						joy1.setTranslateX(-200);
						inputs.add("A.L");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.Q) && joy1.getTranslateX() == -180 && joy1.getTranslateY() == 0)	{	
						joy1.setTranslateX(-200);
						joy1.setTranslateY(-20);
						inputs.add("A.UL");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.W) && joy1.getTranslateY() == 0)	{	
						joy1.setTranslateY(-20);
						inputs.add("A.U");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}		
					if (e.getCode().equals(KeyCode.E) && joy1.getTranslateX() == -180 && joy1.getTranslateY() == 0)	{	
						joy1.setTranslateX(-160);
						joy1.setTranslateY(-20);
						inputs.add("A.UR");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.D) && joy1.getTranslateX() == -180)	{	
						joy1.setTranslateX(-160);
						inputs.add("A.R");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.C) && joy1.getTranslateX() == -180 && joy1.getTranslateY() == 0)	{	
						joy1.setTranslateX(-160);
						joy1.setTranslateY(20);
						inputs.add("A.DR");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.X) && joy1.getTranslateY() == 0)	{	
						joy1.setTranslateY(20);
						inputs.add("A.D");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.Z) && joy1.getTranslateX() == -180 && joy1.getTranslateY() == 0)	{	
						joy1.setTranslateX(-200);
						joy1.setTranslateY(20);
						inputs.add("A.DL");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					//C-Stick
					if (e.getCode().equals(KeyCode.F) && joyC.getTranslateX() == -20) {
						joyC.setTranslateX(-40);
						inputs.add("C.L");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.R) && joyC.getTranslateX() == -20 && joyC.getTranslateY() == 80) {
						joyC.setTranslateX(-40);
						joyC.setTranslateY(60);
						inputs.add("C.UL");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.T) && joyC.getTranslateY() == 80) {
						joyC.setTranslateY(60);
						inputs.add("C.U");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.Y) && joyC.getTranslateX() == -20 && joyC.getTranslateY() == 80) {
						joyC.setTranslateX(0);
						joyC.setTranslateY(60);
						inputs.add("C.UR");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.H) && joyC.getTranslateX() == -20) {
						joyC.setTranslateX(0);
						inputs.add("C.R");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.N) && joyC.getTranslateX() == -20 && joyC.getTranslateY() == 80) {
						joyC.setTranslateX(0);
						joyC.setTranslateY(100);
						inputs.add("C.DR");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.B) && joyC.getTranslateY() == 80) {
						joyC.setTranslateY(100);
						inputs.add("C.D");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					if (e.getCode().equals(KeyCode.V) && joyC.getTranslateX() == -20 && joyC.getTranslateY() == 80) {
						joyC.setTranslateX(-40);
						joyC.setTranslateY(100);
						inputs.add("C.DL");
						times.add(convertFrames(System.currentTimeMillis() - recTime));	
					}
					
					
				});	
				//RELEASE
				scene.setOnKeyReleased(e -> {
					//Buttons
					if (e.getCode().equals(KeyCode.P) && a.getOpacity() == 1.0)	{	
						a.setOpacity(0.25);
					}
					if (e.getCode().equals(KeyCode.O) && b.getOpacity() == 1.0)	{	
						b.setOpacity(0.25);
					}
					if (e.getCode().equals(KeyCode.K) && x.getOpacity() == 1.0)	{	
						x.setOpacity(0.25);
					}
					if (e.getCode().equals(KeyCode.DIGIT0) && y.getOpacity() == 1.0)	{	
						y.setOpacity(0.25);
					}
					if (e.getCode().equals(KeyCode.L) && l.getOpacity() == 1.0)	{	
						l.setOpacity(0.25);
					}
					if (e.getCode().equals(KeyCode.G) && r.getOpacity() == 1.0)	{	
						r.setOpacity(0.25);
					}
					if (e.getCode().equals(KeyCode.DIGIT1) && up.getOpacity() == 1.0)	{	
						up.setOpacity(0.25);
					}
					if (e.getCode().equals(KeyCode.DIGIT2) && down.getOpacity() == 1.0)	{	
						down.setOpacity(0.25);
					}
					if (e.getCode().equals(KeyCode.DIGIT3) && left.getOpacity() == 1.0)	{	
						left.setOpacity(0.25);
					}
					if (e.getCode().equals(KeyCode.DIGIT4) && right.getOpacity() == 1.0)	{	
						right.setOpacity(0.25);
					}
					if (e.getCode().equals(KeyCode.S) && z.getOpacity() == 1.0)	{	
						z.setOpacity(0.25);
					}
					if (e.getCode().equals(KeyCode.SEMICOLON) && start.getOpacity() == 1.0)	{	
						start.setOpacity(0.25);
					}
					//analog stick
					if (e.getCode().equals(KeyCode.A) && joy1.getTranslateX() != -180)	{	
						joy1.setTranslateX(-180);
					}
					if (e.getCode().equals(KeyCode.Q) && joy1.getTranslateX() != -180 && joy1.getTranslateY() != 0)	{	
						joy1.setTranslateX(-180);
						joy1.setTranslateY(0);
					}
					if (e.getCode().equals(KeyCode.W) && joy1.getTranslateY() != 0)	{	
						joy1.setTranslateY(0);
					}
					if (e.getCode().equals(KeyCode.E) && joy1.getTranslateX() != -180 && joy1.getTranslateY() != 0)	{	
						joy1.setTranslateX(-180);
						joy1.setTranslateY(0);
					}
					if (e.getCode().equals(KeyCode.D) && joy1.getTranslateX() != -180)	{	
						joy1.setTranslateX(-180);
					}
					if (e.getCode().equals(KeyCode.C) && joy1.getTranslateX() != -180 && joy1.getTranslateY() != 0)	{	
						joy1.setTranslateX(-180);
						joy1.setTranslateY(0);
					}
					if (e.getCode().equals(KeyCode.X) && joy1.getTranslateY() != 0)	{	
						joy1.setTranslateY(0);
					}
					if (e.getCode().equals(KeyCode.Z) && joy1.getTranslateX() != -180 && joy1.getTranslateY() != 0)	{	
						joy1.setTranslateX(-180);
						joy1.setTranslateY(00);
					}
					//C-stick
					if (e.getCode().equals(KeyCode.F) && joyC.getTranslateX() == -40) {
						joyC.setTranslateX(-20);
					}
					if (e.getCode().equals(KeyCode.R) && joyC.getTranslateX() == -40 && joyC.getTranslateY() == 60) {
						joyC.setTranslateX(-20);
						joyC.setTranslateY(80);
					}
					if (e.getCode().equals(KeyCode.T) && joyC.getTranslateY() == 60) {
						joyC.setTranslateY(80);
					}
					if (e.getCode().equals(KeyCode.Y) && joyC.getTranslateX() == 0 && joyC.getTranslateY() == 60) {
						joyC.setTranslateX(-20);
						joyC.setTranslateY(80);
					}
					if (e.getCode().equals(KeyCode.H) && joyC.getTranslateX() == 0) {
						joyC.setTranslateX(-20);
					}
					if (e.getCode().equals(KeyCode.N) && joyC.getTranslateX() == 0 && joyC.getTranslateY() == 100) {
						joyC.setTranslateX(-20);
						joyC.setTranslateY(80);
					}
					if (e.getCode().equals(KeyCode.B) && joyC.getTranslateY() == 100) {
						joyC.setTranslateY(80);
					}
					if (e.getCode().equals(KeyCode.V) && joyC.getTranslateX() == -40 && joyC.getTranslateY() == 100) {
						joyC.setTranslateX(-20);
						joyC.setTranslateY(80);
					}
				});			
	}
}
