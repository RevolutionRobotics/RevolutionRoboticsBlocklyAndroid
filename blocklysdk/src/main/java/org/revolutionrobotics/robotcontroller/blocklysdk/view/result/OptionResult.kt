package org.revolutionrobotics.robotcontroller.blocklysdk.view.result

import android.webkit.JsPromptResult
import org.revolutionrobotics.robotcontroller.blocklysdk.BlocklyOption

class OptionResult(result: JsPromptResult) : BlocklyResult(result) {

    fun confirm(option: BlocklyOption) =
        confirm(option.key)

    fun confirm(optionKey: String) =
        confirmResult(optionKey)
}
