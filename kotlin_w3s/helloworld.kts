    var name = "dat"; // var thay doi dc gia tri
    val birthday = 2001; // val khong thay doi duoc gia tri
    println(name);
    println(birthday);
    name ="hoang dat";
    println(name);
    var fname ="le";
    println(fname + " "+ name); 
    val myNum1 = 35E3F // f ép kiểu float
    val myNum2 = 12E4 // mac định double
    val myNum3 = 124 // mac định int
    println(myNum1)
    println(myNum2)
    println(myNum3.toString() +myNum3::class) // in tên type 
    var fullname = fname + name;
    println("fullname co " + fullname.length + " ki tu");
    println(fullname.uppercase());
    println(fullname.lowercase());
    println(fname.plus(name)); // nối chuỗi thay +
    println("toi là $fullname");