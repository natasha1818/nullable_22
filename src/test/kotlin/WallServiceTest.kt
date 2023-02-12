import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class WallServiceTest {
    @Test
    fun add() {
        val service = WallService
        service.add(Post(0,4000,1255,"12/01/2023","text",false,false,false,false, comments = Comments(12), likes = Lakes(100),repost = null))
        service.add(Post(0,4022,1215,"12/01/2023","text",false,false,false,false,comments = Comments(12), likes = Lakes(100),repost = null))
        service.add(Post(0,4018,1375,"12/01/2023","text",false,false,false,false,comments = Comments(12), likes = Lakes(100),repost = null))
        val result = service.posts[1].id
        assertNotEquals(0, result)
    }
    @Test
    fun updateTrue() {
        val service = WallService
        service.add(Post(0,4000,1255,"12/01/2023","text",false,false,false,false,comments = Comments(12), likes = Lakes(100),repost = null))
        service.add(Post(0,4022,1215,"12/01/2023","text",false,false,false,false,comments = Comments(12), likes = Lakes(100),repost = null))
        service.add(Post(0,4018,1375,"12/01/2023","text",false,false,false,false,comments = Comments(12), likes = Lakes(100),repost = null))

        val update = Post(2,4000,1255,"22/02/2022","text",true,true,false,false,comments = Comments(12), likes = Lakes(100),repost = null)
        val result = service.update(update)

        assertTrue(result)
    }
    @Test
    fun updateFalse() {
        val service = WallService
        service.add(Post(0,4000,1255,"12/01/2023","text",false,false,false,false,comments = Comments(12), likes = Lakes(100),repost = null))
        service.add(Post(0,4022,1215,"12/01/2023","text",false,false,false,false,comments = Comments(12), likes = Lakes(100),repost = null))
        service.add(Post(0,4018,1375,"12/01/2023","text",false,false,false,false,comments = Comments(12), likes = Lakes(100),repost = null))

        val update = Post(200,4000,1255,"22/02/2022","text",true,true,false,false,comments = Comments(12), likes = Lakes(100),repost = null)
        val result = service.update(update)

        assertFalse(result)
    }
}