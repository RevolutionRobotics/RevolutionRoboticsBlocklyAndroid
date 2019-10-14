package org.revolutionrobotics.blockly.android.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.blockly.android.view.DialogFactory
import org.revolutionrobotics.blockly.android.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.defaultKey
import org.revolutionrobotics.blockly.android.view.result.DirectionResult

class DirectionHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message == "block_drive.direction_selector"

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showDirectionSelectorDialog(request.defaultKey(),
            DirectionResult(result)
        )
    }
}
