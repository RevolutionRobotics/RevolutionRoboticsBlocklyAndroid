package org.revolutionrobotics.robotcontroller.blocklysdk.view.result

import android.webkit.JsPromptResult

class DonutResult(result: JsPromptResult) : BlocklyResult(result) {

    fun confirm(index: Int) =
        confirmResult("$index")

    fun confirm(indexes: IntArray) =
        confirmResult(indexes.joinToString(","))
}
