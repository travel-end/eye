package com.journey.eyes.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.journey.eyes.R
import com.journey.eyes.model.core.HomePageRecommend
import com.journey.eyes.utils.ext.inflate

/**
 * @By Journey 2020/8/28
 * @Description
 */
object ViewHolderTypeFilter {
    const val UNKNOWN = -1
    const val text_card = "textCard"
    const val TEXT_CARD_HEADER4 = 4
    const val TEXT_CARD_HEADER5 = 5
    const val TEXT_CARD_HEADER7 = 7
    const val TEXT_CARD_HEADER8 = 8
    const val TEXT_CARD_FOOTER2 = 10
    const val TEXT_CARD_FOOTER3 = 11
    const val BANNER = 12               //type:banner -> dataType:Banner
    const val BANNER3 = 13              //type:banner3-> dataType:Banner
    const val FOLLOW_CARD = 14          //type:followCard -> dataType:FollowCard -> type:video -> dataType:VideoBeanForClient
    const val TAG_BRIEFCARD = 15        //type:briefCard -> dataType:TagBriefCard
    const val TOPIC_BRIEFCARD = 16      //type:briefCard -> dataType:TopicBriefCard
    const val COLUMN_CARD_LIST = 17      //type:columnCardList -> dataType:ItemCollection
    const val VIDEO_SMALL_CARD = 18     //type:videoSmallCard -> dataType:VideoBeanForClient
    const val INFORMATION_CARD = 19     //type:informationCard -> dataType:InformationCard
    const val AUTO_PLAY_VIDEO_AD = 20   //type:autoPlayVideoAd -> dataType:AutoPlayVideoAdDetail
    const val HORIZONTAL_SCROLL_CARD = 21    //type:horizontalScrollCard -> dataType:HorizontalScrollCard
    const val SPECIAL_SQUARE_CARD_COLLECTION = 22   //type:specialSquareCardCollection -> dataType:ItemCollection
    const val UGC_SELECTED_CARD_COLLECTION = 23   //type:ugcSelectedCardCollection -> dataType:ItemCollection
    const val MAX = 100   //避免外部其他类型与此处包含的某个类型重复。

    fun getItemViewType(item:HomePageRecommend.Item):Int {
        return if (text_card == item.type) {
            getTextViewType(item.data.type)
        } else {
            var type = item.type
            type = type ?: ""
            var dataType = item.data.type
            dataType = dataType?: ""
            getSubItemViewType(type,dataType)
        }
    }

    fun getViewHolder(parent:ViewGroup,viewType:Int):RecyclerView.ViewHolder {
        return when(viewType) {
            TEXT_CARD_HEADER4 -> TextCardViewHeader4ViewHolder(R.layout.item_text_card_type_header_four.inflate(parent))
            TEXT_CARD_HEADER5 -> TextCardViewHeader5ViewHolder(R.layout.item_text_card_type_header_five.inflate(parent))
            TEXT_CARD_HEADER7 -> TextCardViewHeader7ViewHolder(R.layout.item_text_card_type_header_seven.inflate(parent))
            TEXT_CARD_HEADER8 -> TextCardViewHeader8ViewHolder(R.layout.item_text_card_type_header_eight.inflate(parent))
            TEXT_CARD_FOOTER2 -> TextCardViewFooter2ViewHolder(R.layout.item_text_card_type_footer_two.inflate(parent))
            TEXT_CARD_FOOTER3 -> TextCardViewFooter3ViewHolder(R.layout.item_text_card_type_footer_three.inflate(parent))
//            HORIZONTAL_SCROLL_CARD -> HorizontalScrollCardViewHolder(R.layout.item_horizontal_scroll_card_type.inflate(parent))
            SPECIAL_SQUARE_CARD_COLLECTION -> SpecialSquareCardCollectionViewHolder(R.layout.item_special_square_card_collection_type.inflate(parent))
//            COLUMN_CARD_LIST -> ColumnCardListViewHolder(R.layout.item_column_card_list_type.inflate(parent))
//            BANNER -> BannerViewHolder(R.layout.item_banner_type.inflate(parent))
//            BANNER3 -> Banner3ViewHolder(R.layout.item_banner_three_type.inflate(parent))
//            VIDEO_SMALL_CARD -> VideoSmallCardViewHolder(R.layout.item_video_small_card_type.inflate(parent))
//            TAG_BRIEFCARD -> TagBriefCardViewHolder(R.layout.item_brief_card_tag_brief_card_type.inflate(parent))
//            TOPIC_BRIEFCARD -> TopicBriefCardViewHolder(R.layout.item_brief_card_topic_brief_card_type.inflate(parent))
            FOLLOW_CARD -> FollowCardViewHolder(R.layout.item_follow_card_type.inflate(parent))
            INFORMATION_CARD -> InformationCardFollowCardViewHolder(R.layout.item_information_card_type.inflate(parent))
            UGC_SELECTED_CARD_COLLECTION -> UgcSelectedCardCollectionViewHolder(R.layout.item_ugc_selected_card_collection_type.inflate(parent))
//            AUTO_PLAY_VIDEO_AD -> AutoPlayVideoAdViewHolder(R.layout.item_auto_play_video_ad.inflate(parent))
            else -> EmptyViewHolder(View(parent.context))
        }

    }



