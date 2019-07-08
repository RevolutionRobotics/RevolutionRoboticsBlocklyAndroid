package org.revolutionrobotics.robotcontroller.blocklysdk.view.result

import android.webkit.JsResult

class ConfirmResult(result: JsResult) : BlocklyResult(result) {

    fun confirm() =
        confirmResult()
}
