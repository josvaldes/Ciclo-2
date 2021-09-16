/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jose-
 */
public class ModeloProveedores {
    
    private String RazonSocial;
    private String Nit;
    private String Telefono;
    private String CorreoElectronico;
    private String RepresentanteLegal;
    private String CalleCarrera;
    private String NumeroCalleCarrera;
    private String Barrio;
    private String Ciudad;
    private String SitioWeb;
    private int Idproveedores;
    private int Iddirreciones;

    public ModeloProveedores() {
    }

    public ModeloProveedores(String RazonSocial, String Nit, String Telefono, String CorreoElectronico, String RepresentanteLegal, String CalleCarrera, String NumeroCalleCarrera, String Barrio, String Ciudad, String SitioWeb) {
        this.RazonSocial = RazonSocial;
        this.Nit = Nit;
        this.Telefono = Telefono;
        this.CorreoElectronico = CorreoElectronico;
        this.RepresentanteLegal = RepresentanteLegal;
        this.CalleCarrera = CalleCarrera;
        this.NumeroCalleCarrera = NumeroCalleCarrera;
        this.Barrio = Barrio;
        this.Ciudad = Ciudad;
        this.SitioWeb = SitioWeb;
    }

     public ModeloProveedores(int Idproveedores, String RazonSocial, String Nit, String Telefono, String CorreoElectronico, String RepresentanteLegal, String SitioWeb, int Iddirreciones, String CalleCarrera, String NumeroCalleCarrera, String Barrio, String Ciudad) {
        this.Idproveedores = Idproveedores;
        this.RazonSocial = RazonSocial;
        this.Nit = Nit;
        this.Telefono = Telefono;
        this.CorreoElectronico = CorreoElectronico;
        this.RepresentanteLegal = RepresentanteLegal;  
        this.SitioWeb = SitioWeb;
        this.Iddirreciones = Iddirreciones;
        this.CalleCarrera = CalleCarrera;
        this.NumeroCalleCarrera = NumeroCalleCarrera;
        this.Barrio = Barrio;
        this.Ciudad = Ciudad;
    }   
    

    /**
     * @return the RazonSocial
     */
    public String getRazonSocial() {
        return RazonSocial;
    }

    /**
     * @param RazonSocial the RazonSocial to set
     */
    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    /**
     * @return the Nit
     */
    public String getNit() {
        return Nit;
    }

    /**
     * @param Nit the Nit to set
     */
    public void setNit(String Nit) {
        this.Nit = Nit;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the CorreoElectronico
     */
    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    /**
     * @param CorreoElectronico the CorreoElectronico to set
     */
    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    /**
     * @return the RepresentanteLegal
     */
    public String getRepresentanteLegal() {
        return RepresentanteLegal;
    }

    /**
     * @param RepresentanteLegal the RepresentanteLegal to set
     */
    public void setRepresentanteLegal(String RepresentanteLegal) {
        this.RepresentanteLegal = RepresentanteLegal;
    }

    /**
     * @return the CalleCarrera
     */
    public String getCalleCarrera() {
        return CalleCarrera;
    }

    /**
     * @param CalleCarrera the CalleCarrera to set
     */
    public void setCalleCarrera(String CalleCarrera) {
        this.CalleCarrera = CalleCarrera;
    }

    /**
     * @return the NumeroCalleCarrera
     */
    public String getNumeroCalleCarrera() {
        return NumeroCalleCarrera;
    }

    /**
     * @param NumeroCalleCarrera the NumeroCalleCarrera to set
     */
    public void setNumeroCalleCarrera(String NumeroCalleCarrera) {
        this.NumeroCalleCarrera = NumeroCalleCarrera;
    }

    /**
     * @return the Barrio
     */
    public String getBarrio() {
        return Barrio;
    }

    /**
     * @param Barrio the Barrio to set
     */
    public void setBarrio(String Barrio) {
        this.Barrio = Barrio;
    }

    /**
     * @return the Ciudad
     */
    public String getCiudad() {
        return Ciudad;
    }

    /**
     * @param Ciudad the Ciudad to set
     */
    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    /**
     * @return the SitioWeb
     */
    public String getSitioWeb() {
        return SitioWeb;
    }

    /**
     * @param SitioWeb the SitioWeb to set
     */
    public void setSitioWeb(String SitioWeb) {
        this.SitioWeb = SitioWeb;
    }

    /**
     * @return the Idproveedores
     */
    public int getIdproveedores() {
        return Idproveedores;
    }

    /**
     * @param Idproveedores the Idproveedores to set
     */
    public void setIdproveedores(int Idproveedores) {
        this.Idproveedores = Idproveedores;
    }

    /**
     * @return the Iddirreciones
     */
    public int getIddirreciones() {
        return Iddirreciones;
    }

    /**
     * @param Iddirreciones the Iddirreciones to set
     */
    public void setIddirreciones(int Iddirreciones) {
        this.Iddirreciones = Iddirreciones;
    }
    
    

    
    
}
