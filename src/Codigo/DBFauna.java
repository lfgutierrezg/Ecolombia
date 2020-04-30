package Codigo;

import java.io.File;

public class DBFauna {
    
    private String ScientificName;
    private String SampleName;    
    private String Filum;
    private String Classes;
    private String Order;
    private String Family;
    private String Gender;
    private String Ubication;    
    private String Ecosystem;
    private String Food;
    private String Depredator;
    
    

    public DBFauna(String scName, String sName, String tUbication, String tEcosystem, 
            String tFilum, String tClasses, String tOrder, String tFamily,String tGender, String tFood, String tDepredator) {
        
        this.SampleName = sName;
        this.Filum = tFilum;
        this.Classes = tClasses;
        this.Gender = tGender;
        this.Ubication = tUbication;
        this.Order=tOrder;
        this.Family=tFamily;
        this.ScientificName=scName;
        this.Ecosystem=tEcosystem;
        this.Food=tFood;
        this.Depredator=tDepredator;
    }
@Override
    public String toString() {
        return  ScientificName + "  "+ SampleName+ "  "+ Ubication + "  "+ Ecosystem+ "  "+ Filum+"  "+Classes + "  "+ Order+ "  "+ Family + "  "+ Gender+ "   "+Food+"    "+Depredator;
    }

   

    public String getSampleName() {
        return SampleName;
    }


    public String getFilum() {
        return Filum;
    }

    
    public String getClasses() {
        return Classes;
    }

    
    public String getGender() {
        return Gender;
    }

    
    public String getUbication() {
        return Ubication;
    }

    
    public String getOrder() {
        return Order;
    }
    
    public String getScName() {
        return ScientificName;
    }
    
    public String getFamily() {
        return Family;
    }
    
    public String getEcosystem() {
        return Ecosystem;
    }

    public String getFood() {
        return Food;
    }
    
     public String getDepredator() {
        return Depredator;
    }
    
}


