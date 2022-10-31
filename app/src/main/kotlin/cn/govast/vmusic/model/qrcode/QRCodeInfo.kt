/*
 * Copyright 2022 Vast Gui guihy2019@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.govast.vmusic.model.qrcode

import cn.govast.vasttools.network.base.BaseApiRsp

data class QRCodeInfo(
    val code: Int,
    val data: QRCodeData
): BaseApiRsp {
    override fun isEmpty(): Boolean {
        return data.qrimg == "" // 图片的base64码为空
    }
}

data class QRCodeData(
    val qrimg: String,
    val qrurl: String
)