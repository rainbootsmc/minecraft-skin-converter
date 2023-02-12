package dev.uten2c.skinconverter

import com.soywiz.korim.bitmap.Bitmap32
import com.soywiz.korim.format.ImageDecodingProps
import com.soywiz.korim.format.PNG
import com.soywiz.korma.geom.Size

object SkinConverter {
    fun isOldSkin(image: ByteArray): Boolean {
        val bitmap = PNG.read(image, ImageDecodingProps())
        return bitmap.size == Size(64, 32)
    }

    fun convertToNewSkin(oldSkin: ByteArray): ByteArray {
        val bitmap = PNG.read(oldSkin, ImageDecodingProps())
        val resultBitmap = Bitmap32(64, 64)
        bitmap.copy(0, 0, resultBitmap, 0, 0, 64, 32)
        bitmap.copy(0, 16, resultBitmap, 16, 48, 16, 16)
        bitmap.copy(40, 16, resultBitmap, 32, 48, 16, 16)
        return PNG.encode(resultBitmap)
    }
}
