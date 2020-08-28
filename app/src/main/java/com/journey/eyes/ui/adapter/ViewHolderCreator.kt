package com.journey.eyes.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.journey.eyes.R

/**
 * @By Journey 2020/8/28
 * @Description
 */
class EmptyViewHolder(view: View) : RecyclerView.ViewHolder(view)

class TextCardViewHeader4ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle4 = view.findViewById<TextView>(R.id.tvTitle4)
    val ivInto4 = view.findViewById<ImageView>(R.id.ivInto4)
}

class TextCardViewHeader5ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle5 = view.findViewById<TextView>(R.id.tvTitle5)
    val tvFollow = view.findViewById<TextView>(R.id.tvFollow)
    val ivInto5 = view.findViewById<ImageView>(R.id.ivInto5)
}

class TextCardViewHeader7ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle7 = view.findViewById<TextView>(R.id.tvTitle7)
    val tvRightText7 = view.findViewById<TextView>(R.id.tvRightText7)
    val ivInto7 = view.findViewById<ImageView>(R.id.ivInto7)
}

class TextCardViewHeader8ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle8 = view.findViewById<TextView>(R.id.tvTitle8)
    val tvRightText8 = view.findViewById<TextView>(R.id.tvRightText8)
    val ivInto8 = view.findViewById<ImageView>(R.id.ivInto8)
}

class TextCardViewFooter2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvFooterRightText2 = view.findViewById<TextView>(R.id.tvFooterRightText2)
    val ivTooterInto2 = view.findViewById<ImageView>(R.id.ivTooterInto2)
}

class TextCardViewFooter3ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvRefresh = view.findViewById<TextView>(R.id.tvRefresh)
    val tvFooterRightText3 = view.findViewById<TextView>(R.id.tvFooterRightText3)
    val ivTooterInto3 = view.findViewById<ImageView>(R.id.ivTooterInto3)
}

//class HorizontalScrollCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//    val bannerViewPager: BannerViewPager<Discovery.ItemX, DiscoveryAdapter.HorizontalScrollCardAdapter.ViewHolder> = view.findViewById(R.id.bannerViewPager)
//}

class SpecialSquareCardCollectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
    val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    val tvRightText = view.findViewById<TextView>(R.id.tvRightText)
    val ivInto = view.findViewById<ImageView>(R.id.ivInto)
}

class ColumnCardListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
    val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    val tvRightText = view.findViewById<TextView>(R.id.tvRightText)
    val ivInto = view.findViewById<ImageView>(R.id.ivInto)
}

class FollowCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivVideo = view.findViewById<ImageView>(R.id.ivVideo)
    val ivAvatar = view.findViewById<ImageView>(R.id.ivAvatar)
    val tvVideoDuration = view.findViewById<TextView>(R.id.tvVideoDuration)
    val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
    val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    val ivShare = view.findViewById<ImageView>(R.id.ivShare)
    val tvLabel = view.findViewById<TextView>(R.id.tvLabel)
    val ivChoiceness = view.findViewById<ImageView>(R.id.ivChoiceness)
}

class Banner3ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivPicture = view.findViewById<ImageView>(R.id.ivPicture)
    val tvLabel = view.findViewById<TextView>(R.id.tvLabel)
    val ivAvatar = view.findViewById<ImageView>(R.id.ivAvatar)
    val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
}

class VideoSmallCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivPicture = view.findViewById<ImageView>(R.id.ivPicture)
    val tvVideoDuration = view.findViewById<TextView>(R.id.tvVideoDuration)
    val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
    val ivShare = view.findViewById<ImageView>(R.id.ivShare)
}

class TagBriefCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivPicture = view.findViewById<ImageView>(R.id.ivPicture)
    val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
    val tvFollow = view.findViewById<TextView>(R.id.tvFollow)
}

class TopicBriefCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivPicture = view.findViewById<ImageView>(R.id.ivPicture)
    val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
}

class InformationCardFollowCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivCover = view.findViewById<ImageView>(R.id.ivCover)
    val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
}

//class AutoPlayVideoAdViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//    val tvLabel = view.findViewById<TextView>(R.id.tvLabel)
//    val ivAvatar = view.findViewById<ImageView>(R.id.ivAvatar)
//    val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
//    val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
//    val videoPlayer: GSYVideoPlayer = view.findViewById(R.id.videoPlayer)
//}

class BannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivPicture = view.findViewById<ImageView>(R.id.ivPicture)
}

class UgcSelectedCardCollectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    val tvRightText = view.findViewById<TextView>(R.id.tvRightText)
    val ivCoverLeft = view.findViewById<ImageView>(R.id.ivCoverLeft)
    val ivLayersLeft = view.findViewById<ImageView>(R.id.ivLayersLeft)
    val ivAvatarLeft = view.findViewById<ImageView>(R.id.ivAvatarLeft)
    val tvNicknameLeft = view.findViewById<TextView>(R.id.tvNicknameLeft)
    val ivCoverRightTop = view.findViewById<ImageView>(R.id.ivCoverRightTop)
    val ivLayersRightTop = view.findViewById<ImageView>(R.id.ivLayersRightTop)
    val ivAvatarRightTop = view.findViewById<ImageView>(R.id.ivAvatarRightTop)
    val tvNicknameRightTop = view.findViewById<TextView>(R.id.tvNicknameRightTop)
    val ivCoverRightBottom = view.findViewById<ImageView>(R.id.ivCoverRightBottom)
    val ivLayersRightBottom = view.findViewById<ImageView>(R.id.ivLayersRightBottom)
    val ivAvatarRightBottom = view.findViewById<ImageView>(R.id.ivAvatarRightBottom)
    val tvNicknameRightBottom = view.findViewById<TextView>(R.id.tvNicknameRightBottom)
}