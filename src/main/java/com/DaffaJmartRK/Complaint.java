package com.DaffaJmartRK;
import java.util.Date;

import com.DaffaJmartRK.dbjson.Serializable;

import java.text.SimpleDateFormat;

public class Complaint extends Serializable
{
    public Date date;
    public String desc;
    
    public Complaint(String desc){
        this.desc = desc;
        this.date = new Date();
    }
    public String toString(){
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
        String date = formattedDate.format(this.date);
        return "Complaint{date="+date+", desc='"+this.desc+"'}";
        
    }
}
