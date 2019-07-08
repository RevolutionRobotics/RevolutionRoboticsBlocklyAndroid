package org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.robotcontroller.blocklysdk.view.DialogFactory
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.defaultInput
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.DonutResult

class MultiDonutSelectorHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message.startsWith("block_set_multiple_led")

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showDonutSelector(request.defaultInput(), true, DonutResult(result))
    }
}
