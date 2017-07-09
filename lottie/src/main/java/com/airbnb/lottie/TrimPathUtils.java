package com.airbnb.lottie;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.support.v4.view.animation.PathInterpolatorCompat;

public class TrimPathUtils {
  private static final PathMeasure pathMeasure = new PathMeasure();
  private static final Path tempPath = new Path();
  private static final Paint paint = new Paint();
  private static final Matrix matrix = new Matrix();

private Matrix getMatrix(Matrix parentMatrix) {
  PathInterpolatorCompat interpolator =
      PathInterpolatorCompat.create(x1, y1, x2, y2);
}
}
