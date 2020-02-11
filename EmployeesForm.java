import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class EmployeesForm extends Application{

	private TextArea txtArea = new TextArea();
	private Button btnNew = new Button("New");
	private Button btnSave = new Button("Save");
	private TextField txtName = new TextField();
	private TextField txtSalary = new TextField();
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane border = new BorderPane();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setHgap(8);
		grid.setVgap(8);
		grid.add(new Label("Employee Name:"), 0, 0);
		grid.add(txtName, 1, 0);
		grid.add(new Label("Salry($):"), 0, 1);
		grid.add(txtSalary, 1, 1);
		
		grid.add(btnNew, 2, 0);
		grid.add(btnSave, 2, 1);
		
		btnSave.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				try {
					DatabaseAPI db = new DatabaseAPI();
					String name = txtName.getText();
					double salary = Double.parseDouble(txtSalary.getText());
					
					String sql = "Insert into employees(name, salary) values('" +
					name + "', " + salary + ")";
					db.write(sql);
					refresh();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}

			
		});
		
		
		border.setPadding(new Insets(10));
		border.setTop(grid);
		border.setCenter(txtArea);
		Scene scene = new Scene(border, 340, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Employees Form");
		primaryStage.show();
		
		refresh();
		
	}
	public static void main(String[] args) {
		Application.launch(args);

	}
	
	private void refresh() {
		try {
			DatabaseAPI db = new DatabaseAPI();
			String sql = "Select * from employees";
			
			ResultSet result = db.read(sql);
			String emps = "";
			while(result.next()){
				emps+= result.getString(1) + "\t" + result.getString(2) + 
						"\t" + result.getString(3) + "\n";
			}
			txtArea.setText(emps);
			db.connection.close();
			db.connection = null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}