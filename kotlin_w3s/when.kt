fun main(){
    print("nhập thứ(1-8): ")
    var day = readLine()?.toIntOrNull()
    val result = when(day){
        2 -> "t2"
        3 -> "t3"
        4 -> "t4"
        5 -> "t5"
        6 -> "t6"
        7 -> "t7"
        1,8 -> "cn"
        else -> "nhap lai"
    }
    print(result)
}