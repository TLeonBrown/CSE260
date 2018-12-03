package main;

import java.util.ArrayList;

public class InputRecorder extends Main {
	
	ArrayList<String> inputList = new ArrayList<String>();
	
	//default constructor
	public InputRecorder () { }
	
	//adds a new input to the player's input list
	public void add (String input) {
		inputList.add(input);
	}
	
	//returns all inputs recorded in an ArrayList
	public ArrayList<String> getInputs () {
		return inputList;
	}
	
	//inputs per minute
	public double inputsPerMinute () {
		long recordingTimeMillis = stopRecTime - startRecTime;
		long recordingTimeMinutes = (recordingTimeMillis/1000)/60;
		long numInputs = inputList.size();
		return (numInputs/recordingTimeMinutes);
	}
	
	//inputs per second
	public double inputsPerSecond () {
		long recordingTimeMillis = stopRecTime - startRecTime;
		long recordingTimeSecs = (recordingTimeMillis/1000);
		long numInputs = inputList.size();
		return (numInputs/recordingTimeSecs);
	}
	
	/* 0 = X, 1 = A, 2 = B, 3 = Y, 4 = L, 5 = R, 7 = Z, 9 = Start*/ 
	
	//return number of each input in an array of integers
	public Integer [] numOfEachInput () {
		Integer [] counter = new Integer [10];
		
		for (int i = 0; i < inputList.size(); i++) {
			switch (inputList.get(i)) {
			case "X":
				counter[0]++; break;
			case "A":
				counter[1]++; break;
			case "B":
				counter[2]++; break;
			case "Y":
				counter[3]++; break;
			case "L":
				counter[4]++; break;
			case "R":
				counter[5]++; break;
			case "Z":
				counter[7]++; break;
			case "Start":
				counter[9]++; break;			
			}
		}
		return counter;
	}
}
