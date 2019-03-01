package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeldbetragTest {
	
	@Test
    public void testAddieren()
    {
		Geldbetrag geld1 = new Geldbetrag(new String("4,5"));
		Geldbetrag geld2 = new Geldbetrag("6,0");
		Geldbetrag geld3 = new Geldbetrag(new String("10,5"));
		
		geld1 = geld1.addieren(geld2);
		
		assertEquals(geld1, geld3);
	}

	@Test
    public void testSubstrahieren()
    {
	    Geldbetrag geld1 = new Geldbetrag("6,0");
		Geldbetrag geld2 = new Geldbetrag("4,3");
		Geldbetrag geld3 = new Geldbetrag("1,7");
		
		geld1 = geld1.substrahieren(geld2);
		
		assertEquals(geld1, geld3);
	}
	
	@Test
    public void testMultiplizieren()
    {
	    int number = 3;
		Geldbetrag geld1 = new Geldbetrag("4,5");
		Geldbetrag geld2 = new Geldbetrag("13,5");
		
		geld1 = geld1.multiplizieren(number);
		
		assertEquals(geld1, geld2);
	}

	@Test
    public void testKonvertierenVonStringNachGeldbetrag()
    {
		String s = "20,56";
		Geldbetrag geld1 = new Geldbetrag();
		Geldbetrag geld2 = new Geldbetrag("20,56");
		
		geld1 = Geldbetrag.konvertierenVonStringNachGeldbetrag(s);
		
		assertEquals(geld1, geld2);
	}
	
	@Test
    public void testKonvertierenVonIntNachGeldbetrag()
    {
		int i = 3;
		Geldbetrag geld1 = new Geldbetrag();
		Geldbetrag geld2 = new Geldbetrag("3,00");
		
		geld1 = Geldbetrag.konvertierenVonIntNachGeldbetrag(i);
		
		assertEquals(geld1, geld2);
	}
	
	@Test
    public void testToString()
    {
        Geldbetrag geld1 = new Geldbetrag();
        Geldbetrag geld2 = new Geldbetrag("11811");
        Geldbetrag geld3 = new Geldbetrag("35,00");
        Geldbetrag geld4 = new Geldbetrag("3,5");
        Geldbetrag geld5 = new Geldbetrag("4,0");
        Geldbetrag geld6 = new Geldbetrag("40,07");
        Geldbetrag geld7 = new Geldbetrag(120);
        
        assertEquals(geld1.toString(), "00,00");
        assertEquals(geld2.toString(), "11811,00");
        assertEquals(geld3.toString(), "35,00");
        assertEquals(geld4.toString(), "03,50");
        assertEquals(geld5.toString(), "04,00");
        assertEquals(geld6.toString(), "40,07");
        assertEquals(geld7.toString(), "120,00");
    }
	
	@Test
	public void testVergleich()
	{
	    Geldbetrag geld1 = new Geldbetrag(34);
	    Geldbetrag geld2 = new Geldbetrag("12,10");
	    Geldbetrag geld3 = new Geldbetrag("100,09");
	    Geldbetrag geld4 = new Geldbetrag("34");
	    
	    assertTrue(geld1.equals(geld4));
	    
	    assertTrue(geld3.istGroesserAls(geld2));
	    assertTrue(geld3.istGroesserOderGleichAls(geld2));
	    assertTrue(geld3.istGroesserOderGleichAls(geld3));
	    
	    assertTrue(geld2.istKleinerAls(geld3));
	    assertTrue(geld2.istKleinerOderGleichAls(geld3));
	    assertTrue(geld2.istKleinerOderGleichAls(geld2));
	}
}
