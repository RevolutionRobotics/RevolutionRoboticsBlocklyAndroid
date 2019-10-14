package org.revolutionrobotics.blockly.android.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.blockly.android.view.DialogFactory
import org.revolutionrobotics.blockly.android.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.defaultValue
import org.revolutionrobotics.blockly.android.view.dialogHandlers.maxValue
import org.revolutionrobotics.blockly.android.view.dialogHandlers.title
import org.revolutionrobotics.blockly.android.view.result.SliderResult

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
