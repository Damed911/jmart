package DaffaJmartRK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store extends Recognizable implements FileParser
{
    public static String REGEX_PHONE = "^\\d{9, 12}$";
    public static String REGEX_NAME = "^[A,Z](?!.*(\\s)\1).{4,20}$";
    public String name;
    public String address;
    public String phoneNumber;
    @Override
    public boolean read(String content){
        return false;
    }
    public Store(int accountId, String name, String address, String phoneNumber){
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public Store(Account account, String name, String address, String phoneNumber){
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public String toString(){
        return
        "name: "+this.name+" \n"+
        "address: "+this.address+" \n"+
        "phoneNumber: "+this.phoneNumber+" \n";
    }
    public boolean validate(){
       Pattern pattern = Pattern.compile(REGEX_NAME);
       Matcher matcher = pattern.matcher(name);
       Pattern pattern1 = Pattern.compile(REGEX_PHONE);
       Matcher matcher1 = pattern1.matcher(phoneNumber);
       return matcher.find() && matcher1.find();
    }
}
