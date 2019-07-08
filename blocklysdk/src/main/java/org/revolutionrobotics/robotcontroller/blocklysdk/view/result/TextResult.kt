package org.revolutionrobotics.robotcontroller.blocklysdk.view.result

import android.webkit.JsPromptResult

class TextResult(result: JsPromptResult) : BlocklyResult(result) {

    fun confirm(result: String) =
        confirmResult(result)
}
