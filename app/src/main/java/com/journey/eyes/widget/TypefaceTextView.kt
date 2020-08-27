package com.journey.eyes.widget

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.journey.eyes.R
import com.journey.eyes.utils.TypeFaceUtil

/**
 * @By Journey 2020/8/27
 * @Description 带有自定义字体的view
 */
class TypefaceTextView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attributeSet, defStyleAttr) {

    init {
        attributeSet?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.TypefaceTextView, 0, 0)
            val typefaceType = typedArray.getInt(R.styleable.TypefaceTextView_typeface, 0)
            typeface = getTypeface(typefaceType)
            typedArray.recycle()
        }
    }

    companion object {
        /**
         * 根据字体类型，获取自定义字体。
         */
        private fun getTypeface(typefaceType: Int?) = when (typefaceType) {
            TypeFaceUtil.FZLL_TYPEFACE -> TypeFaceUtil.getFzlLTypeface()
            TypeFaceUtil.FZDB1_TYPEFACE -> TypeFaceUtil.getFzdb1Typeface()
            TypeFaceUtil.FUTURA_TYPEFACE -> TypeFaceUtil.getFuturaTypeface()
            TypeFaceUtil.DIN_TYPEFACE -> TypeFaceUtil.getDinTypeface()
            TypeFaceUtil.LOBSTER_TYPEFACE -> TypeFaceUtil.getLobsterTypeface()
            else -> Typeface.DEFAULT
        }
    }
}