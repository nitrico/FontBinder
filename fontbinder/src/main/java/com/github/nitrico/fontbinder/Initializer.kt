package com.github.nitrico.fontbinder

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.pm.ProviderInfo
import android.net.Uri

/**
 * https://medium.com/@andretietz/auto-initialize-your-android-library-2349daf06920
 */
class Initializer : ContentProvider() {

    companion object {
        private const val PROVIDER_AUTHORITY = "com.github.nitrico.fontbinder.Initializer"
        private const val EXCEPTION_MESSAGE = "Incorrect provider authority in manifest. " +
                "Most likely due to a missing applicationId variable in application\'s build.gradle."
    }

    override fun onCreate(): Boolean {
        FontBinder.init(context.applicationContext)
        return true
    }

    override fun attachInfo(context: Context, info: ProviderInfo) {
        if (PROVIDER_AUTHORITY.equals(info.authority)) throw IllegalStateException(EXCEPTION_MESSAGE)
        super.attachInfo(context, info)
    }

    override fun getType(uri: Uri) = null

    override fun query(uri: Uri, p: Array<String>, s: String, a: Array<String>, o: String) = null

    override fun insert(uri: Uri, v: ContentValues) = null

    override fun delete(uri: Uri, s: String, a: Array<String>) = 0

    override fun update(uri: Uri, v: ContentValues, s: String, a: Array<String>) = 0

}
