fun highOrderFunc(a: Int, validityCheckFunc: (a: Int) -> Boolean) {//(1)
    if (validityCheckFunc(a)) {//(2)
        println("a $a is Valid")
    } else {
        println("a $a is Invalid")
    }
}


enum class Gender {
    MAN, WOMAN
}

fun getCheckBasedOnGender(gender: Gender,weight:Int, validation: (Int) -> Boolean) {
    if(validation(weight)) {
        println("The weight is valid for $gender")
    } else {
        println("The weight is not valid for $gender")
    }
}

fun Int.isEven() = this.mod(2) == 0
fun main() {
    getCheckBasedOnGender(Gender.MAN, 100) { weight: Int ->
        weight > 200
    }

    getCheckBasedOnGender(Gender.WOMAN,200) { weight: Int ->
        weight > 100
    }
    highOrderFunc(12) { a: Int -> a.isEven() }//(3)
    highOrderFunc(19) { a: Int -> a.isEven() }
}