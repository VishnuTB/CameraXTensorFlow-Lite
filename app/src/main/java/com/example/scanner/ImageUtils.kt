package com.example.scanner

import android.graphics.Bitmap
import android.graphics.Matrix
import android.os.Environment
import java.io.File
import java.util.*

object ImageUtils {

    private val imageLocation: File?
        get() = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES
        )

    fun rotateImage(source: Bitmap, angle: Float): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(angle)
        return Bitmap.createBitmap(
            source, 0, 0, source.width, source.height,
            matrix, true
        )
    }

    fun getImageFile(folderName: String): File {
        val imageDir = File("$imageLocation/$folderName")
        imageDir.mkdirs()
        val fileName =
            Calendar.getInstance(Locale.getDefault()).timeInMillis.toString() + ".jpg"
        return File(imageDir, fileName)
    }
}