package org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.robotcontroller.blocklysdk.view.DialogFactory
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.defaultValue
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.maxValue
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.title
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.SliderResult

class SliderHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message.contains("_slider")

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showSlider(
            request.title(),
            request.maxValue(),
            request.defaultValue("0").toInt(),
            SliderResult(result)
        )
    }
}
