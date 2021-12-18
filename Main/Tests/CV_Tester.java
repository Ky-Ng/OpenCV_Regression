package Tests;

import Pipeline.Pipeline;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;


import java.nio.channels.Pipe;

import static org.opencv.core.Core.NATIVE_LIBRARY_NAME;

public class CV_Tester {
    public static void main(String[] args){

        Pipeline pipeline = new Pipeline();
//        Mat testMat = Imgcodecs.imread("/Users/kyleng/IdeaProjects/OpenCV_Regression/Resources/Google.png");

//        Imgproc.cvtColor(testMat, testMat, Imgproc.COLOR_RGB2HSV);

//        Scalar lowHSV = new Scalar(0, 0, 100);
//        Scalar highHSV = new Scalar(130, 130, 255);
//        Core.inRange(testMat, lowHSV, highHSV, testMat);
//        HighGui.imshow("Test Capstone Window", testMat);
//        HighGui.waitKey();
        pipeline.manualFilterInput();
        System.exit(0);
    }
}