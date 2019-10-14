package org.revolutionrobotics.blockly.android.view.dialogHandlers

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.blockly.android.view.DialogFactory

interface JsPromptHandler {
    fun canHandleRequest(message: String): Boolean
    fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult)
}
