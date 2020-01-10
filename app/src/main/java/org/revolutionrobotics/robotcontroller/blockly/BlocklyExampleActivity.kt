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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.beginner -> {
                blocklyView?.changeToolbox("level1")
                true
            }
            R.id.intermediate -> {
                blocklyView?.changeToolbox("level2")
                true
            }
            R.id.advanced -> {
                blocklyView?.changeToolbox("level3")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        toastDialogFactory = null
        super.onDestroy()
    }
}