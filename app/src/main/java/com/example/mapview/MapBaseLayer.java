package com.example.mapview;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.TypedValue;
import android.view.MotionEvent;

public abstract class MapBaseLayer {

    // map layer level
    protected static final int MAP_LEVEL = 0;
    protected static final int MARK_LEVEL = 1;
    protected static final int ROUTE_LEVEL = 2;
    // location layer level
    protected static final int LOCATION_LEVEL = Integer.MAX_VALUE;

    // layer show level
    public int level;
    // layer is/not show
    public boolean isVisible = true;

    protected MapView mapView;

    public MapBaseLayer(MapView mapView) {
        this.mapView = mapView;
    }

    /**
     * touch event
     *
     * @param event
     */
    public abstract void onTouch(MotionEvent event);

    /**
     * draw event
     *
     * @param canvas
     * @param currentMatrix
     * @param currentZoom
     * @param currentRotateDegrees
     */
    public abstract void draw(Canvas canvas, Matrix currentMatrix, float currentZoom,
                              float currentRotateDegrees);

    public void setLevel(int level) {
        this.level = level;
    }

    public void onTwoTouch(MotionEvent event) {
    }

    protected float setValue(float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, mapView.getResources()
                .getDisplayMetrics());
    }
}
