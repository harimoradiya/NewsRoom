package com.example.letchangeui.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import com.example.letchangeui.R
import com.example.letchangeui.data.model.Article
import com.facebook.shimmer.ShimmerFrameLayout

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var newsList = listOf<Article>()

    fun setNewsData(news: List<Article>) {
        this.newsList = news
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(itemView : View)  : RecyclerView.ViewHolder(itemView) {
        val itemTitleText: TextView = itemView.findViewById(R.id.news_title)
        val descriptionText: TextView = itemView.findViewById(R.id.news_description)
        val itemImage : ImageView = itemView.findViewById(R.id.news_image)
         val shimmerContainer: ShimmerFrameLayout = itemView.findViewById(R.id.shimmer_container)


        fun bind(article: Article){

            shimmerContainer.startShimmer()


            itemTitleText.text = article.title
            descriptionText.text = article.description

            itemImage.load(article.urlToImage){
                listener(
                    onSuccess = { _, _ ,->
                            shimmerContainer.stopShimmer()
                        shimmerContainer.hideShimmer()
                    },
                    onError = { _, _, ->

                        shimmerContainer.stopShimmer()
                        shimmerContainer.hideShimmer()
                    }
                )

            }



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       holder.bind(newsList[position])

    }

    override fun getItemCount(): Int {
        return newsList.size
    }


}
