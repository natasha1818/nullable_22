import kotlin.random.Random
import kotlin.text.Typography.copyright
import Post as Post

data class Post(
    val id: Int,
    var ownerId: Int,        //Идентификатор владельца стены, на которой размещена запись
    val fromId: Int,        //Идентификатор автора записи (от чьего имени опубликована запись)
    val date: String = "23/01/2023",        //Время публикации записи в формате
    val text: String = "text",      //Текст записи.
    val friendsOnly: Boolean = false,    //если запись была создана с опцией «Только для друзей»
    val canPin: Boolean = false,    //Информация о том, может ли текущий пользователь закрепить запись
    val canDelete: Boolean = false, //Информация о том, может ли текущий пользователь удалить запись
    val canEdit: Boolean = false, //Информация о том, может ли текущий пользователь редактировать запись
    val isFavorite: Boolean = true, //true, если объект добавлен в закладки у текущего пользователя.
    val comments: Comments,
    val likes: Lakes,
    val repost: Post?  // проверка является данный пост репостом
) {}

object WallService {

    var posts = emptyArray<Post>()
    var lastId = 0
    fun add(post: Post): Post {
        val newIdPost = post.copy(id = lastId + 1)
        repost(newIdPost)
        posts += newIdPost
        lastId++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, id) in posts.withIndex()) {
            if (posts[index].id == post.id) {
                val newPost = posts[index].copy(
                    ownerId = post.ownerId,
                    text = post.text,
                    friendsOnly = post.friendsOnly,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isFavorite = post.isFavorite,
                    comments = post.comments,
                    likes = post.likes
                )
                posts[index] = newPost
                return true
            }
        }
        return false
    }

    fun repost(post: Post): Any {
        if (post.repost == null) {
            return post
        } else {
            var count = post.likes.count
            val newPost = post.copy((count + 100).also { post.likes.count = it })
            return newPost
        }
    }

    fun printPost(id: Int) {
        for ((index, newIdPost) in posts.withIndex()) {
            if (newIdPost.id == id) {
                println(
                    """
      № ${newIdPost.id}
      номер стены ${newIdPost.ownerId}, автор записи ${newIdPost.fromId}
      дата записи: ${newIdPost.date}
     "${newIdPost.text}"
      только для друзей:${newIdPost.friendsOnly}
      закрепить:${newIdPost.canPin}, удалить: ${newIdPost.canDelete}, редактировать: ${newIdPost.canEdit}
      добавить в закладку: ${newIdPost.isFavorite} 
      количество комментариев: ${newIdPost.comments.count}
      количество лайков: ${newIdPost.likes.count}""".trimIndent()
                )
            }
        }
    }
}


fun main() {
    val post = Post(
        0, 6835, 4000, "01/02/2023",
        "Домашняя кошка - социальное животное, обладающее развитым интеллектом и способностями к общению, умеющее испытывать и выражать сложные чувства и эмоции.",
        friendsOnly = true,
        false,
        false,
        false,
        comments = Comments(12),
        likes = Lakes(100),
        repost = null
    )
    val post2 = Post(
        0,
        6987,
        4000,
        "01/02/2023",
        "Размеры тела котов и кошек, в среднем, составляют около 30-60 см в длину и 20-30 см в высоту",
        false,
        false,
        false,
        false,
        comments = Comments(10),
        likes = Lakes(115),
        repost = null
    )
    val post3 = Post(
        0,
        6565,
        5655,
        "01/02/2023",
        "Кошки являются плотоядными животными, представляя собой мелких хищников. ",
        false,
        false,
        false,
        false,
        comments = Comments(28),
        likes = Lakes(3),
        repost = null
    )
    val post4 = Post(
        8,
        65699,
        6565,
        "01/02/2023",
        "Кошки являются самыми распространёнными домашними питомцами в мире",
        true,
        true,
        true,
        true,
        comments = Comments(66),
        likes = Lakes(215),
        repost = null
    )
    val post5 = Post(
        3,
        6565,
        2222,
        "01/02/2023",
        "Ложась на спину, кошки показывают своё доверие к человеку.",
        false,
        true,
        true,
        true,
        comments = Comments(11),
        likes = Lakes(101),
        repost = null
    )
    val repost = Post(
        0,
        6565,
        2222,
        "01/02/2023",
        "Ложась на спину, кошки показывают своё доверие к человеку.",
        false,
        true,
        true,
        true,
        comments = Comments(12),
        likes = Lakes(100),
        repost = post2
    )


    WallService.add(post)
    WallService.add(post2)
    WallService.add(post3)
    WallService.add(repost)
    WallService.printPost(3)
    WallService.update(post5)
    WallService.update(post4)
    WallService.printPost(3)
    WallService.printPost(8)
    WallService.printPost(4)
}