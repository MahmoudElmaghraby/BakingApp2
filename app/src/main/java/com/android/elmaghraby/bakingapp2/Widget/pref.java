package com.android.elmaghraby.bakingapp2.Widget;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.elmaghraby.bakingapp2.Model.BakingResponse;
import com.android.elmaghraby.bakingapp2.R;

public class pref {
    public static final String PREF_NAME="pref_name";

    //to save in preference
    public static void saveRecipe(Context context ,BakingResponse mRecipe){
        SharedPreferences.Editor editor=
                context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE).edit();
        editor.putString(context.getString(R.string.pref_add),BakingResponse.toBase64String(mRecipe));

    }
    public static BakingResponse loadRecipe(Context context){
        SharedPreferences preferences=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        String recipeBase64 = preferences.getString(context.getString(R.string.pref_add), "");

        return "".equals(recipeBase64) ? null : BakingResponse.fromBase64(preferences.getString(context.getString(R.string.pref_add), ""));
    }

}
