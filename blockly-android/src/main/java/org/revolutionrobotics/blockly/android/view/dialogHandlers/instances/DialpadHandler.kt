package org.revolutionrobotics.blockly.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.blockly.view.DialogFactory
import org.revolutionrobotics.blockly.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.blockly.view.dialogHandlers.defaultInput
import org.revolutionrobotics.blockly.view.result.DialpadResult

class DialpadHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message.endsWith("math_number.num")

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showDialpad(request.defaultInput("0").toDouble(),
            DialpadResult(result)
        )
    }
}
