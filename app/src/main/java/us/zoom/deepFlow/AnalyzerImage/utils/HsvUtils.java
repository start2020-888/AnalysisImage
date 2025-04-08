package us.zoom.deepFlow.AnalyzerImage.utils;

public class HsvUtils {
    public static boolean isRed(float[] hsv) {
        float h = hsv[0];
        float s = hsv[1];
        float v = hsv[2];
        return ((h >= 0 && h <= 15) || (h >= 340 && h <= 360)) && s > 0.5 && v > 0.2;
    }
}
