package org.revolutionrobotics.blockly.android.view

import android.webkit.JsPromptResult
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import org.json.JSONObject
import org.revolutionrobotics.blockly.android.view.dialogHandlers.instances.BlockOptionsHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.instances.ColorPickerHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.instances.DialpadHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.instances.DirectionHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.instances.MotorOptionSelectorHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.instances.MultiDonutSelectorHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.instances.OptionSelectorHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.instances.SingleDonutSelectorHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.instances.SliderHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.instances.SoundPickerHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.instances.TextInputHandler
import org.revolutionrobotics.blockly.android.view.dialogHandlers.instances.VariableOptionsHandler
import org.revolutionrobotics.blockly.android.view.result.ConfirmResult

class BlocklyWebChromeClient(
    private val dialogFactory: DialogFactory,
    private val listener: BlocklyLoadedListener
) : WebChromeClient() {

    companion object {
        private const val PROGRESS_COMPLETE = 100
    }

    private val promptHandlers = listOf(
        DirectionHandler(),
        MotorOptionSelectorHandler(),
        OptionSelectorHandler(),
        SoundPickerHandler(),
        ColorPickerHandler(),
        SingleDonutSelectorHandler(),
        MultiDonutSelectorHandler(),
        SliderHandler(),
        DialpadHandler(),
        TextInputHandler(),
        BlockOptionsHandler(),
        VariableOptionsHandler()
    )

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
        if (newProgress == PROGRESS_COMPLETE) {
            listener.onBlocklyLoaded()
        }
    }

    override fun onJsAlert(view: WebView, url: String, message: String?, result: JsResult): Boolean {
        message?.let { dialogFactory.showAlertDialog(it,
            ConfirmResult(result)
        ) }
        return true
    }

    override fun onJsConfirm(view: WebView, url: String, message: String?, result: JsResult): Boolean {
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
    ) =
        if (message != null && message.isNotEmpty()) {
            promptHandlers.find { it.canHandleRequest(message) }?.let { handler ->
                handler.handleRequest(JSONObject(defaultValue), dialogFactory, result)
                true
            } ?: super.onJsPrompt(view, url, message, defaultValue, result)
        } else {
            super.onJsPrompt(view, url, message, defaultValue, result)
        }
}
