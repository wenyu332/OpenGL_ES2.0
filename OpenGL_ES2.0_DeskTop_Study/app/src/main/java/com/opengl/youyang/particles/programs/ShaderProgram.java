package com.opengl.youyang.particles.programs;

import android.content.Context;
import android.opengl.GLES20;

import com.opengl.youyang.particles.utils.ShaderHelper;
import com.opengl.youyang.particles.utils.TextResourceReader;

/**
 * Created by youyang on 15-4-18.
 */
public class ShaderProgram {
    //uniform 常量
    protected static final String U_MATRIX = "u_Matrix";
    protected static final String U_TEXTURE_UNIT = "u_TextureUnit";
    protected static final String U_COLOR = "u_Color";
    protected static final String U_TIME = "u_Time";

    //attribute常量
    protected static final String A_POSITION = "a_Position";
    protected static final String A_COLOR = "a_Color";
    protected static final String A_TEXTURE_COORDINATES = "a_TextureCoordinates";

    protected static final String A_DIRECTION_VECTOR = "a_DirectionVector";
    protected static final String A_PARTICLE_STARTTIME = "a_ParticleStartTime";

    protected final int program;

    protected ShaderProgram(Context context, int vertexShaderResourceId, int fragmentShaderResourceId) {
        //获取programId
        program = ShaderHelper.buildProgram(TextResourceReader.readTextResourceFromRaw(context,
                vertexShaderResourceId), TextResourceReader.readTextResourceFromRaw(context,
                fragmentShaderResourceId));

    }

    public void useProgram(){
        GLES20.glUseProgram(program);
    }
}
