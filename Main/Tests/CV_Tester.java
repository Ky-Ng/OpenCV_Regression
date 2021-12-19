package Tests;

import Pipeline.Pipeline;

import java.util.Scanner;

public class CV_Tester {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Pipeline pipeline = new Pipeline(scanner,
                "/Users/kyleng/IdeaProjects/OpenCV_Regression/Main/Resources/Capstone.png"
        );
        pipeline.tuneFilterManually();
    }
}