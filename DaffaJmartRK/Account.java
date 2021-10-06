package DaffaJmartRK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Recognizable implements FileParser
{
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&*_~]+(\\.[a-zA-Z0-9&*_~]+)*@[a-zA-Z0-9][a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public String name;
    public String email;
    public String password;
    
    public Account(int id, String name, String email, String password){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    @Override
    public boolean read(String content){
        return false;
    }
    /*public String toString(){
        return
        "name: "+this.name+" /n"+
        "email: "+this.email+" /n"+
        "password: "+this.password+" /n";
    }*/
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(this.email);
        Pattern pattern1 = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher1 = pattern.matcher(this.password);
        if(matcher.find() && matcher1.find() == true){
            return true;
        }
        return false;
    }
}
