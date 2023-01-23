package app;

import ctrl.Ctrl;
import ihm.Ihm;
import wrk.Wrk;

/**
 * Modèle d'application "MVC" réalisé avec interfaces avec ihm JavaFX.
 *
 * @author EMF-Informatique
 */
public class Application {

    public static void main( String[] args ) {
        Ihm ihm = new Ihm();
        Ctrl ctrl = new Ctrl();
        Wrk wrk = new Wrk();

        ctrl.setRefIhm( ihm );
        ctrl.setRefWrk( wrk );
        wrk.setRefCtrl( ctrl );
        ihm.setRefCtrl( ctrl );

        ctrl.start();
    }

}
