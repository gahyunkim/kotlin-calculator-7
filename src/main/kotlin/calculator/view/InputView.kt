package calculator.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getExpression(): String {
        println("덧셈할 문자열을 입력해 주세요.")
        return Console.readLine()
    }
}
