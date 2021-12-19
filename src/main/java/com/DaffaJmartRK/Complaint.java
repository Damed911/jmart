package com.DaffaJmartRK;
import java.util.Date;

import com.DaffaJmartRK.dbjson.Serializable;

import java.text.SimpleDateFormat;
/**
 * Class complaint untuk menampung complaint pada store jmart
 * @author M. Daffa Ajiputra
 * @version Final
 */
public class Complaint extends Serializable
{
	/**
	 * Instance Variable class Complaint
	 */
    public Date date;
    public String desc;
    /**
     * Constructor Method class complaint
     * @param desc
     */
    public Complaint(String desc){
        this.desc = desc;
        this.date = new Date();
    }
    /**
     * Method untuk mengonversi variabel menjadi string
     */
    public String toString(){
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
        String date = formattedDate.format(this.date);
        return "Complaint{date="+date+", desc='"+this.desc+"'}";
        
    }
}
