package com.DaffaJmartRK;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Shipment
{
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public static class Duration{
    public static SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");
    public static Duration INSTANT = new Duration((byte) (1<<0));
    public static Duration SAME_DAY = new Duration((byte) (1<<1));
    public static Duration NEXT_DAY = new Duration((byte) (1<<2));
    public static Duration REGULER = new Duration((byte) (1<<3));
    public static Duration KARGO = new Duration ((byte) (1<<4));
    public byte bit;
    
    private Duration(byte bit){
        this.bit = bit;
    }
    public String getEstimatedArrival(Date reference){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(reference);
        if(bit == Duration.NEXT_DAY.bit){
            calendar.add(Calendar.DATE, 1);
        }
        else if(bit == Duration.REGULER.bit){
            calendar.add(Calendar.DATE, 2);
        }
        else if(bit == Duration.KARGO.bit){
            calendar.add(Calendar.DATE, 5);
        }
        else if(bit == Duration.INSTANT.bit || bit == Duration.SAME_DAY.bit){
            calendar.add(Calendar.DATE, 0);
        }
        return ESTIMATION_FORMAT.format(calendar.getTime());
    }
    }
    public class MultiDuration{
        public byte bit;
        public MultiDuration(Duration[] args){
        int flags = 0;
        for (Duration arg : args)
            flags |= arg.bit;
        bit = (byte) flags;
    }
    public boolean isDuration(Duration reference){
        return (bit & reference.bit) != 0;
    }
    }
    public Shipment(String address, int shipmentCost, Duration duration, String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
}
