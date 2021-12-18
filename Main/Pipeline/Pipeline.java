package Pipeline;

import java.util.Scanner;

import static org.opencv.core.Core.NATIVE_LIBRARY_NAME;

public class Pipeline {
    Scanner scanner = new Scanner(System.in);

    public Pipeline(){
        System.loadLibrary(NATIVE_LIBRARY_NAME);
    }
    public void manualFilterInput(){
        System.out.println("lowH(lh), lowS(ls), lowV(lv), highS(hs), highH(hh), highV(hv), exit(e)");
        switch (scanner.nextLine()){
            case ("e"):
                System.out.println("Done");
                break;
            case ("lh"):
                System.out.println("Chaning lh");
                break;
        }
    }
}
