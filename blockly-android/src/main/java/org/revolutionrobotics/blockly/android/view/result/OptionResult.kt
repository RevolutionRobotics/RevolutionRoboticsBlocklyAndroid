package org.revolutionrobotics.blockly.android.view.result

import android.webkit.JsPromptResult
import org.revolutionrobotics.blockly.android.BlocklyOption

class OptionResult(result: JsPromptResult) : BlocklyResult(result) {

    fun confirm(option: BlocklyOption) =
        confirm(option.key)

    fun confirm(optionKey: String) =
        confirmResult(optionKey)
}
