package com.github.nitrico.fontbinder

import android.content.Context
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
    private const val FONT_DIR = "fonts"

    private val cache = mutableMapOf<String, Typeface>()
    private val fontMapping = mutableMapOf<String, String>()

    private lateinit var context: Context

    internal fun init(appContext: Context) {
        context = appContext.applicationContext
        val fileList: Array<String>
        try {
            fileList = context.resources.assets.list(FONT_DIR)
        } catch (e: IOException) {
            Log.e(TAG, "Error loading fonts from assets/fonts.")
            return
        }
        for (filename in fileList) {
            val alias = filename.substring(0, filename.lastIndexOf('.'))
            fontMapping.put(alias, filename)
            fontMapping.put(alias.toLowerCase(), filename)
        }
    }

    fun add(fontName: String, fontFilename: String) = fontMapping.put(fontName, fontFilename)

    @JvmStatic operator fun get(fontName: String): Typeface? {
        val fontFilename = fontMapping[fontName]
        if (fontFilename == null) {
            Log.e(TAG, "Couldn't find font $fontName.")
            return null
        }
        if (cache.containsKey(fontFilename)) return cache[fontFilename]
        else {
            val typeface = Typeface.createFromAsset(context.assets, "$FONT_DIR/$fontFilename")
            cache.put(fontFilename, typeface)
            return typeface
        }
    }

    @JvmStatic @BindingAdapter("android:font")
    fun TextView.setFont(fontName: String) { typeface = FontBinder[fontName] }

}
