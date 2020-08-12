package mm.com.fairway.examplerecyclerview_onclick.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_data_show.*
import kotlinx.android.synthetic.main.item_layout.*
import mm.com.fairway.examplerecyclerview_onclick.R

class DataShowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var dataItem= arguments?.let {
            DataShowFragmentArgs.fromBundle(it)
        }
        var data=dataItem?.dataItem
        showtxt.text=data.toString();
    }
}