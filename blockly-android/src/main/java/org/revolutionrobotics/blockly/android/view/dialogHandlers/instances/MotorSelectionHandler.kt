package org.revolutionrobotics.blockly.android.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.blockly.android.view.DialogFactory
import org.revolutionrobotics.blockly.android.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.defaultInput
import org.revolutionrobotics.blockly.android.view.dialogHandlers.subtitle
import org.revolutionrobotics.blockly.android.view.dialogHandlers.title
import org.revolutionrobotics.blockly.android.view.result.TextResult

class MotorSelectionHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message.contains("motor.name_input")

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showMotorSelector(
            request.title(), request.subtitle(), request.defaultInput(),
            TextResult(result)
        )
    }
}