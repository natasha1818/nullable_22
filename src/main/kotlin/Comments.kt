data class Comments (
    val count: Int,       //количество комментариев
    val canPost:Boolean = false,    //может ли текущий пользователь комментировать запись
    val groupsCanPost: Boolean = false, //могут ли сообщества комментировать запись
    val canClose: Boolean = false, //может ли текущий пользователь закрыть комментарии к записи
    val canOpen: Boolean = false //может ли текущий пользователь открыть комментарии к записи
        ){ }