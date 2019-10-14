package org.revolutionrobotics.blockly.android.view.result

import android.webkit.JsPromptResult

class TextResult(result: JsPromptResult) : BlocklyResult(result) {

    fun confirm(result: String) =
        confirmResult(result)
}
