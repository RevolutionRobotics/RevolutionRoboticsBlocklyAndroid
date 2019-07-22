package org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.robotcontroller.blocklysdk.view.DialogFactory
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.defaultOption
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.options
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.title
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.OptionResult

class MotorOptionSelectorHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) =
        message == "block_motor.direction_selector" ||
                message == "spin_motor.direction_selector"

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showOptionSelector(
            request.title(),
            false,
            request.options(),
            request.defaultOption(),
            OptionResult(result)
        )
    }
}