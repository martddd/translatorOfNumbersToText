import java.util.*

fun main(array: Array<String>, numbersFor: Long){

    val valueNumb: Long = numbersFor

    val numb0_9 = arrayOf("ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
    val str1000_array = arrayOf("тысяч", "миллион", "миллиард", "триллион", "квадриллион", "квинтиллион")
    val str = ArrayList<String>()
    var infoPrint = ""
    var printResult = ""

    var arg = 0
    var str_A = ""
    var str_B = ""

    var i = 0
    var a = 0

    fun numb0_999 (numbers: Int): String {

        val numb_000 = numbers.toInt()
        var result_999 = ""


        when (numb_000) {
            0 -> result_999 = "ноль"
            1 -> result_999 = "один"
            2 -> result_999 = "два"
            3 -> result_999 = "три"
            4 -> result_999 = "четыре"
            5 -> result_999 = "пять"
            6 -> result_999 = "шесть"
            7 -> result_999 = "семь"
            8 -> result_999 = "восемь"
            9 -> result_999 = "девять"

            10 -> result_999 = "десять"
            40 -> result_999 = "сорок"
            20,30,50,60,70,80 -> {
                result_999 = numb0_9[numb_000/10]
                if(numb_000<50){
                    result_999+="дцать"
                }else
                    result_999+="десят"
            }
            90 -> result_999 = "девяносто"

            in 11..19 ->{
                if (numb_000==11){
                    result_999 = numb0_9[1]+"надцать"
                }else if (numb_000==12){
                    result_999 = numb0_9[2].substring(0,numb0_9[2].length-1)+"енадцать"
                }else if (numb_000==14){
                    result_999 = numb0_9[4].substring(0,numb0_9[4].length-1)+"надцать"
                }else if (numb_000==17){
                    result_999 = numb0_9[7].substring(0,numb0_9[7].length-1)+"надцать"
                }else{
                    result_999 = numb0_9[numb_000-10]+"надцать"
                }
            }
            in 21..99 ->{
                result_999 = numb0_999((numb_000/10)*10) + " " + numb0_999(numb_000-(numb_000/10)*10)
            }

            100,200,300,400,500,600, 700, 800, 900 -> {
                if (numb_000==100){
                    result_999 = "сто"
                }else if(numb_000==200){
                    result_999 = "двести"
                }else if(numb_000==500){
                    result_999 = "пятьсот"
                }else if (numb_000>=300 && numb_000<=400){
                    result_999 = numb0_999(numb_000/100)+"ста"
                }else if (numb_000<=900){
                    result_999 = numb0_999(numb_000/100)+"сот"
                }
            }
            in 101..999 ->{
                result_999 = numb0_999((numb_000/100)*100) + " " + numb0_999(numb_000-(numb_000/100)*100)
            }

        }


        //вывод результата
        return result_999
    }

    fun numb1000 (numbers: Long): String{
        var str_000 = ""
        val numbbersReversed = numbers.toString().reversed()


        for (c in numbbersReversed.toString()) {
            str_000 = c +str_000
            if (str_000.length==3){
                str_000 = ""
                a++
            }
        }

        val t = Math.pow(10.0,((a*3).toDouble()))
        val aOld = a
        var k = false

        str_000 = ""

        for (c in numbbersReversed.toString()){

            str_000 = c + str_000
            if (str_000.length==3){

                str.add(str_000)
                str_000 = ""
                a--
            }else {
                if (a==0&&k==false&&(str_000.length==2||str_000.length==1)){

                    str.add((numbers/t.toLong()).toString())
                    k = true
                }
            }
            i++
        }
        infoPrint = "в $numbers \n кол-во троек - $aOld \n кол-во цифр - $i \n{$str}"
        return infoPrint
    }

    numb1000(valueNumb)

    println("\n $infoPrint")

    fun thousand(string: String, arg: Int){
        var ending = ""
        val nmbSravnenie = (str[arg].substring(str[arg].length-1, str[arg].length)).toInt() //последняя цифра тройки
        val nmbSravnenie10_19: Int //2е последниецифры тройки

        if (str[arg].length==1){
            nmbSravnenie10_19 = 0
        }else{
            nmbSravnenie10_19 = (str[arg].substring(str[arg].length-2, str[arg].length)).toInt() //2е последниецифры тройки
        }

        //окончания для тыс-млрд...
        when(string){
            "тысяч"->{
                ending = " "
                if (nmbSravnenie10_19>9&&nmbSravnenie10_19<20){
                    ending = " "
                }else {
                    when (nmbSravnenie){
                        1 -> ending = "а "
                        in 2..4 -> ending = "и "
                        in 5..9,0 -> ending = ""
                    }
                }
            }
            else -> {
                ending = ""
                if (nmbSravnenie10_19>9&&nmbSravnenie10_19<20){
                    ending = "ов "
                }else {
                    when (nmbSravnenie){
                        1 -> ending = " "
                        in 2..4 -> ending = "а "
                        in 5..9,0 -> ending = "ов "
                    }
                }
            }
        }

        if (str[arg].toInt()>9){
            when (str[arg].toInt()){
                in 10..19 ->{
                    str_A = numb0_999(str[arg].toInt())
                    str_B = str1000_array[arg-1]+ending
                }
                20,30,40,50,60,70,80,90,100,200,300,400,500,600,700,800,900 ->{
                    str_A = numb0_999(str[arg].toInt())
                    str_B = str1000_array[arg-1]+ending
                }
                in 22..999 ->{
                    str_A = numb0_999(str[arg].toInt())
                    str_B = str1000_array[arg-1]+ending
                }
            }

        }else{
            when (nmbSravnenie.toInt()){
                1 -> {
                    str_A = numb0_999(str[arg].toInt())
                    str_A = str_A.replaceRange(str_A.length-4,str_A.length,"одн")+ending
                    str_B = str1000_array[arg-1]+ending
                }
                2 -> {
                    str_A = numb0_999(str[arg].toInt())
                    str_A = str_A.replaceRange(str_A.length-3,str_A.length,"два")
                    str_B = str1000_array[arg-1]+ending
                }
                3,4 -> {
                    str_A = numb0_999(str[arg].toInt())
                    str_B = str1000_array[arg-1]+ending+"и"
                }
                in 5..9 -> {
                    str_A = numb0_999(str[arg].toInt())
                    str_B = str1000_array[arg-1]+ending
                }

            }
        }

    }

    //формирование строки
    while (arg < str.size){

        if (arg==0){    //проходит первый раз для того что бы сформировать строку сотин перед тысячей
            printResult = numb0_999(str[arg].toInt()) + printResult
        }else if(arg>0){
            when (str1000_array[arg-1]){
                "тысяч" -> {
                    thousand("тысяч",arg)
                }
                "миллион" -> {
                    thousand("миллион",arg)
                }
                "миллиард" -> {
                    thousand("миллиард",arg )
                }
                "триллион" -> {
                    thousand("триллион",arg)
                }
                "квадриллион" -> {
                    thousand("квадриллион",arg)
                }
                "квинтиллион" -> {
                    thousand("квинтиллион",arg)
                }
            }
        }

        printResult = str_A + " " + str_B + printResult

        println(printResult.length)
        if (printResult.length>6){
            printResult = printResult.replace("ноль", "")
        }

        arg++
    }

    println("\n" + printResult)

}