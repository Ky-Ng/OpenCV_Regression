import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


import static org.opencv.core.Core.NATIVE_LIBRARY_NAME;

public class CV_Tester {
    public static void main(String[] args){

        //setup
        System.out.println("Hello World");
        System.loadLibrary(NATIVE_LIBRARY_NAME);
        System.out.println("After many struggles, I have finally loaded in OpenCV version: " + Core.VERSION);

        //testing open cv
        Mat testMat = Imgcodecs.imread("/Users/kyleng/IdeaProjects/OpenCV_Regression/main/Capstone.png");

//        Imgproc.cvtColor(testMat, testMat, Imgproc.COLOR_RGB2HSV);
        Scalar lowHSV = new Scalar(0, 0, 100);
        Scalar highHSV = new Scalar(130, 130, 255);
        Core.inRange(testMat, lowHSV, highHSV, testMat);
        HighGui.imshow("Test Capstone Window", testMat);
        HighGui.waitKey();
        System.exit(0);
    }
}