package com.oxxy.cryptotracker.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oxxy.cryptotracker.R
import com.oxxy.cryptotracker.model.CryptoModel


class RecyclerAdapter(private val cryptoList: ArrayList<CryptoModel>, private val listener: Listener) : RecyclerView.Adapter<RecyclerAdapter.RowHolder>() {

    interface Listener{
        fun onItemClick(cryptoModel: CryptoModel)
    }

private val colors : Array<String> = arrayOf("#FF75FA","#60A9FF","#3AC3FF","#FFC726","#57E722","#D331FF","#A4822F","#1AB6B2")

    class RowHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(cryptoModel : CryptoModel,colors : Array<String>,position: Int, listener: Listener){

            val textCurrency = itemView.findViewById<TextView>(R.id.text_name)
            textCurrency.text = cryptoModel.currency
            val textPrice = itemView.findViewById<TextView>(R.id.text_price)
            textPrice.text = cryptoModel.price
            val linearLayout = itemView.findViewById<LinearLayout>(R.id.recycler_row_layout)
            linearLayout.setBackgroundColor(Color.parseColor(colors[position % 8]))
            linearLayout.setOnClickListener{
                listener.onItemClick(cryptoModel)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return RowHolder(view)
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position], colors, position, listener)
    }
}