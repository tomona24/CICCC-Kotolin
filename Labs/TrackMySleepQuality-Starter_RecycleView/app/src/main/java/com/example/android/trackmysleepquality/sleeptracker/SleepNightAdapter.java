package com.example.android.trackmysleepquality.sleeptracker;

//import android.recyclerview.widget.RecyclerView;
//import android.view.ViewGroup;

class SleepNightAdapter: RecyclerView.Adapter<TextItemViewHolder>() {
    val data = listOf<SleepNight>()
        set(value) {
        field = value
        // re-render the whole list (tableView.reloadData())
        notifyDataSetChanged()
        }

    override fun onCreateViewHolder(){
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
        }
        override fun onBindViewHolder{
         val item = data[position]
        holder.textView.text = item.sleepQuality.toString()
        }

        override fun getItemCounte(): Int {
        return data. size
        }

}
