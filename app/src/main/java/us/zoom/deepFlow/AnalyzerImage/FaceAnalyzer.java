package us.zoom.deepFlow.AnalyzerImage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.FaceDetector;
import android.media.Image;

public class FaceAnalyzer {
    public interface FaceCallback {
        void onFaceDetected(Rect rect);
    }

    public static void detectFace(Context context, Bitmap bitmap, FaceCallback callback) {
//        Image image = Image.fromBitmap(bitmap, 0);
//        FaceDetector detector = FaceDetection.getClient();
//
//        detector.process(image)
//                .addOnSuccessListener(faces -> {
//                    if (!faces.isEmpty()) {
//                        callback.onFaceDetected(faces.get(0).getBoundingBox());
//                    }
//                })
//                .addOnFailureListener(Throwable::printStackTrace);
    }
}
