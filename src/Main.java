import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Controller c = new Controller();
        if(args.length > 0){
            c.sortImage(args[0]);
        }
    }
}

