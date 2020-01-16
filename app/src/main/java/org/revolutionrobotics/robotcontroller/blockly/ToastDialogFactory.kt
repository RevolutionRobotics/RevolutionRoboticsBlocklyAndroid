package org.revolutionrobotics.robotcontroller.blockly

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.text.InputType
import android.widget.Toast
import org.revolutionrobotics.blockly.android.BlocklyOption
import org.revolutionrobotics.blockly.android.BlocklyVariable
import org.revolutionrobotics.blockly.android.view.DialogFactory
import org.revolutionrobotics.blockly.android.view.result.*
import android.widget.LinearLayout
import android.widget.EditText
import android.widget.SeekBar


class ToastDialogFactory(private val context: Context) : DialogFactory {

    override fun showAlertDialog(message: String, result: ConfirmResult) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage(message)
            .setPositiveButton(android.R.string.ok
            ) { dialog, id ->
                // FIRE ZE MISSILES!
            }
        builder.create().show()
    }

    override fun showConfirmationDialog(message: String, result: ConfirmResult) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage(message)
            .setPositiveButton(android.R.string.ok
            ) { dialog, id ->
                result.confirm()
            }
        builder.create().show()
    }

    override fun showDirectionSelectorDialog(defaultValue: String, result: DirectionResult) {
        showList("Select direction", listOf(
            BlocklyOption("Motor.DIRECTION_FWD", "forward"),
            BlocklyOption("Motor.DIRECTION_BACK", "backward")
        ) , result)
    }

    override fun showSlider(title: String, maxValue: Int, defaultValue: Int, result: SliderResult) {
        val input = SeekBar(context)
        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        input.layoutParams = lp
        input.max = maxValue
        input.progress = defaultValue
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
            .setView(input)
            .setPositiveButton(android.R.string.ok
            ) { dialog, id ->
                result.confirm(input.progress)
            }
        builder.create().show()
    }

    override fun showDialpad(defaultValue: Double, result: DialpadResult) {
        showInput("Dialpad", defaultValue, result)
    }

    override fun showColorPicker(title: String, colors: List<String>, defaultValue: String, result: ColorResult) {
        showList(title, listOf("red", "green", "blue"), result)
    }

    override fun showLightEffectPicker(
        title: String,
        defaultValue: String?,
        result: LightEffectResult
    ) {
        showList(title, listOf("siren", "rainbow", "traffic"), result)
    }

    override fun showSoundPicker(title: String, defaultValue: String?, result: SoundResult) {
        showList(title, listOf("siren", "ta-da", "oh-no"), result)
    }

    override fun showBlockOptionsDialog(title: String, comment: String, result: BlockOptionResult) {
        showToastMessage("Show blockly options dialog! Title: $title comment: $comment")
        result.confirmComment("Comment")
    }

    override fun showTextInput(title: String, subtitle: String?, defaultValue: String?, result: TextResult) {
        showInput(title, defaultValue ?: "", result)
    }

    override fun showMotorSelector(title: String, subtitle: String?, defaultValue: String?, result: TextResult) {
        showInput(title, defaultValue ?: "", result)
    }

    override fun showUltrasonicSensorSelector(title: String, subtitle: String?, defaultValue: String?, result: TextResult) {
        showInput(title, defaultValue ?: "", result)
    }

    override fun showBumperSelector(title: String, subtitle: String?, defaultValue: String?, result: TextResult) {
        showInput(title, defaultValue ?: "", result)
    }

    override fun showDonutSelector(defaultValue: String, isMultiSelection: Boolean, result: DonutResult) {
        showList("Select led", (1..12).map { BlocklyOption(it.toString(), it.toString()) }, result)
    }

    override fun showOptionSelector(
        title: String,
        showLabels: Boolean,
        blocklyOptions: List<BlocklyOption>,
        defaultValue: BlocklyOption?,
        result: OptionResult

    ) {
        showList(title, blocklyOptions, result)
    }

    override fun showVariableOptionsDialog(
        title: String,
        defaultValue: BlocklyVariable?,
        variables: List<BlocklyVariable>,
        result: VariableResult
    ) {
        showToastMessage("Sow variable options! Title: $title Default: $defaultValue Variables: $variables")
        result.confirmChangeVariable(variables.first())
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun showList(title: String, items: List<BlocklyOption>, result: OptionResult) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
            .setItems(items.map { option -> option.value }.toTypedArray()
            ) { dialog, which ->
                result.confirm(items[which])
            }
        builder.create().show()
    }

    private fun showList(title: String, items: List<BlocklyOption>, result: DonutResult) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
            .setItems(items.map { option -> option.value }.toTypedArray()
            ) { dialog, which ->
                result.confirm(which + 1)
            }
        builder.create().show()
    }

    private fun showList(title: String, items: List<BlocklyOption>, result: DirectionResult) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
            .setItems(items.map { option -> option.value }.toTypedArray()
            ) { dialog, which ->
                when(which) {
                    0 -> result.confirmForward()
                    1 -> result.confirmBackward()
                }
            }
        builder.create().show()
    }

    private fun showList(title: String, items: List<String>, result: LightEffectResult) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
            .setItems(items.toTypedArray()
            ) { dialog, which ->
                result.confirm(items[which])
            }
        builder.create().show()
    }

    private fun showList(title: String, items: List<String>, result: SoundResult) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
            .setItems(items.toTypedArray()
            ) { dialog, which ->
                result.confirm(items[which])
            }
        builder.create().show()
    }

    private fun showList(title: String, items: List<String>, result: ColorResult) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
            .setItems(items.toTypedArray()
            ) { dialog, which ->
                result.confirm(items[which])
            }
        builder.create().show()
    }

    private fun showInput(title: String, defaultValue: String, result: TextResult) {
        val input = EditText(context)
        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        input.layoutParams = lp
        input.setText(defaultValue)
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
            .setView(input)
            .setPositiveButton(android.R.string.ok
            ) { dialog, id ->
                result.confirm(input.text.toString())
            }
        builder.create().show()
    }

    private fun showInput(title: String, defaultValue: Double, result: DialpadResult) {
        val input = EditText(context)
        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        input.layoutParams = lp
        input.inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL
        input.setText(defaultValue.toString())
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
            .setView(input)
            .setPositiveButton(android.R.string.ok
            ) { dialog, id ->
                result.confirm(input.text.toString().toDouble())
            }
        builder.create().show()
    }
}