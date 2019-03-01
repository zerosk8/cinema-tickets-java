package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

public class Geldbetrag_v2 {

	double _nummer;
	
	public Geldbetrag_v2()
	{
	    _nummer = 0;
	}
	
	public Geldbetrag_v2(String betrag)
	{
	    if(betrag.contains(","))
	    {
	        betrag = betrag.replaceFirst(",",".");
	    }
	    
	    _nummer = Double.valueOf(betrag);
	}
	
	public String toString()
	{
	    return String.valueOf(_nummer);
	}
	
	/**
	 * adds one Geldbetrag to another
	 * @param geld
	 * @return Geldbetrag
	 */
	public Geldbetrag_v2 add(Geldbetrag_v2 geldbetrag)
	{
	    String ergebnis;
	    ergebnis = String.valueOf(_nummer + geldbetrag._nummer);
		return new Geldbetrag_v2(ergebnis);
	}

	/**
	 * subtracts one geldbterag from the other
	 * @param geld
	 * @return Geldbetrag
	 */
	public Geldbetrag_v2 substrahiere(Geldbetrag_v2 geldbetrag)
	{
	    String ergebnis;
	    ergebnis = String.valueOf(_nummer - geldbetrag._nummer);
        return new Geldbetrag_v2(ergebnis);
	}
	
	/**
	 * multiplies e geldbetrag and number (digit from Z)
	 * 
	 * @param  Int number
	 * @return Geldbetrag
	 */
	
	public Geldbetrag_v2 multipliziere(int konstant)
	{
	    String ergebnis;
	    ergebnis = String.valueOf(_nummer * konstant);
        return new Geldbetrag_v2(ergebnis);
	}
	
	/**
	 * converts String to Geldbetrag, possibly useful 4 reading incoming information from JTextField
	 * @param String s
	 * @return Geldbetrag geld
	 */
	public static Geldbetrag_v2 convertFromStringToGeldbetrag(String betrag)
	{
	    return new Geldbetrag_v2(betrag);
	}
	
	@Override
	public boolean equals(Object obj)
	{
	    boolean ergebnis = false;
	    
        if(obj instanceof Geldbetrag_v2 && _nummer == ((Geldbetrag_v2)(obj))._nummer)
        {
            ergebnis = true;
        }
	    
	    return ergebnis;
	}
	
	/**
	 * converts Integer to Geldbetrag
	 * @param int i
	 * @return Geldbetrag
	 */
	public static Geldbetrag_v2 convertFromStringToGeldbetrag(int betrag)
	{
	    return new Geldbetrag_v2(String.valueOf(betrag));
	}
}
