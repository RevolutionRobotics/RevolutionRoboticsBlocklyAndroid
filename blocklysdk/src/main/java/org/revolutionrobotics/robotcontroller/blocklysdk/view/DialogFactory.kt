package org.revolutionrobotics.robotcontroller.blocklysdk.view

import org.revolutionrobotics.robotcontroller.blocklysdk.BlocklyOption
import org.revolutionrobotics.robotcontroller.blocklysdk.BlocklyVariable
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.BlockOptionResult
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.ColorResult
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.ConfirmResult
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.DialpadResult
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.DirectionResult
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.DonutResult
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.OptionResult
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.SliderResult
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.SoundResult
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.TextResult
import org.revolutionrobotics.robotcontroller.blocklysdk.view.result.VariableResult

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
    fun showDonutSelector(defaultValue: String, isMultiSelection: Boolean, result: DonutResult)

    fun showOptionSelector(
        title: String,
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
