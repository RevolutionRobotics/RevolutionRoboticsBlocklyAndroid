package org.revolutionrobotics.robotcontroller.blockly

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import org.revolutionrobotics.blockly.android.view.BlocklyView

class BlocklyExampleActivity : Activity() {

    private var toastDialogFactory: ToastDialogFactory? = null
    var blocklyView: BlocklyView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        blocklyView = BlocklyView(this)
        toastDialogFactory = ToastDialogFactory(this).apply {
            blocklyView?.init(this)
            setContentView(blocklyView)
        }
    }

    override fun onDestroy() {
        toastDialogFactory = null
        super.onDestroy()
    }
}