    /**********************************分割线*********************************/
    // 获取文字标题viewType
    private fun getTextViewType(type:String):Int {
        return when(type) {
            "header4" -> TEXT_CARD_HEADER4
            "header5" -> TEXT_CARD_HEADER5
            "header7" -> TEXT_CARD_HEADER7
            "header8" -> TEXT_CARD_HEADER8
            "footer2" -> TEXT_CARD_FOOTER2
            "footer3" -> TEXT_CARD_FOOTER3
            else -> UNKNOWN
        }
    }

    private fun getSubItemViewType(type: String, dataType: String):Int {
        return when(type) {
            "horizontalScrollCard" -> {
                when (dataType) {
                    "HorizontalScrollCard" -> HORIZONTAL_SCROLL_CARD
                    else -> UNKNOWN
                }
            }
            "specialSquareCardCollection" -> {
                when (dataType) {
                    "ItemCollection" -> SPECIAL_SQUARE_CARD_COLLECTION
                    else -> UNKNOWN
                }
            }
            "columnCardList" -> {
                when (dataType) {
                    "ItemCollection" -> COLUMN_CARD_LIST
                    else -> UNKNOWN
                }
            }
            "banner" -> {
                when (dataType) {
                    "Banner" -> BANNER
                    else -> UNKNOWN
                }
            }
            "banner3" -> {
                when (dataType) {
                    "Banner" -> BANNER3
                    else -> UNKNOWN
                }
            }
            "videoSmallCard" -> {
                when (dataType) {
                    "VideoBeanForClient" -> VIDEO_SMALL_CARD
                    else -> UNKNOWN
                }
            }
            "briefCard" -> {
                when (dataType) {
                    "TagBriefCard" -> TAG_BRIEFCARD
                    "TopicBriefCard" -> TOPIC_BRIEFCARD
                    else -> UNKNOWN
                }
            }
            "followCard" -> {
                when (dataType) {
                    "FollowCard" -> FOLLOW_CARD
                    else -> UNKNOWN
                }
            }
            "informationCard" -> {
                when (dataType) {
                    "InformationCard" -> INFORMATION_CARD
                    else -> UNKNOWN
                }
            }
            "ugcSelectedCardCollection" -> {
                when (dataType) {
                    "ItemCollection" -> UGC_SELECTED_CARD_COLLECTION
                    else -> UNKNOWN
                }
            }
            "autoPlayVideoAd" -> {
                when (dataType) {
                    "AutoPlayVideoAdDetail" -> AUTO_PLAY_VIDEO_AD
                    else -> UNKNOWN
                }
            }
            else -> UNKNOWN
        }
    }
}