package com.test.pfbtest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.pfbtest.model.DBModel
import java.util.ArrayList

/**
 * Created by Yogesh Y. Nikam on 05/02/21.
 */
class DataAdapter(data: ArrayList<DBModel>) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    var dataList: ArrayList<DBModel> = data


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataAdapter.DataViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return DataViewHolder(v)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: DataAdapter.DataViewHolder,
        position: Int
    ) {
        holder.tv_id?.setText(dataList.get(position).id)
        holder.tv_pub_date?.setText(dataList.get(position).pdate)
        holder.article_type_tv?.setText(dataList.get(position).article_type)
        holder.indexTV?.setText(position.toString())

    }

    class DataViewHolder(v : View) : RecyclerView.ViewHolder(v) {

        var article_type_tv: TextView? = null
        var tv_pub_date: TextView? = null
        var tv_id : TextView? = null
        var indexTV : TextView? = null


        init {
            article_type_tv = v.findViewById(R.id.article_type_tv)
            tv_id = v.findViewById(R.id.tv_id)
            tv_pub_date = v.findViewById(R.id.publication_date_tv)
            indexTV = v.findViewById(R.id.indexTV)

        }
    }

}