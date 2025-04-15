package us.zoom.deepFlow.AnalyzerImage.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SmileWaveView extends View {

    private final Paint paint = new Paint();
    private final List<Float> wavePoints = new ArrayList<>();
    private final int maxPoints = 100;
    private float smileFactor = 0f; // 当前笑容值，0~1

    public SmileWaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void updateSmileFactor(float factor) {
        this.smileFactor = factor;
        invalidate(); // 触发重绘
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float height = getHeight();
        float width = getWidth();
        float centerY = height / 2;

        // 生成一个“带跳动”的波动值
        float newY = (float) (centerY + Math.sin(System.currentTimeMillis() * 0.01) * smileFactor * 100);
        wavePoints.add(newY);

        // 控制长度
        if (wavePoints.size() > maxPoints) {
            wavePoints.remove(0);
        }

        // 画折线
        Path path = new Path();
        for (int i = 0; i < wavePoints.size(); i++) {
            float x = i * (width / maxPoints);
            float y = wavePoints.get(i);
            if (i == 0) {
                path.moveTo(x, y);
            } else {
                path.lineTo(x, y);
            }
        }
        canvas.drawPath(path, paint);
        postInvalidateDelayed(30);  // 每帧自动刷新
    }
}