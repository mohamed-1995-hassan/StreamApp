import com.google.gson.annotations.SerializedName



data class ContentDetails (

	@SerializedName("duration") val duration : String,
	@SerializedName("dimension") val dimension : String,
	@SerializedName("definition") val definition : String,
	@SerializedName("caption") val caption : Boolean,
	@SerializedName("licensedContent") val licensedContent : Boolean,
	@SerializedName("contentRating") val contentRating : ContentRating,
	@SerializedName("projection") val projection : String
)