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

        Pipeline pipeline = new Pipeline(
                "/Users/kyleng/IdeaProjects/OpenCV_Regression/Main/Resources/Capstone.png"
        );
        pipeline.manualFilterInput();
        pipeline.filterImg();
        pipeline.displayImages();
        System.exit(0);
    }
}