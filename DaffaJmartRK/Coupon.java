package DaffaJmartRK;



public class Coupon extends Recognizable implements FileParser
{
    public String name;
    public int code;
    public double cut;
    public Type type;
    public double minimum;
    private boolean used;

    public enum Type{
        DISCOUNT, REBATE;
    }
    public Coupon(int id, String name, int code, Type type, double cut, double minimum)
    {
        super(id);
        this.name = name;
        this.code = code;
        this.cut = cut;
        this.type = type;
        this.minimum = minimum;
        this.used = false;
    }
    public boolean isused(){
        return this.used;
    }
    public boolean canApply(PriceTag priceTag){
        if(priceTag.getAdjustedPrice() >= this.minimum && this.used == false){
            return true;
        }
        else{
            return false;
        }
    }
    public double apply(PriceTag priceTag){
        this.used = true;
        double harga = 0;
        if(this.type == Type.DISCOUNT){
             harga = priceTag.getAdjustedPrice() - (priceTag.getAdjustedPrice()*(this.cut/100));
        }
        else if(this.type == Type.REBATE){
            harga = priceTag.getAdjustedPrice() - this.cut;
        }
        return harga;
    }
    @Override
    public boolean read(String content){
        return false;
    }
}
