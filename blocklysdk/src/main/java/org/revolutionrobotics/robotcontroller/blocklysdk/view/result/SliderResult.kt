package org.revolutionrobotics.robotcontroller.blocklysdk.view.result

import android.webkit.JsPromptResult

class SliderResult(result: JsPromptResult) : BlocklyResult(result) {

    fun confirm(number: Int) =
        confirmResult("$number")
}
