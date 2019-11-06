package org.revolutionrobotics.blockly.android.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.blockly.android.view.DialogFactory
import org.revolutionrobotics.blockly.android.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.defaultInput
import org.revolutionrobotics.blockly.android.view.dialogHandlers.subtitle
import org.revolutionrobotics.blockly.android.view.dialogHandlers.title
import org.revolutionrobotics.blockly.android.view.result.TextResult

class UltrasonicSensorSelectionHandler  : JsPromptHandler {

    override fun canHandleRequest(message: String) = message == "block_ultrasonic_sensor.name_input"

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showUltrasonicSensorSelector(request.title(), request.subtitle(), request.defaultInput(),
            TextResult(result)
        )
    }
}