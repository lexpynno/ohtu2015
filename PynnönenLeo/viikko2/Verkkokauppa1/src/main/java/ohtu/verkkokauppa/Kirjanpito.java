
package ohtu.verkkokauppa;

import java.util.ArrayList;

public class Kirjanpito implements KirjanpitoInterface {

    private ArrayList<String> tapahtumat;

    private Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }

    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }
}
