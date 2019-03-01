package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

public class Geldbetrag {

    private int _betrag;
    
    public Geldbetrag()
    {
        _betrag = 0;
    }
    
    public Geldbetrag(String betrag)
    {
        if(betrag.indexOf(',') != -1)
        {
            String [] temp = betrag.split(",");
            int euroAnteil = Integer.valueOf(temp[0]);
            int centAnteil = Integer.valueOf(temp[1]);
            
            if(temp[1].length() == 1)
            {
                if(euroAnteil >= 0)
                {
                    _betrag = euroAnteil * 100 + centAnteil * 10;
                }
                else
                {
                    _betrag = euroAnteil * 100 - centAnteil * 10;
                }
            }
            else
            {
                if(euroAnteil >= 0)
                {
                    _betrag = euroAnteil * 100 + centAnteil;
                }
                else{
                    _betrag = euroAnteil * 100 - centAnteil;
                }
            }
        }
        else
        {
            _betrag = Integer.valueOf(betrag) * 100;
        }
    }
    
    public Geldbetrag(int betrag)
    {
        _betrag = betrag * 100;
    }
    
    public Geldbetrag(Geldbetrag geldbetrag)
    {
        _betrag = geldbetrag._betrag;
    }
    
    /**
     * adds one Geldbetrag to another
     * @param geld
     * @return Geldbetrag
     */
    public Geldbetrag addieren(Geldbetrag geldbetrag)
    {
        int euroAnteil = (_betrag + geldbetrag._betrag) / 100;
        int centAnteil = (_betrag + geldbetrag._betrag) % 100;
        
        return new Geldbetrag(new String(euroAnteil + "," + centAnteil));
    }

    /**
     * subtracts one geldbterag from the other
     * @param geld
     * @return Geldbetrag
     */
    public Geldbetrag substrahieren(Geldbetrag geldbetrag)
    {
        int euroAnteil = (_betrag - geldbetrag._betrag) / 100;
        int centAnteil = (_betrag - geldbetrag._betrag) % 100;
        
        if(centAnteil < 0)
        {
            centAnteil = centAnteil * (-1);
        }
        
        return new Geldbetrag(new String(euroAnteil + "," + centAnteil));
    }
    
    /**
     * multiplies e geldbetrag and number (digit from Z)
     * 
     * @param  Int number
     * @return Geldbetrag
     */
    
    public Geldbetrag multiplizieren(int konstant)
    {
        int euroAnteil = (_betrag * konstant) / 100;
        int centAnteil = (_betrag * konstant) % 100;
        
        return new Geldbetrag(new String(euroAnteil + "," + centAnteil));
    }
    
    @Override
    public boolean equals(Object obj)
    {
        boolean ergebnis = false;
        
        if(obj instanceof Geldbetrag && _betrag == ((Geldbetrag)(obj))._betrag)
        {
            ergebnis = true;
        }
        
        return ergebnis;
    }
    
    public boolean istGroesserAls(Object obj)
    {
        boolean ergebnis = false;
        
        if(obj instanceof Geldbetrag && _betrag > ((Geldbetrag)(obj))._betrag)
        {
            ergebnis = true;
        }
        
        return ergebnis;
    }
    
    public boolean istGroesserOderGleichAls(Object obj)
    {
        boolean ergebnis = false;
        
        if(obj instanceof Geldbetrag && _betrag >= ((Geldbetrag)(obj))._betrag)
        {
            ergebnis = true;
        }
        
        return ergebnis;
    }
    
    public boolean istKleinerAls(Object obj)
    {
        boolean ergebnis = false;
        
        if(obj instanceof Geldbetrag && _betrag < ((Geldbetrag)(obj))._betrag)
        {
            ergebnis = true;
        }
        
        return ergebnis;
    }
    
    public boolean istKleinerOderGleichAls(Object obj)
    {
        boolean ergebnis = false;
        
        if(obj instanceof Geldbetrag && _betrag <= ((Geldbetrag)(obj))._betrag)
        {
            ergebnis = true;
        }
        
        return ergebnis;
    }
    
    @Override
    public String toString()
    {
        int euroAnteil = _betrag / 100;
        int centAnteil = _betrag % 100;
        String anzeigtEuro, anzeigtCent;
        
        if(euroAnteil >= 0 && euroAnteil < 10)
        {
            anzeigtEuro = new String("0" + euroAnteil);
        }
        else
        {
            anzeigtEuro = new String(euroAnteil + "");
        }
        
        if(centAnteil >= 0 && centAnteil < 10)
        {
            anzeigtCent = new String("0" + centAnteil);
        }
        else
        {
            if(centAnteil < 0)
            {
                centAnteil = centAnteil * (-1);
            }
            
            anzeigtCent = new String(centAnteil + "");
        }
        
        return new String(anzeigtEuro + "," + anzeigtCent);
    }
    
    /**
     * converts String to Geldbetrag, possibly useful 4 reading incoming information from JTextField
     * @param String s
     * @return Geldbetrag geld
     */
    public static Geldbetrag konvertierenVonStringNachGeldbetrag(String betrag)
    {
        return new Geldbetrag(betrag);
    }
    
    /**
     * converts Integer to Geldbetrag
     * @param int i
     * @return Geldbetrag
     */
    public static Geldbetrag konvertierenVonIntNachGeldbetrag(int betrag)
    {
        
        return new Geldbetrag(betrag);
    }
}
