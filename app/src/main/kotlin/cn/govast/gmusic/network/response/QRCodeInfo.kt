package cn.govast.gmusic.network.response

import cn.govast.vasttools.base.BaseApiRsp

data class QRCodeInfo(
    val code: Int,
    val data: QRCodeData
):BaseApiRsp{
    override fun isEmpty(): Boolean {
        return data.qrimg == "" // 图片的base64码为空
    }
}

data class QRCodeData(
    val qrimg: String,
    val qrurl: String
)