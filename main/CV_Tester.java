import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;


import static org.opencv.core.Core.NATIVE_LIBRARY_NAME;

public class CV_Tester {
    public static void main(String[] args){

        //setup
        System.out.println("Hello World");
        System.loadLibrary(NATIVE_LIBRARY_NAME);
        System.out.println("After many struggles, I have finally loaded in OpenCV version: " + Core.VERSION);

        //testing open cv
        Mat testMat = Imgcodecs.imread("/Users/kyleng/IdeaProjects/OpenCV_Regression/main/Capstone.png");
        HighGui.imshow("Test Capstone Window", testMat);
        HighGui.waitKey();
        System.exit(0);
    }
}