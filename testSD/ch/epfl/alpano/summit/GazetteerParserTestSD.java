package ch.epfl.alpano.summit;

/**
 * 
 * @author Samuel Chassot (270955)
 * @author Daniel Filipe Nunes Silva (275197)
 *
 */

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class GazetteerParserTestSD {

    File file = new File("alps.txt");
    
    @Test
    public void test() throws IOException {
        List<Summit> summitsList = GazetteerParser.readSummitsFrom(file);
        
        assertEquals("MONTE CURT (7.4200,45.1403) 1325", summitsList.get(0).toString());
        assertEquals("LE MOLESON (7.0172,46.5489) 2002", summitsList.get(6203).toString());
        
    }

}