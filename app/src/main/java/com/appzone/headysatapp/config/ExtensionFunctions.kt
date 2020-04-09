package com.appzone.headysatapp.config

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable


fun <T : Any> AppCompatActivity.launchWithData(classType: Class<T>, bundle: Bundle) {
    var intent = Intent(this, classType)
    intent.putExtra(Constant.KEY_BUNDLE, bundle)
    startActivity(intent)
}


fun AppCompatActivity.getSerializableIntentValue(
    context: AppCompatActivity, extra: String
): Serializable? {
    var bundle = context.intent!!.getBundleExtra(Constant.KEY_BUNDLE)
    if (bundle != null && bundle.containsKey(extra)) {
        return context.intent!!.getBundleExtra(Constant.KEY_BUNDLE).getSerializable(extra)
    } else {
        return ""
    }
}