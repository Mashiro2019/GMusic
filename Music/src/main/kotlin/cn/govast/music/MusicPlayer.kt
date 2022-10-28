package cn.govast.music

import android.content.ContentUris
import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import java.io.IOException

// Author: Vast Gui
// Email: guihy2019@gmail.com
// Date: 2022/10/29
// Description: 
// Documentation:
// Reference:

class MusicPlayer(private val mContext:Context) {

    /**
     * @see MediaPlayer
     */
    private val mediaPlayer by lazy {
        MediaPlayer()
    }

    /**
     * 是否在播放
     * @return Boolean
     */
    fun isPlaying() = mediaPlayer.isPlaying

    /**
     * 根据 [uriString] 播放音乐
     *
     * @param uriString
     */
    fun playMusic(uriString:String){
        //重置多媒体播放器
        mediaPlayer.reset()
        //设置新的播放路径
        try {
            mediaPlayer.apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                setDataSource(mContext, Uri.parse(uriString))
            }
            playMusic()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /** 暂停音乐的函数 */
    fun pauseMusic() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }


    /** 播放音乐的函数 */
    fun playMusic() {
        if (!mediaPlayer.isPlaying) {
            if (mediaPlayer.currentPosition == 0) {
                try {
                    mediaPlayer.prepare()
                    mediaPlayer.start()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            } else {
                //从暂停到播放
                mediaPlayer.seekTo(mediaPlayer.currentPosition)
                mediaPlayer.start()
            }
        }
    }
}