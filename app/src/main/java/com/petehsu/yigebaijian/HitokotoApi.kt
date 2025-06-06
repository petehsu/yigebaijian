package com.petehsu.yigebaijian

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL
import kotlin.random.Random

data class Hitokoto(
    val id: Int,
    val hitokoto: String,
    val from: String,
    val fromWho: String?
)

object HitokotoApi {
    private val API_URLS = listOf(
        "https://v1.hitokoto.cn/",
        "https://international.v1.hitokoto.cn/",
        "https://api.maho.cc/yiyan/",
        "https://api.uixsj.cn/hitokoto/get"
    )
    
    suspend fun getRandomHitokoto(): Hitokoto = withContext(Dispatchers.IO) {
        val shuffledUrls = API_URLS.shuffled()
        var lastError: Exception? = null
        
        for (apiUrl in shuffledUrls) {
            try {
                return@withContext when {
                    apiUrl.contains("hitokoto.cn") -> fetchFromHitokotoCn(apiUrl)
                    apiUrl.contains("maho.cc") -> fetchFromMahoCc(apiUrl)
                    apiUrl.contains("uixsj.cn") -> fetchFromUixsj(apiUrl)
                    else -> fetchFromHitokotoCn(apiUrl) // 默认使用 hitokoto.cn 的解析方式
                }
            } catch (e: Exception) {
                lastError = e
                continue
            }
        }
        
        // 如果所有API都失败了，抛出最后一个错误
        throw lastError ?: IllegalStateException("所有API接口都无法访问")
    }
    
    private suspend fun fetchFromHitokotoCn(apiUrl: String): Hitokoto {
        val response = URL(apiUrl).readText()
        val json = JSONObject(response)
        
        return Hitokoto(
            id = json.optInt("id", Random.nextInt()),
            hitokoto = json.getString("hitokoto"),
            from = json.getString("from"),
            fromWho = if (json.has("from_who") && !json.isNull("from_who")) 
                json.getString("from_who") 
            else null
        )
    }
    
    private suspend fun fetchFromMahoCc(apiUrl: String): Hitokoto {
        val response = URL(apiUrl).readText()
        return Hitokoto(
            id = Random.nextInt(),
            hitokoto = response.trim(),
            from = "一言",
            fromWho = null
        )
    }
    
    private suspend fun fetchFromUixsj(apiUrl: String): Hitokoto {
        val response = URL(apiUrl).readText()
        return Hitokoto(
            id = Random.nextInt(),
            hitokoto = response.trim(),
            from = "一言",
            fromWho = null
        )
    }
} 