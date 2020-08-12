package mm.com.fairway.examplerecyclerview_onclick.fragment

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import mm.com.fairway.examplerecyclerview_onclick.R
import mm.com.fairway.examplerecyclerview_onclick.adapter.HomeAdapter
import mm.com.fairway.examplerecyclerview_onclick.model.DataItem

class HomeFragment : Fragment(),HomeAdapter.ClickListner {
    lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var dataItemList = ArrayList<DataItem>()
        dataItemList.add(DataItem("APPle"))
        dataItemList.add(DataItem("Orange"))
        dataItemList.add(DataItem("Grape"))
        dataItemList.add(DataItem("Lemon"))
        dataItemList.add(DataItem("Banana"))
        dataItemList.add(DataItem("Watermelon"))
        homeAdapter = HomeAdapter(dataItemList)
        homeAdapter.setOnClickListener(this)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }

    }
    override fun OnClick(dataItem: DataItem) {
var data=dataItem
var action= HomeFragmentDirections.actionHomeFragmentToDataShowFragment(data.name)
        findNavController().navigate(action)
       // var action= OneFragmentDirections.actionOneFragmentToTwoFragment("Message From One")// to give data to two Fragment
      //  findNavController().navigate(action)//
//        findNavController().navigate(
//            R.id.action_homeFragment_to_dataShowFragment
//        )
    }
}