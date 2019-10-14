package org.revolutionrobotics.blockly.android.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.blockly.android.view.DialogFactory
import org.revolutionrobotics.blockly.android.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.defaultInput
import org.revolutionrobotics.blockly.android.view.result.DonutResult

class MultiDonutSelectorHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message.startsWith("block_set_multiple_led")

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showDonutSelector(request.defaultInput(), true,
            DonutResult(result)
        )
    }
}
