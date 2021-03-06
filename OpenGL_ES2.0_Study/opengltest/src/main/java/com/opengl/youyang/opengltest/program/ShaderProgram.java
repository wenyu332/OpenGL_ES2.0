package com.opengl.youyang.opengltest.program;

import android.content.Context;
import android.opengl.GLES20;

import com.opengl.youyang.opengltest.utils.ShaderHelper;
import com.opengl.youyang.opengltest.utils.TextResourceReader;

/**
 * Created by youyang on 15-4-18.
 */
public class ShaderProgram {
    //uniform 常量
    protected static final String U_MVPMATRIX = "u_MVPMatrix";
    protected static final String U_TEXTURE_UNIT = "u_TextureUnit";
    protected static final String U_COLOR = "u_Color";
    protected static final String UR = "uR";
    protected static final String A_NORMAL="a_Normal";
    protected static final String U_LIGHTLOCATION="uLightLocation";
    protected static final String U_MMATRIX = "uMMatrix";
    protected static final String U_CAMERA = "uCamera";


    //attribute常量
    protected static final String A_POSITION = "a_Position";
    protected static final String A_COLOR = "a_Color";
    protected static final String A_TEXTURE_COORDINATES = "a_TextureCoordinates";


    protected final int program;

    protected ShaderProgram(Context context, int vertexShaderResourceId, int fragmentShaderResourceId) {
        program = ShaderHelper.buildProgram(TextResourceReader.readTextResourceFromRaw(context,
                vertexShaderResourceId), TextResourceReader.readTextResourceFromRaw(context,
                fragmentShaderResourceId));
    }

    public void useProgram(){
        GLES20.glUseProgram(program);
    }
}
