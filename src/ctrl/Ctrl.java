package ctrl;

import ihm.IIhmCtrl;
import wrk.IWrkCtrl;

public class Ctrl implements ICtrlWrk, ICtrlIhm {

    public Ctrl() {
        refWrk = null;
        refIhm = null;
    }

    public void start() {
        refIhm.start();
    }

    @Override
    public void additionne( int a, int b ) {
        int result = refWrk.additionne( a, b );
        if ( result % 2 == 0 ) {
            refIhm.afficheVert( a + " + " + b + " = " + result );
        } else {
            refIhm.afficheBleu( a + " + " + b + " = " + result );
        }
    }

    public IIhmCtrl getRefIhm() {
        return refIhm;
    }

    public void setRefIhm( IIhmCtrl refIhm ) {
        this.refIhm = refIhm;
    }

    public IWrkCtrl getRefWrk() {
        return refWrk;
    }

    public void setRefWrk( IWrkCtrl refWrk ) {
        this.refWrk = refWrk;
    }

    private IWrkCtrl refWrk;
    private IIhmCtrl refIhm;
}
