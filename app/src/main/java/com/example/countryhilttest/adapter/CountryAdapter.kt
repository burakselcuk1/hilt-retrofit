package com.example.countryhilttest.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countryhilttest.R
import com.example.countryhilttest.model.Country


class CountryAdapter(private var dataSet: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val textViewiki: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.name)
            textViewiki = view.findViewById(R.id.region)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position].name
        viewHolder.textViewiki.text = dataSet[position].region

        Log.e("BRK:MAİNVİEWMODEL","name: ${dataSet[position].name}]")


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    fun setData(data: ArrayList<Country>){
        data.addAll(data)
    }
}
