package com.journey.eyes.ui.adapter.holder

import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.journey.eyes.model.core.HomePageRecommend
import com.journey.eyes.ui.adapter.*
import com.journey.eyes.utils.ext.*
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

/**
 * @By Journey 2020/8/28
 * @Description
 */
class AppAdapter(val context: Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var  mDta:List<HomePageRecommend.Item> = emptyList()
    fun setData(data:List<HomePageRecommend.Item>) {
        this.mDta = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=ViewHolderTypeFilter.getViewHolder(parent,viewType)
    override fun getItemViewType(position: Int)=ViewHolderTypeFilter.getItemViewType(mDta[position])
    override fun getItemCount()=mDta.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mDta[position]
        when(holder) {
            is TextCardViewHeader5ViewHolder -> {
                holder.tvTitle5.text = item.data.text
                if (item.data.actionUrl != null) holder.ivInto5.visible() else holder.ivInto5.gone()
                if (item.data.follow != null) holder.tvFollow.visible() else holder.tvFollow.gone()
//                holder.tvFollow.setOnClickListener { LoginActivity.start(fragment.activity) }
//                setOnClickListener(holder.tvTitle5, holder.ivInto5) { ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.text) }
            }
            is TextCardViewHeader7ViewHolder -> {
                holder.tvTitle7.text = item.data.text
                holder.tvRightText7.text = item.data.rightText
//                setOnClickListener(holder.tvRightText7, holder.ivInto7) {
//                    ActionUrlUtil.process(fragment, item.data.actionUrl, "${item.data.text},${item.data.rightText}")
//                }
            }
            is TextCardViewHeader8ViewHolder -> {
                holder.tvTitle8.text = item.data.text
                holder.tvRightText8.text = item.data.rightText
//                setOnClickListener(holder.tvRightText8, holder.ivInto8) { ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.text) }
            }
            is TextCardViewFooter2ViewHolder -> {
                holder.tvFooterRightText2.text = item.data.text
//                setOnClickListener(holder.tvFooterRightText2, holder.ivTooterInto2) { ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.text) }
            }
            is TextCardViewFooter3ViewHolder -> {
                holder.tvFooterRightText3.text = item.data.text
//                setOnClickListener(holder.tvRefresh, holder.tvFooterRightText3, holder.ivTooterInto3) {
//                    if (this == holder.tvRefresh) {
//                        "${holder.tvRefresh.text},${GlobalUtil.getString(R.string.currently_not_supported)}".showToast()
//                    } else if (this == holder.tvFooterRightText3 || this == holder.ivTooterInto3) {
//                        ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.text)
//                    }
//                }
            }
            is FollowCardViewHolder -> {
                holder.ivVideo.load(item.data.content.data.cover.feed, 4f)
                holder.ivAvatar.load(item.data.header.icon)
                holder.tvVideoDuration.text = item.data.content.data.duration.conversionVideoDuration()
                holder.tvDescription.text = item.data.header.description
                holder.tvTitle.text = item.data.header.title
                if (item.data.content.data.ad) holder.tvLabel.visible() else holder.tvLabel.gone()
//                if (item.data.content.data.library == DailyAdapter.DAILY_LIBRARY_TYPE) holder.ivChoiceness.visible() else holder.ivChoiceness.gone()
//                holder.ivShare.setOnClickListener { showDialogShare(fragment.activity, "${item.data.content.data.title}：${item.data.content.data.webUrl.raw}") }
//                holder.itemView.setOnClickListener {
//                    item.data.content.data.run {
//                        if (ad || author == null) {
//                            NewDetailActivity.start(fragment.activity, id)
//                        } else {
//                            NewDetailActivity.start(
//                                fragment.activity, NewDetailActivity.VideoInfo(id, playUrl, title, description, category, library, consumption, cover, author, webUrl)
//                            )
//                        }
//                    }
//                }
            }
            is BannerViewHolder -> {
                holder.ivPicture.load(item.data.image, 4f)
//                holder.itemView.setOnClickListener { ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.title) }
            }
            is Banner3ViewHolder -> {
                holder.ivPicture.load(item.data.image, 4f)
                holder.ivAvatar.load(item.data.header.icon)
                holder.tvTitle.text = item.data.header.title
                holder.tvDescription.text = item.data.header.description
                if (item.data.label?.text.isNullOrEmpty()) holder.tvLabel.invisible() else holder.tvLabel.visible()
                holder.tvLabel.text = item.data.label?.text ?: ""
//                holder.itemView.setOnClickListener { ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.header.title) }
            }
            is InformationCardFollowCardViewHolder -> {
                holder.ivCover.load(item.data.backgroundImage, 4f, RoundedCornersTransformation.CornerType.TOP)
                holder.recyclerView.setHasFixedSize(true)
                if (holder.recyclerView.itemDecorationCount == 0) {
                    holder.recyclerView.addItemDecoration(InformationCardFollowCardItemDecoration())
                }
                holder.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
//                holder.recyclerView.adapter = InformationCardFollowCardAdapter(fragment.activity, item.data.actionUrl, item.data.titleList)
//                holder.itemView.setOnClickListener { ActionUrlUtil.process(fragment, item.data.actionUrl) }
            }
        }
    }

    class InformationCardFollowCardItemDecoration : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            val position = parent.getChildAdapterPosition(view) // item position
            val count = parent.adapter?.itemCount //item count
            count?.run {
                when (position) {
                    0 -> {
                        outRect.top = 18f.dp2px()
                    }
                    count.minus(1) -> {
                        outRect.top = 13f.dp2px()
                        outRect.bottom = 18f.dp2px()
                    }
                    else -> {
                        outRect.top = 13f.dp2px()
                    }
                }
            }
        }
    }
}