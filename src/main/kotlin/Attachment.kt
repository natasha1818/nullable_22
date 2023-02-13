 interface Attachment {
   val type:String
       get() = " "
 }
 class Photo(
     val width: Int,  // максимальная ширина изображения
     val height: Int,  //максимальная высота изображения
 ){}
class PhotoAttachment(
    val idAlbum: Int,     //номер альбома
    val date: String,    //дата добавления
    val photo: Photo,
    override val type: String = "photo"
): Attachment{}
class Video(
    val title: String, //Наименование записи
    val duration: Int,//длительность записи
){}
 class VideoAttachment(
     val ownerId:Int, // ID владельца записи
      val video: Video,
     override val type: String = "video"
 ):Attachment{}
 class Audio(
     val artist:String, // исполнитель
     val title: String, //Наименование записи
     val duration: Int,//длительность записи
 ){}
 class AudioAttachment(
     val ownerId:Int, // ID владельца записи
     val audio: Audio,
     override val type: String = "audio"
 ): Attachment{}
 class Link(
     val url: String,  // URL  ссылки
     val title: String, //заголовок ссылки
     val description: String, //описание ссылки
 ){}
 class LinkAttachment(
     val link: Link,
     val ownerId:Int, // ID кто добавил ссылку
     override val type: String = "link"
 ):Attachment{}
 class Graffiti(
     val id: Int, //идентификатор граффити
     val url: String, //адрес по которому можно загрузить граффити
 ){}
 class GraffitiAttachment(
     val ownerId:Int, // ID владельца граффити
    val graffiti: Graffiti,
     override val type: String = "graffiti"
 ): Attachment{}