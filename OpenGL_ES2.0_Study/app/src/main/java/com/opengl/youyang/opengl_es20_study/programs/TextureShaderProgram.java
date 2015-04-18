package com.opengl.youyang.opengl_es20_study.programs;

import android.content.Context;
import android.opengl.GLES20;

import com.opengl.youyang.opengl_es20_study.R;

/**
 * Created by youyang on 15-4-18.
 */
public class TextureShaderProgram extends ShaderProgram{
    private final int uMatrixLocation;
    private final int uTextureUnitLocation;

    private final int aPositionLocation;
    private final int aTextureCoordinatesLocation;

    public TextureShaderProgram(Context context){
        super(context, R.raw.texture_vertex_shader,R.raw.texture_fragment_shader);
        uMatrixLocation= GLES20.glGetUniformLocation(program,U_MATRIX);
        uTextureUnitLocation=GLES20.glGetUniformLocation(program,U_TEXTURE_UNIT);

        aPositionLocation=GLES20.glGetAttribLocation(program, A_POSITION);
        aTextureCoordinatesLocation=GLES20.glGetAttribLocation(program,A_TEXTURE_COORDINATES);
    }

    public void setUniforms(float[] matrix,int textureId){
        GLES20.glUniformMatrix4fv(uMatrixLocation,1,false,matrix,0);
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureId);
        GLES20.glUniform1i(uTextureUnitLocation,0);
    }

    public int getPositionAttributeLocation(){
        return aPositionLocation;
    }

    public int getTextureCoordinatesAttributeLocation(){
        return aTextureCoordinatesLocation;
    }
}
