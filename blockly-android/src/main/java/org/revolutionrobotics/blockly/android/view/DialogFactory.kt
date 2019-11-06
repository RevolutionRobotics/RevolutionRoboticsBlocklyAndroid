package org.revolutionrobotics.blockly.android.view

import org.revolutionrobotics.blockly.android.BlocklyOption
import org.revolutionrobotics.blockly.android.BlocklyVariable
import org.revolutionrobotics.blockly.android.view.result.BlockOptionResult
import org.revolutionrobotics.blockly.android.view.result.ColorResult
import org.revolutionrobotics.blockly.android.view.result.ConfirmResult
import org.revolutionrobotics.blockly.android.view.result.DialpadResult
import org.revolutionrobotics.blockly.android.view.result.DirectionResult
import org.revolutionrobotics.blockly.android.view.result.DonutResult
import org.revolutionrobotics.blockly.android.view.result.OptionResult
import org.revolutionrobotics.blockly.android.view.result.SliderResult
import org.revolutionrobotics.blockly.android.view.result.SoundResult
import org.revolutionrobotics.blockly.android.view.result.TextResult
import org.revolutionrobotics.blockly.android.view.result.VariableResult

@Suppress("ComplexInterface", "TooManyFunctions")
interface DialogFactory {

    fun showAlertDialog(message: String, result: ConfirmResult)
    fun showConfirmationDialog(message: String, result: ConfirmResult)
    fun showDirectionSelectorDialog(defaultValue: String, result: DirectionResult)
    fun showSlider(title: String, maxValue: Int, defaultValue: Int, result: SliderResult)
    fun showDialpad(defaultValue: Double, result: DialpadResult)
    fun showColorPicker(title: String, colors: List<String>, defaultValue: String, result: ColorResult)
    fun showSoundPicker(title: String, defaultValue: String?, result: SoundResult)
    fun showBlockOptionsDialog(title: String, comment: String, result: BlockOptionResult)
    fun showTextInput(title: String, subtitle: String?, defaultValue: String?, result: TextResult)
    fun showMotorSelector(title: String, subtitle: String?, defaultValue: String?, result: TextResult)
    fun showUltrasonicSensorSelector(title: String, subtitle: String?, defaultValue: String?, result: TextResult)
    fun showBumperSelector(title: String, subtitle: String?, defaultValue: String?, result: TextResult)
    fun showDonutSelector(defaultValue: String, isMultiSelection: Boolean, result: DonutResult)

    fun showOptionSelector(
        title: String,
        showLabels: Boolean,
        blocklyOptions: List<BlocklyOption>,
        defaultValue: BlocklyOption?,
        result: OptionResult
    )

    fun showVariableOptionsDialog(
        title: String,
        defaultValue: BlocklyVariable?,
        variables: List<BlocklyVariable>,
        result: VariableResult
    )
}
