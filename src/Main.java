import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Map<String, String> CartasT;
        Scanner scan = new Scanner(System.in);
        MapFactory myfactory=new MapFactory();
        int n;
        System.out.println("Introduzca el tipo del Map con el cual desea trabajar");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");

        try{
            n=scan.nextInt();
        } catch(InputMismatchException e){
            System.out.println("No haz ingresado un numero. El programa se ejecutara con HashMap\n");
            n = 1;
        }
        CartasT=myfactory.creadorMap(n);

        try{
            Stream<String> lines = Files.lines(
                    Paths.get("cards_desc2.txt"),
                    StandardCharsets.UTF_8
            );
            lines.forEach(a -> CartasT.put(a.split("|")[0],a.split("|")[1] ));
        } catch (IOException e){
            System.out.println("Error!");
        }
        System.out.println(CartasT);

    }
}
