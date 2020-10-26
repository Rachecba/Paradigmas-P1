
package proyecto;


public class TablaVerdad {

    private boolean p[]={true,true,true,true,false,false,false,false};
    private boolean q[]={true,true,false,false,true,true,false,false};
    private boolean r[]={true,false,true,false,true,false,true,false};

    public boolean[] getP() {
        return p;
    }

    public void setP(boolean[] p) {
        this.p = p;
    }

    public boolean[] getQ() {
        return q;
    }

    public void setQ(boolean[] q) {
        this.q = q;
    }

    public boolean[] getR() {
        return r;
    }

    public void setR(boolean[] r) {
        this.r = r;
    }
    
}
