package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentA = FragmentA()

        findViewById<Button>(R.id.open_fragment_a).setOnClickListener {
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragmentA)
                    .addToBackStack(null)
                    .commit()
                it.visibility = View.GONE
            }
        }
        findViewById<Button>(R.id.open_fragment_b).setOnClickListener{
            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (fragmentA.childFragmentManager.backStackEntryCount > 0) {
                    fragmentA.childFragmentManager.popBackStack()
                } else {
                    finish()
                }
            }
        })
    }
}