import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class AndroidPipelineTester {
    public static int leftX1 = 30, leftX2 = 120, rightX1 = 190, rightX2 = 270;
    public static int  height1 = 15,  height2 = 145;

    public static double PERCENT_COLOR_THRESHOLD = 0.3;

    public static int lowH = 90, lowS = 90, lowV = 120;
    public static int highH = 255, highS = 255, highV = 255;

    public enum Location {
        LEFT,
        RIGHT,
        MIDDLE,
    }

    private static Location location;

    public static void main(String[] args) {
        Rect LEFT_ROI = new Rect(
                new Point(leftX1, height1),
                new Point(leftX2, height2));
        Rect RIGHT_ROI = new Rect(
                new Point(rightX1, height1),
                new Point(rightX2, height2));

        Mat mat = Imgcodecs.imread("/Users/kyleng/IdeaProjects/OpenCV_Regression/main/Capstone.png");
        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2HSV);
        // For Yellow only
//        Scalar lowHSV = new Scalar(23, 50, 70);
//        Scalar highHSV = new Scalar(32, 255, 255);

        // For Blue
        Scalar lowHSV = new Scalar(lowH, lowS, lowV);
        Scalar highHSV = new Scalar(highH, highS, highV);

        Core.inRange(mat, lowHSV, highHSV, mat);

        Mat left = mat.submat(LEFT_ROI);
        Mat right = mat.submat(RIGHT_ROI);

        double leftValue = Core.sumElems(left).val[0] / LEFT_ROI.area() / 255;
        double rightValue = Core.sumElems(right).val[0] / RIGHT_ROI.area() / 255;

        left.release();
        right.release();

//        telemetry.addData("Left raw value", (int) Core.sumElems(left).val[0]);
//        telemetry.addData("Right raw value", (int) Core.sumElems(right).val[0]);
//        telemetry.addData("Left percentage", Math.round(leftValue * 100) + "%");
//        telemetry.addData("Right percentage", Math.round(rightValue * 100) + "%");

        boolean capMiddle = leftValue > PERCENT_COLOR_THRESHOLD;
        boolean capRight = rightValue > PERCENT_COLOR_THRESHOLD;

        if (capMiddle) {
            location = Location.MIDDLE;
//            telemetry.addData("Capstone Location", "Middle");
        } else if (capRight){
            location = Location.RIGHT;
//            telemetry.addData("Capstone Location", "Right");
        } else {
            location = Location.LEFT;
//            telemetry.addData("Capstone Location", "Left");
        }
//        telemetry.update();

        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);

        Scalar notDetectedColor = new Scalar(255, 0, 0);
        Scalar detectedColor = new Scalar(0, 255, 0);

        Imgproc.rectangle(mat, LEFT_ROI, location == Location.MIDDLE? detectedColor:notDetectedColor);
        Imgproc.rectangle(mat, RIGHT_ROI, location == Location.RIGHT? detectedColor:notDetectedColor);
    }
}
