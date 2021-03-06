package whatsapp_situation.lemonlab.com.whatsapp_situation.data

import android.app.Fragment
import android.app.FragmentManager
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.topic_item.view.*
import whatsapp_situation.lemonlab.com.whatsapp_situation.*

/**
 * Created by HP on 12/09/2018.
 */
class TopicAdapter(var context:Context,var data:ArrayList<String>, var image:ArrayList<Int>, val fragmnetManager:android.support.v4.app.FragmentManager)
    :RecyclerView.Adapter<TopicAdapter.viewHolder>(){
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.getData(data[position], image[position], position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.topic_item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class viewHolder(itemview:View):RecyclerView.ViewHolder(itemview){

        var cuurentItem:String? = null
        var cuurentPosition = 0
        init{
            itemview.setOnClickListener {
                Toast.makeText(context,cuurentItem,Toast.LENGTH_SHORT).show()
                when(cuurentPosition){
                    0 -> {
                        var manager = fragmnetManager.beginTransaction()
                        manager.replace(R.id.fragmentContainer,Fragment01())
                        manager.commit()
                    }
                    1 -> {
                        var manager = fragmnetManager.beginTransaction()
                        manager.replace(R.id.fragmentContainer,UserFragment())
                        manager.commit()
                    }
                }
                if(cuurentItem == "حالات ضحك"){

                }
            }
        }

        fun getData(title:String,Background:Int, pos:Int){
            itemView.topic_textView.text = title
            itemView.topic_imageView.setImageResource(Background)
            cuurentItem = title
            cuurentPosition = pos
        }
    }
}