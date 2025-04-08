package us.zoom.deepFlow.AnalyzerImage;

import android.graphics.Bitmap;
import android.graphics.Color;

import us.zoom.deepFlow.AnalyzerImage.utils.HsvUtils;

public class RedAreaAnalyzer {
    public static float analyzeRedArea(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int redPixels = 0;
        int totalPixels = width * height;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = bitmap.getPixel(x, y);
                float[] hsv = new float[3];
                Color.colorToHSV(pixel, hsv);
                if (HsvUtils.isRed(hsv)) {
                    redPixels++;
                }
            }
        }

        return (float) redPixels / totalPixels;
    }
}
