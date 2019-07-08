package org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.robotcontroller.blocklysdk.view.DialogFactory
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.defaultInput
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.DialpadResult

class DialpadHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message.endsWith("math_number.num")

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showDialpad(request.defaultInput("0").toDouble(), DialpadResult(result))
    }
}
