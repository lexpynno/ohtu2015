
package ohtu.verkkokauppa;

import java.util.ArrayList;

/**
 *
 * @author Leo
 */
public interface KirjanpitoInterface {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
}
