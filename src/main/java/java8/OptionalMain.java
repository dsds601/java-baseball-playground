package java8;


import java.util.Optional;
import java.util.Properties;

public class OptionalMain {
    public static Optional<Integer> stringInt(String s){
        try{
            return Optional.of(Integer.parseInt(s));
        }catch (NumberFormatException e){
            return Optional.empty();
        }
    }

    public static int readDuration(Properties prop , String name){
        return Optional.ofNullable(prop.getProperty(name))
                .flatMap(e->stringInt(e))
                .filter(i->i>0)
                .orElse(0);
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("a","5");
        int a = readDuration(properties, "a");
        System.out.println(a);
    }
}
