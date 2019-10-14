package org.revolutionrobotics.blockly.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.blockly.view.DialogFactory
import org.revolutionrobotics.blockly.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.blockly.view.dialogHandlers.defaultKey
import org.revolutionrobotics.blockly.view.dialogHandlers.title
import org.revolutionrobotics.blockly.view.dialogHandlers.variables
import org.revolutionrobotics.blockly.view.result.VariableResult

class VariableOptionsHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message.endsWith(".var")

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        val variables = request.variables()
        dialogFactory.showVariableOptionsDialog(
            request.title(),
            variables.firstOrNull { it.key == request.defaultKey() },
            variables,
            VariableResult(result)
        )
    }
}
