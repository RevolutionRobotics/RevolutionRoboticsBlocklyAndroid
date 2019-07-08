package org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.robotcontroller.blocklysdk.view.DialogFactory
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.colors
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.defaultKey
import org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers.title
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.ColorResult

class ColorPickerHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message.contains("colour_picker.colour")

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showColorPicker(request.title(), request.colors(), request.defaultKey(), ColorResult(result))
    }
}
