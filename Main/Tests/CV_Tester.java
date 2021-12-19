package Tests;

import Pipeline.Pipeline;

import java.util.Scanner;

public class CV_Tester {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String googleImg = "/Users/kyleng/IdeaProjects/OpenCV_Regression/Main/Resources/Google.png";
        String capstoneImg = "/Users/kyleng/IdeaProjects/OpenCV_Regression/Main/Resources/Capstone.png";
        String blueBoxImg = "/Users/kyleng/IdeaProjects/OpenCV_Regression/Main/Resources/BlueBoxes.png";
        String ringStackImg = "/Users/kyleng/IdeaProjects/OpenCV_Regression/Main/Resources/Ringstack.png";
        String ringStack2Img = "/Users/kyleng/IdeaProjects/OpenCV_Regression/Main/Resources/Ringstack2.png";
        String ringStack3Img = "/Users/kyleng/IdeaProjects/OpenCV_Regression/Main/Resources/Ringstack3.jpg";
        String bottlePositive = "/Users/kyleng/IdeaProjects/OpenCV_Regression/Main/Resources/BottlePositive.JPG";
        String bottle2Positive = "/Users/kyleng/IdeaProjects/OpenCV_Regression/Main/Resources/Bottle2.JPG";
        Pipeline pipeline = new Pipeline(scanner, bottlePositive);
        pipeline.tuneFilterManually();
    }
}