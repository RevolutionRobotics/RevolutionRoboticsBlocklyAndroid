package org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.robotcontroller.blocklysdk.view.DialogFactory
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.defaultKey
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.DirectionResult

class DirectionHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message == "block_drive.direction_selector"

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showDirectionSelectorDialog(request.defaultKey(), DirectionResult(result))
    }
}
