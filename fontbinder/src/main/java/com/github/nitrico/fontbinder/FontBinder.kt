package com.github.nitrico.fontbinder

import android.content.Context
import android.content.res.AssetManager
import android.databinding.BindingAdapter
import android.graphics.Typeface
import android.util.Log
import android.widget.TextView
import java.io.IOException

/**
 * Kotlin port of Lisa Wray's FontBinding https://github.com/lisawray/fontbinding
 */
object FontBinder {

    private const val TAG = "FontBinder"
    private const val DIR = "fonts"

    private val cache = mutableMapOf<String, Typeface>()
    private val mapping = mutableMapOf<String, String>()

    private lateinit var assets: AssetManager

    internal fun init(context: Context) {
        assets = context.applicationContext.assets
        val fileList: Array<String>
        try {
            fileList = assets.list(DIR)
        } catch (e: IOException) {
            Log.e(TAG, "Error loading fonts from assets/$DIR.")
            return
        }
        for (filename in fileList) {
            val alias = filename.substring(0, filename.lastIndexOf('.'))
            mapping.put(alias, filename)
            mapping.put(alias.toLowerCase(), filename)
        }
    }

    @JvmStatic
    fun add(fontName: String, fontFilename: String) = mapping.put(fontName, fontFilename)

    @JvmStatic
    operator fun get(fontName: String): Typeface? {
        val filename = mapping[fontName]
        if (filename == null) {
            Log.e(TAG, "Couldn't find font $fontName.")
            return null
        }
        if (cache.containsKey(filename)) return cache[filename]
        return Typeface.createFromAsset(assets, "$DIR/$filename").apply { cache.put(filename, this) }
    }

    @JvmStatic @BindingAdapter("android:font")
    fun TextView.setFont(fontName: String) { typeface = FontBinder[fontName] }

}
