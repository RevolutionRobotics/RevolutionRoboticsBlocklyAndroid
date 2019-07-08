package org.revolutionrobotics.robotcontroller.blocklysdk.view.dialogHandlers

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.robotcontroller.blocklysdk.view.DialogFactory

interface JsPromptHandler {
    fun canHandleRequest(message: String): Boolean
    fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult)
}
