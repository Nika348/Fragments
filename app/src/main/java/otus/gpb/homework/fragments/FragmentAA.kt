package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentAA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_aa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val color = arguments?.getInt("color") ?: 0

        view.findViewById<View>(R.id.fragmentAA).setBackgroundColor(color)

        val generatedColor = ColorGenerator.generateColor()
        view.findViewById<Button>(R.id.open_fragment_ab).setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_aa_container, FragmentAB.newInstance(generatedColor))
                .addToBackStack(null)
                .commit()
            it.visibility = View.GONE
        }
    }

    companion object {
        fun newInstance(color: Int) : FragmentAA {
            return FragmentAA().apply {
                arguments = Bundle().apply {
                    putInt("color", color)
                }
            }
        }
    }
}