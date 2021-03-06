package com.opengl.youyang.yumulibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.opengl.youyang.yumulibrary.programs.ColorShaderProgram;
import com.opengl.youyang.yumulibrary.shape.Circle;
import com.opengl.youyang.yumulibrary.shape.Point;
import com.opengl.youyang.yumulibrary.shape.ShapeObjct;
import com.opengl.youyang.yumulibrary.utils.IGLCanvas;
import com.opengl.youyang.yumulibrary.utils.IGLRender;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by youyang on 16/3/30.
 */
public class GLRender implements GLSurfaceView.Renderer, IGLCanvas, Circle.ShapeSize {

    private ShapeObjct mShape;
    private IGLRender mRender;

    private Circle mCircle ;

    private Point mPoint;

    //存储矩阵数据
    private final float[] projectionMarix = new float[16];
    private final float[] viewMatrix = new float[16];
//    private final float[] viewProjectionMatrix = new float[16];
    private ColorShaderProgram colorShaderProgram;
    private Context mContext;
    private int mWidth;
    private int mHeight;

    GLRender(Context context,IGLRender render){
        this.mContext = context;
        this.mRender = render;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

        GLES20.glClearColor(0.4f, 0.4f, 0.6f, 0.4f);
        colorShaderProgram = new ColorShaderProgram(mContext);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        mHeight = height;
        mWidth = width;
//        MatrixHelper.perspectiveM(projectionMarix, 45, (float) width / (float) height, 1f, 10f);
//        android.opengl.Matrix.setLookAtM(viewMatrix, 0, 0f, 1.2f, 2.2f, 0f, 0f, 0f, 0f, 1f, 0f);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        //每次绘制一帧画面时都会调用。如果什么都不做，可能会看到糟糕的闪烁效果
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
//        android.opengl.Matrix.setIdentityM(viewMatrix, 0);
//        android.opengl.Matrix.translateM(viewMatrix, 0, 0, 0, -4f);
        final float[] temp = new float[16];
//        android.opengl.Matrix.multiplyMM(temp, 0, projectionMarix, 0, viewMatrix, 0);
//        System.arraycopy(temp,0,projectionMarix,0,temp.length);

        colorShaderProgram.useProgram();

        colorShaderProgram.setUniforms(viewMatrix, 0.1f, 0.2f, 0.2f);
        mShape.bindData(colorShaderProgram);
        mShape.draw();
    }


    void initShape(ShapeObjct obj){
        mShape = obj;
        mRender.requestRender();
    }

    @Override
    public void drawARGB(int a, int r, int g, int b) {

    }

    @Override
    public void drawPoints(float[] pts, int offset, int count) {
        mPoint = new Point(100,100,this);
        mPoint.generateVertices(true);
        initShape(mPoint);

    }

    @Override
    public void drawLine(float startX, float startY, float stopX, float stopY) {

    }

    @Override
    public void drawRect(float left, float top, float right, float bottom) {

    }

    @Override
    public void drawOval(float left, float top, float right, float bottom) {

    }

    @Override
    public void drawCircle(float cx, float cy, float radius) {
//        if(mCircle == null || mCircle.getCx()!=cx || mCircle.getCy()!=cy ||mCircle.getRadius() != radius){
            mCircle = new Circle(cx,cy,radius,this);
            mCircle.generateVertices(false);
//        }
        initShape(mCircle);
    }

    @Override
    public void drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter) {

    }

    @Override
    public void drawBitmap(Bitmap bitmap, float left, float top) {

    }

    @Override
    public void setBitmap(Bitmap bitmap) {

    }

    @Override
    public void setViewport(int width, int height) {

    }

    @Override
    public int getWidth() {
        return mWidth;
    }

    @Override
    public int getHeight() {
        return mHeight;
    }

    @Override
    public int save() {
        return 0;
    }

    @Override
    public void restore() {

    }

    @Override
    public void translate(float dx, float dy) {

    }

    @Override
    public void scale(float sx, float sy) {

    }

    @Override
    public void rotate(float degrees) {

    }

    @Override
    public void skew(float sx, float sy) {

    }

    @Override
    public void setMatrix(Matrix matrix) {

    }

    @Override
    public void drawBitmapMesh(Bitmap bitmap, int meshWidth, int meshHeight, float[] verts, int vertOffset, int[] colors, int colorOffset) {

    }

    @Override
    public void requestRender() {
    }
}
