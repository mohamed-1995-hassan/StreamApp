import com.google.gson.annotations.SerializedName




data class Json4Kotlin_Base (

	@SerializedName("kind") val kind : String,
	@SerializedName("etag") val etag : String,
	@SerializedName("items") val items : List<Items>,
	@SerializedName("nextPageToken") val nextPageToken : String,
	@SerializedName("pageInfo") val pageInfo : PageInfo
)