package org.revolutionrobotics.blockly.android.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.blockly.android.view.DialogFactory
import org.revolutionrobotics.blockly.android.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.comment
import org.revolutionrobotics.blockly.android.view.dialogHandlers.title
import org.revolutionrobotics.blockly.android.view.result.BlockOptionResult

class BlockOptionsHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message == "block_context"

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showBlockOptionsDialog(request.title(), request.comment(),
            BlockOptionResult(result)
        )
    }
}
