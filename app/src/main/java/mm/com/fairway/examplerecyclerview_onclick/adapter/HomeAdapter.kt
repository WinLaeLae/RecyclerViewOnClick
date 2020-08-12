package mm.com.fairway.examplerecyclerview_onclick.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*
import mm.com.fairway.examplerecyclerview_onclick.R
import mm.com.fairway.examplerecyclerview_onclick.fragment.HomeFragment
import mm.com.fairway.examplerecyclerview_onclick.model.DataItem

class HomeAdapter(var dataitemList:ArrayList<DataItem>):RecyclerView.Adapter<HomeAdapter.HaomeViewHolder>() {
   var mclickListner:ClickListner? = null
    fun setOnClickListener(clikListener: ClickListner){
       this.mclickListner = clikListener
   }

  inner  class HaomeViewHolder(itemview:View):RecyclerView.ViewHolder(itemview),View.OnClickListener{
       lateinit var  dataItem: DataItem
      init {
          itemview.setOnClickListener (this)
      }
        fun bind(dataItem: DataItem){
            this.dataItem=dataItem
            itemView.txtName.text=dataItem.name
        }

        override fun onClick(v: View?) {
            mclickListner?.OnClick(dataItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HaomeViewHolder {
        return HaomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return dataitemList.size
    }

    override fun onBindViewHolder(holder: HaomeViewHolder, position: Int) {
       holder.bind(dataitemList[position])
    }
    interface  ClickListner{
        fun OnClick(dataItem: DataItem)
    }
}