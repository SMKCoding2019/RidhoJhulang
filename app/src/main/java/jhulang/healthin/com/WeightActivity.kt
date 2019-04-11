package jhulang.healthin.com

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class WeightActivity : AppCompatActivity() {

    var mHeight : EditText? = null
    var mWeight : EditText? = null
    var mResult : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)

        mHeight = findViewById(R.id.height)
        mWeight = findViewById(R.id.weight)
        mResult = findViewById(R.id.result)

    }

    fun calculateBMI(v: View) {
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
