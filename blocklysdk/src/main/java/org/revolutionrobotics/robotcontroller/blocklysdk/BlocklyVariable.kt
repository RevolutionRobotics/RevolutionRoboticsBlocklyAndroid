package org.revolutionrobotics.robotcontroller.blocklysdk

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BlocklyVariable(val name: String, val key: String) : Parcelable
