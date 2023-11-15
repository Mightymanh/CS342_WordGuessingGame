import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class InitController implements Initializable {



    @FXML
    Label title;

    @FXML
    Button confirm;

    @FXML
    Label prompt;

    @FXML
    TextField portBox;

    @FXML
    VBox root;

    public Client client;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addEvents();



    }

    public void addEvents(){
        confirm.setOnAction((e)->{
           // portNumberEnter();
            try{
                CategoryScene();
            } catch (Exception error) {
                System.out.println("failed to change scene");
                error.printStackTrace();
            }

        });
    }

    public void portNumberEnter(){

        String portNum = portBox.getText();
        int portNumber;
        try {
            portNumber = Integer.parseInt(portNum);


        } catch (Exception e) {
            prompt.setText("Invalid port number. Try again");
            return;
        }

        if(!client.connect(portNumber)) {
            prompt.setText("Connection failed. Try again");
            return;
        }


        prompt.setText(portNum);
    }



    public void setClient(Client theClient){
        this.client = theClient;
    }

    public void CategoryScene() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Category.fxml"));
        Parent Catroot = fxmlLoader.load();
        CategoryController controller = fxmlLoader.<CategoryController>getController();

        root.getScene().setRoot(Catroot);

    }


}