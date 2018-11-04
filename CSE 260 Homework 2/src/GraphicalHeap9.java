//Tian Brown, 111597217

import java.util.ArrayList;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GraphicalHeap9 extends Application {
	
	Heap8<Integer> heap = new Heap8<Integer>();
	ArrayList<Circle> nodes = new ArrayList<>();
	ArrayList<Text> text = new ArrayList<>();
	//boolean hasLeftChild = false;
	
	
	
	//start method
	public void start (Stage st) {
		StackPane pane = new StackPane();
		Scene sc = new Scene(pane, 1520, 780, Color.WHITE);
		st.setTitle("Graphical Representation of a Heap");
		st.setResizable(false);
		
		//add numbers to the heap
		for (int i = 1; i <= 15; i++) {
			heap.add(i);
		}

		//print the now randomized heap
		for (int i = 0; i < heap.getSize(); i++) {
			System.out.print(heap.list.get(i) + " ");
		}
		System.out.println();
		System.out.println("Heap size: " + heap.getSize());
	
	
		//create list of nodes from the heap
		for (int i = 0; i < heap.getSize(); i++) {
			nodes.add(new Circle(40, Color.GREEN));
			nodes.get(i).setStroke(Color.BLACK);
			nodes.get(i).setStrokeWidth(3.0);
		}
		
		//create text for the nodes, showing their values
		for (int i = 0; i < heap.getSize(); i++) {
			text.add(new Text(Integer.toString(heap.list.get(i))));
			text.get(i).setScaleX(3.0);
			text.get(i).setScaleY(3.0);
		}
		
		pane.getChildren().add(nodes.get(0));
		nodes.get(0).setTranslateY(-300);
		pane.getChildren().add(text.get(0));
		text.get(0).setTranslateY(-300);
		

		
		for (int i = 1; i < heap.getSize(); i++) {
			
			if (i == 1) {
				pane.getChildren().add(nodes.get(i));
				pane.getChildren().add(text.get(i));
				nodes.get(i).setTranslateY(-150);
				text.get(i).setTranslateY(-150);
				nodes.get(i).setTranslateX(-150);			
				text.get(i).setTranslateX(-150);
				//hasLeftChild = true;
			}
			if (i == 2) {
				pane.getChildren().add(nodes.get(i));
				pane.getChildren().add(text.get(i));
				setUpTree(i);
			}
			if (i == 3) {
				pane.getChildren().add(nodes.get(i));
				pane.getChildren().add(text.get(i));
				setUpTree(i);
			}
			

		}
		
		
		
		
		
		
		
		
		st.setScene(sc);
		st.show();
		
		
	}
//main method, launches program
	public static void main(String[] args) {
		launch();

	}
	
	public void setUpTree(int i) {
		nodes.get(i).setTranslateY(-150*(i-1));
		text.get(i).setTranslateY(-150*(i-1));
		if (Integer.parseInt(text.get(i).getText()) > Integer.parseInt(text.get(i-1).getText())) {
			nodes.get(i).setTranslateX(150);
			text.get(i).setTranslateX(150);
		}
		nodes.get(i).setTranslateX(-150);
		text.get(i).setTranslateX(-150);
		nodes.get(i-1).setTranslateX(-1*nodes.get(i-1).getTranslateX());
		text.get(i-1).setTranslateX(-1*text.get(i-1).getTranslateX());
	}

}
