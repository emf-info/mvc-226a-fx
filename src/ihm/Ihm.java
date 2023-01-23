package ihm;

import com.sun.javafx.application.PlatformImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Callback;
import ctrl.ICtrlIhm;
import javafx.scene.control.TextField;

/**
 * Cette classe représente l'Ihm principale l'application MVC.
 * <p>
 * Cette Ihm est en JavaFx. Le code qu'on trouve ci-dessous est donc celle du
 * "contrôleur de notre vue", vue dont le contenu est lui exprimé séparément en
 * FXML.
 *
 * @author EMF-Informatique
 */
public class Ihm implements Initializable, IIhmCtrl {

    public Ihm() {
        // Si vous avez une erreur "Location is not set" c'est que ce chemin est faux.
        fxml = "/ihm/Ihm.fxml";
        refCtrl = null;
    }

    @Override
    public void start() {
        /*
         * Callback pour le ControllerFactory, quand JavaFX voudra créer le
         * controlleur de vue, viendra dans ce callback et donnera l'instance
         * déjà créée au lieu d'en faire une nouvelle.
         */
        Callback<Class<?>, Object> controllerFactory = type -> {
            return this;
        };

        // Seulement si JDK <= 8 (il faudra faire un « fix imports » !)
        PlatformImpl.startup( () -> {
            // Seulement si JDK > 8 (il faudra faire un « fix imports » !), nouvelle méthode standardisée par Java
            // Platform.startup(() -> {       
            try {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource( fxml ) );
                fxmlLoader.setControllerFactory( controllerFactory );
                Parent root = ( Parent ) fxmlLoader.load();
                Scene scene = new Scene( root );
                stage.setScene( scene );
                stage.setTitle( "MVC-226a en JavaFX" );
                stage.show();
            }
            catch ( IOException ex ) {
                System.out.println( "Can't start the IHM because : " + ex );
                Platform.exit();
            }
        } );
    }

    @FXML
    private void addMe( ActionEvent event ) {
        refCtrl.additionne( Integer.parseInt( inputA.getText() ), Integer.parseInt( inputB.getText() ) );
    }

    @Override
    public void afficheVert( String message ) {
        label.setStyle( "-fx-text-fill: green;" );
        label.setText( message );
    }

    @Override
    public void afficheBleu( String message ) {
        label.setStyle( "-fx-text-fill: blue;" );
        label.setText( message );
    }

    @Override
    public void initialize( URL url, ResourceBundle rb ) {
        inputA.setText( "2" );
        inputB.setText( "5" );
    }

    public ICtrlIhm getRefCtrl() {
        return refCtrl;
    }

    public void setRefCtrl( ICtrlIhm refCtrl ) {
        this.refCtrl = refCtrl;
    }

    @FXML
    private Label label;
    @FXML
    private TextField inputA;
    @FXML
    private TextField inputB;

    private ICtrlIhm refCtrl;
    private final String fxml;

}
