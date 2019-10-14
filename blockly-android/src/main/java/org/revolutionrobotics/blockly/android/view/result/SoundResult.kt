package org.revolutionrobotics.blockly.android.view.result

import android.webkit.JsPromptResult

class SoundResult(result: JsPromptResult) : BlocklyResult(result) {

    fun confirm(sound: String) =
        confirmResult(sound)
}
