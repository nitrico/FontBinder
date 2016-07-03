package com.github.nitrico.fontbinder

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.pm.ProviderInfo
import android.net.Uri

class Initializer() : ContentProvider() {

    override fun onCreate(): Boolean {
        FontBinder.init(context.applicationContext)
        return true
    }

    override fun attachInfo(context: Context, info: ProviderInfo) {
        // So if the authorities equal the library internal ones, the developer forgot to set his applicationId
        if ("com.github.nitrico.fontbinder.Initializer".equals(info.authority)) {
            throw IllegalStateException("Incorrect provider authority in manifest. " +
                    "Most likely due to a missing applicationId variable in application\'s build.gradle.")
        }
        super.attachInfo(context, info)
    }

    override fun insert(uri: Uri, values: ContentValues) = null

    override fun delete(uri: Uri, selection: String, args: Array<out String>) = 0

    override fun update(uri: Uri, values: ContentValues, selection: String, args: Array<out String>) = 0

    override fun getType(uri: Uri) = null

    override fun query(uri: Uri, projection: Array<out String>, selection: String,
                       args: Array<out String>, order: String) = null

}
