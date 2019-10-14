package org.revolutionrobotics.blockly.android.view.result

import android.webkit.JsPromptResult

class DialpadResult(result: JsPromptResult) : BlocklyResult(result) {

    fun confirm(number: Double) =
        confirmResult("$number")
}
