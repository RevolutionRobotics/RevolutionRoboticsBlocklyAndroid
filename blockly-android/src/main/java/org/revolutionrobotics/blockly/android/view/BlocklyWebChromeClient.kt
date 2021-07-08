package org.revolutionrobotics.blockly.android.view

import android.util.Log
import android.webkit.JsPromptResult
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import org.json.JSONObject
import org.revolutionrobotics.blockly.android.view.dialogHandlers.instances.*
import org.revolutionrobotics.blockly.android.view.result.ConfirmResult

class BlocklyWebChromeClient(
    private val dialogFactory: DialogFactory,
    private val listener: BlocklyLoadedListener
) : WebChromeClient() {

    private var blocklyLoaded = false

    companion object {
        private const val PROGRESS_COMPLETE = 100
    }

    private val promptHandlers = listOf(
        DirectionHandler(),
        MotorOptionSelectorHandler(),
        LightEffectPickerHandler(),
        OptionSelectorHandler(),
        SoundPickerHandler(),
        ColorPickerHandler(),
        SingleDonutSelectorHandler(),
        MultiDonutSelectorHandler(),
        SliderHandler(),
        DialpadHandler(),
        MotorSelectionHandler(),
        UltrasonicSensorSelectionHandler(),
        BumperSelectionHandler(),
        TextInputHandler(),
        BlockOptionsHandler(),
        VariableOptionsHandler()
    )

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
        if (newProgress == PROGRESS_COMPLETE && !blocklyLoaded) {
            blocklyLoaded = true
            listener.onBlocklyLoaded()
        }
    }

    override fun onJsAlert(view: WebView, url: String, message: String?, result: JsResult): Boolean {
        Log.i("NativeBridge::js::alert", message)
        message?.let { dialogFactory.showAlertDialog(it,
            ConfirmResult(result)
        ) }
        return true
    }

    override fun onJsConfirm(view: WebView, url: String, message: String?, result: JsResult): Boolean {
        Log.i("NativeBridge::js::confirm", message)
        message?.let { dialogFactory.showConfirmationDialog(it,
            ConfirmResult(result)
        ) }
        return true
    }

    override fun onJsPrompt(
        view: WebView,
        url: String,
        message: String?,
        defaultValue: String?,
        result: JsPromptResult
    ): Boolean {
        Log.i("NativeBridge::js::prompt", "message='$message', defaultValue='$defaultValue'")
        return if (message != null && message.isNotEmpty()) {
            promptHandlers.find { it.canHandleRequest(message) }?.let { handler ->
                handler.handleRequest(JSONObject(defaultValue), dialogFactory, result)
                true
            } ?: super.onJsPrompt(view, url, message, defaultValue, result)
        } else {
            super.onJsPrompt(view, url, message, defaultValue, result)
        }
    }
}
