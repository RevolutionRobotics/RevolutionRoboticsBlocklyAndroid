package org.revolutionrobotics.robotcontroller.blocklysdk.view.result

import android.webkit.JsPromptResult

class SoundResult(result: JsPromptResult) : BlocklyResult(result) {

    fun confirm(sound: String) =
        confirmResult(sound)
}
