package jhulang.healthin.com.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import jhulang.healthin.com.R

class WeightFragment : Fragment() {

    var mHeight : EditText? = null
    var mWeight : EditText? = null
    var mResult : TextView? = null
    var mButton : Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_weight, container, false)

        mHeight = view.findViewById(R.id.height)
        mWeight = view.findViewById(R.id.weight)
        mResult = view.findViewById(R.id.result)
        mButton = view.findViewById(R.id.calc)



        calculateBMI(view)

        return view

    }


    fun calculateBMI (v: View) {
        val heightStr = mHeight!!.text.toString()
        val weightStr = mWeight!!.text.toString()

        if ("" != heightStr && "" != weightStr) {
            val heightValue = java.lang.Float.parseFloat(heightStr) / 100
            val weightValue = java.lang.Float.parseFloat(weightStr)

            val bmi = weightValue / (heightValue * heightValue)

            displayBMI(bmi)
    }
}
    private fun displayBMI(bmi: Float) {
        var bmiLabel = ""

        if (java.lang.Float.compare(bmi, 17f) <= 0) {
            bmiLabel = getString(R.string.kurussekali)
        } else if (java.lang.Float.compare(bmi, 17f) > 0 && java.lang.Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.kurus)
        } else if (java.lang.Float.compare(bmi, 18.5f) > 0 && java.lang.Float.compare(bmi, 25.0f) <= 0) {
            bmiLabel = getString(R.string.normal)
        } else if (java.lang.Float.compare(bmi, 25f) > 0 && java.lang.Float.compare(bmi, 27f) <= 0) {
            bmiLabel = getString(R.string.gemuk)
        } else if (java.lang.Float.compare(bmi, 27f) > 0 && java.lang.Float.compare(bmi, 27f) >= 0) {
            bmiLabel = getString(R.string.gemuksekali)
        }

        bmiLabel = bmi.toString() + "\n\n" + bmiLabel
        mResult!!.text = bmiLabel
    }
}
