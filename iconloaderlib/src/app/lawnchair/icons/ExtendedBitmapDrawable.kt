package app.lawnchair.icons

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable

open class ExtendedBitmapDrawable(
    res: Resources,
    bitmap: Bitmap,
    val isFromIconPack: Boolean,
    val maxVisualScale: Float = 1f,
) : BitmapDrawable(res, bitmap) {

    companion object {

        fun wrap(
            res: Resources,
            drawable: Drawable?,
            isFromIconPack: Boolean,
            maxVisualScale: Float = 1f,
        ): Drawable? {
            return if (drawable is BitmapDrawable) {
                ExtendedBitmapDrawable(res, drawable.bitmap, isFromIconPack, maxVisualScale)
            } else {
                drawable
            }
        }

        @JvmStatic
        val Drawable.isFromIconPack get() = (this as? ExtendedBitmapDrawable)?.isFromIconPack ?: false
    }
}
