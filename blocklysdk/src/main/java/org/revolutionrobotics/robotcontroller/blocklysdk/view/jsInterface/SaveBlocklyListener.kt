package org.revolutionrobotics.robotcontroller.blocklysdk.view.jsInterface

interface SaveBlocklyListener {

    fun onPythonProgramSaved(file: String)

    fun onXMLProgramSaved(file: String)

    fun onVariablesExported(variables: String)
}
