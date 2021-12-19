package Pipeline;

import Util.ScalarEx;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.Scanner;

import static org.opencv.core.Core.NATIVE_LIBRARY_NAME;

public class Pipeline {
    Scanner scanner;
    ScalarEx colorLow = new ScalarEx(0,0,0);
    ScalarEx colorHigh = new ScalarEx(255,255,255);
    Mat originalImg, hsvImg, filteredImg;

    public Pipeline(Scanner scanner, String imagePath){
        this.scanner = scanner;
        System.loadLibrary(NATIVE_LIBRARY_NAME);

        originalImg = Imgcodecs.imread(imagePath);
        hsvImg = originalImg.clone(); //need to have the same Matrix size
        filteredImg = originalImg.clone();

        Imgproc.cvtColor(originalImg, hsvImg, Imgproc.COLOR_BGR2HSV);
    }

    public void tuneFilterManually(){
        displayImages();
        System.out.println("Press any key to start");
        while (!scanner.nextLine().equals("e")){
            System.out.println("manually getting input_______________________________");
            manualFilterInput();
            System.out.println("filtering image _______________________________");
            filterImg();
            System.out.println("displaying image image _______________________________");
            displayImages();
        }
    }

    void manualFilterInput(){
        System.out.println("lowH(lh), lowS(ls), lowV(lv), highS(hs), highH(hh), highV(hv), exit(e)");
        switch (scanner.nextLine()) {
            case ("lh") -> {
                System.out.println("Input lh");
                colorLow.setH(scanner.nextInt());
            }
            case ("ls") -> {
                System.out.println("Input ls");
                colorLow.setS(scanner.nextInt());
            }
            case ("lv") -> {
                System.out.println("Input lv");
                colorLow.setV(scanner.nextInt());
            }
            case ("hh") -> {
                System.out.println("Input hh");
                colorHigh.setH(scanner.nextInt());
            }
            case ("hs") -> {
                System.out.println("Input hs");
                colorHigh.setS(scanner.nextInt());
            }
            case ("hv") -> {
                System.out.println("Input hv");
                colorHigh.setV(scanner.nextInt());
            }
        }
        scanner.nextLine();
        System.out.println("New Low Color Threshold " + colorLow.toString());
        System.out.println("New High Color Threshold " + colorHigh.toString());
    }

    void filterImg(){
        Core.inRange(originalImg,colorLow, colorHigh, filteredImg);
    }

    void displayImages(){
//        HighGui.imshow("Original Img", originalImg);
//        HighGui.imshow("HSV Img", hsvImg);
        HighGui.imshow("Filtered Img", filteredImg);
        HighGui.waitKey(1);
//        HighGui.destroyAllWindows();
    }
}
