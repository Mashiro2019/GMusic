package cn.govast.vmusic.model.music.play

import cn.govast.vasttools.network.base.BaseApiRsp

data class MusicUrl(
    val code: Int,
    val data: List<Data>
):BaseApiRsp