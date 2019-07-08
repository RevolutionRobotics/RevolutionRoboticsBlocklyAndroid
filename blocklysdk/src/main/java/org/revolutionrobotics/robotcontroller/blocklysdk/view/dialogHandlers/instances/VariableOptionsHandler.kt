package org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.robotcontroller.blocklysdk.view.DialogFactory
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.defaultKey
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.title
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.variables
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.VariableResult

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
