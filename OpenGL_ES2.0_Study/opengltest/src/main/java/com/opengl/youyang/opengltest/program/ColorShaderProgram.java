package com.opengl.youyang.opengltest.program;

import android.content.Context;
import android.opengl.GLES20;

import com.opengl.youyang.opengltest.R;

/**
 * Created by youyang on 15-4-19.
 */
public class ColorShaderProgram extends ShaderProgram{
    private final int u_ColorLocation;
    private final int u_MatrixLocation;
    private final int aPositionLocation;
    public ColorShaderProgram(Context context){
    super(context, R.raw.simple_vertex_shader_a,R.raw.simple_fragment_shader_a);
        u_MatrixLocation = GLES20.glGetUniformLocation(program,U_MATRIX);
        u_ColorLocation = GLES20.glGetUniformLocation(program,U_COLOR);
        aPositionLocation = GLES20.glGetAttribLocation(program,A_POSITION);
    }

    public void setUniforms(float[] matrix,float r,float g,float b){
        GLES20.glUniformMatrix4fv(u_MatrixLocation,1,false,matrix,0);
        GLES20.glUniform4f(u_ColorLocation,r,g,b,1.0f);
    }

    public int getPositionAttributionLocation(){
        return aPositionLocation;
    }


}
