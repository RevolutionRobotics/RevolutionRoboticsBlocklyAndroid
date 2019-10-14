package org.revolutionrobotics.blockly.android.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.blockly.android.view.DialogFactory
import org.revolutionrobotics.blockly.android.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.colors
import org.revolutionrobotics.blockly.android.view.dialogHandlers.defaultKey
import org.revolutionrobotics.blockly.android.view.dialogHandlers.title
import org.revolutionrobotics.blockly.android.view.result.ColorResult

class ColorPickerHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message.contains("colour_picker.colour")

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showColorPicker(request.title(), request.colors(), request.defaultKey(),
            ColorResult(result)
        )
    }
}
