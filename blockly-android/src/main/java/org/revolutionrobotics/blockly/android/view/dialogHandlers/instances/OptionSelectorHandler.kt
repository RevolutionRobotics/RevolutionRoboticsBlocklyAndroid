package org.revolutionrobotics.blockly.android.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.blockly.android.view.DialogFactory
import org.revolutionrobotics.blockly.android.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.defaultOption
import org.revolutionrobotics.blockly.android.view.dialogHandlers.options
import org.revolutionrobotics.blockly.android.view.dialogHandlers.title
import org.revolutionrobotics.blockly.android.view.result.OptionResult

class OptionSelectorHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) =
        message.endsWith("_selector") ||
                message.endsWith("logic_boolean.bool") ||
                message.endsWith("logic_compare.op")

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showOptionSelector(
            request.title(),
            true,
            request.options(),
            request.defaultOption(),
            OptionResult(result)
        )
    }
}
