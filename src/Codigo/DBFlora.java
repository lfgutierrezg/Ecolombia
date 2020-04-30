package Codigo;

import java.io.File;

public class DBFlora {
    
    private String ScientificName;
    private String SampleName;    
    private String Filum;
    private String Classes;
    private String Order;
    private String Family;
    private String Gender;
    private String Specie;
    private String Ubication;    
    private String Ecosystem;
    
    

    public DBFlora(String scName, String sName, String tUbication, String tEcosystem, 
            String tFilum, String tClasses, String tOrder, String tFamily,String tGender,String tSpecie) {
        
        this.Specie = tSpecie;
        this.SampleName = sName;
        this.Filum = tFilum;
        this.Classes = tClasses;
        this.Gender = tGender;
        this.Ubication = tUbication;
        this.Order=tOrder;
        this.Family=tFamily;
        this.ScientificName=scName;
        this.Ecosystem=tEcosystem;
    }
    
    @Override
    public String toString() {
        return  ScientificName + "  "+ SampleName+ "  "+ Ubication + "  "+ Ecosystem+ "  "+ Filum+"  "+Classes + "  "+ Order+ "  "+ Family + "  "+ Gender+ "  "+ Specie;
    }
    
    public String getSpecie() {
        return Specie;
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

    
    
}


