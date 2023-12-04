package zoom;

import java.awt.*;
import java.awt.geom.AffineTransform;


// 현재 설정된 줌 비율에 따라 변환된 포인트 계산
public class ZoomLocation {
    private double zoomFactor = 1.0; // 확대 축소 비율

    public Point getTransformedPoint(int x, int y) {
        AffineTransform transform = new AffineTransform();
        transform.scale(1.0 / zoomFactor, 1.0 / zoomFactor);

        Point transformedPoint = new Point();
        transform.transform(new Point(x, y), transformedPoint);

        return transformedPoint;
    }
}

// getX()와 getY()로 사용가능
