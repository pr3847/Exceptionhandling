import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws CustomException {
        String line="Hi my name is manu i am studying btech and studying java";
        String regex="tony";
        int count=0;

        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            count++;
        }
        if(count==0){
            throw new CustomException("String not found");
        }
        System.out.println(count);
    }
}