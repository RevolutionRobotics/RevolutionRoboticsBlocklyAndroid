package org.revolutionrobotics.robotcontroller.blocklysdk.view.result

import android.webkit.JsPromptResult

class DialpadResult(result: JsPromptResult) : BlocklyResult(result) {

    fun confirm(number: Double) =
        confirmResult("$number")
}
