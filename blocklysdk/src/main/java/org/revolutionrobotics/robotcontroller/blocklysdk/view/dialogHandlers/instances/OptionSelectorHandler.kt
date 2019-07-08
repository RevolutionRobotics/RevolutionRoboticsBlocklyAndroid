package org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.robotcontroller.blocklysdk.view.DialogFactory
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.defaultOption
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.options
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.title
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.OptionResult

class OptionSelectorHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) =
        message.endsWith("_selector") ||
                message.endsWith("logic_boolean.bool") ||
                message.endsWith("logic_compare.op")

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showOptionSelector(
            request.title(),
            request.options(),
            request.defaultOption(),
            OptionResult(result)
        )
    }
}
