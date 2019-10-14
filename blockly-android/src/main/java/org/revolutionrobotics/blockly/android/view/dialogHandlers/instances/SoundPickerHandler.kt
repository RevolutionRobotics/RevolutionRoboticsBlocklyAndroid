package org.revolutionrobotics.blockly.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.blockly.view.DialogFactory
import org.revolutionrobotics.blockly.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.blockly.view.dialogHandlers.defaultKey
import org.revolutionrobotics.blockly.view.dialogHandlers.title
import org.revolutionrobotics.blockly.view.result.SoundResult

class SoundPickerHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message == "play_tune.in_sound"

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showSoundPicker(request.title(), request.defaultKey(),
            SoundResult(result)
        )
    }
}
