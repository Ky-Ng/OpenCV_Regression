package Tests;

import Pipeline.Pipeline;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


import java.nio.channels.Pipe;

import static org.opencv.core.Core.NATIVE_LIBRARY_NAME;

public class CV_Tester {
    public static void main(String[] args){

        Pipeline pipeline = new Pipeline();
        Mat originalPic = Imgcodecs.imread(
                "/Users/kyleng/IdeaProjects/OpenCV_Regression/Main/Resources/Capstone.png"
        );
        Mat hsvPic = originalPic.clone();
        Mat grayPic = originalPic.clone();
        Imgproc.cvtColor(originalPic, hsvPic, Imgproc.COLOR_BGR2HSV);
        Imgproc.cvtColor(originalPic, grayPic, Imgproc.COLOR_BGR2GRAY);

//        Scalar lowHSV = new Scalar(0, 0, 100);
//        Scalar highHSV = new Scalar(130, 130, 255);
//        Core.inRange(originalPic, lowHSV, highHSV, originalPic);

//        HighGui.imshow("Original Pic", originalPic);
//        HighGui.imshow("HSV Pic", hsvPic);
//        HighGui.imshow("Gray Pic", grayPic);
//        HighGui.waitKey();
        pipeline.manualFilterInput();
        System.exit(0);
    }
}