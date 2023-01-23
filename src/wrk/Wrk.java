package wrk;

import ctrl.ICtrlWrk;

public class Wrk implements IWrkCtrl {

    public Wrk() {
        refCtrl = null;
    }

    @Override
    public int additionne( int a, int b ) {
        return a + b;
    }

    public void setRefCtrl( ICtrlWrk refCtrl ) {
        this.refCtrl = refCtrl;
    }

    public ICtrlWrk getRefCtrl() {
        return refCtrl;
    }

    private ICtrlWrk refCtrl;
}
