 interface Attachment {
   val type:String
       get() = " "
 }
 data class Photo(
     val width: Int,  // максимальная ширина изображения
     val height: Int,  //максимальная высота изображения
     val idAlbum: Int,     //номер альбома
     val date: String,    //дата добавления
 )
data class PhotoAttachment( val photo: Photo): Attachment{
    override val type: String = "Photo"
}
data class Video(
    val title: String, //Наименование записи
    val duration: Int,//длительность записи
    val ownerId:Int, // ID владельца записи
)
data class VideoAttachment(val video: Video):Attachment{
     override val type: String = "Video"
 }
 data class Audio(
     val artist:String, // исполнитель
     val title: String, //Наименование записи
     val duration: Int,//длительность записи
     val ownerId:Int, // ID владельца записи
 )
data class AudioAttachment(val audio: Audio): Attachment{
    override val type: String = "audio"
 }
data class Link(
     val url: String,  // URL  ссылки
     val title: String, //заголовок ссылки
     val description: String, //описание ссылки
     val ownerId:Int, // ID кто добавил ссылку
 )
 data class LinkAttachment( val link: Link):Attachment{
     override val type: String = "link"
 }
data class Graffiti(
     val id: Int, //идентификатор граффити
     val url: String, //адрес по которому можно загрузить граффити
     val ownerId:Int, // ID владельца граффити
 )
 class GraffitiAttachment( val graffiti: Graffiti): Attachment{
     override val type: String = "graffiti"
 }