package calculator.controller

import calculator.model.Calculator
import calculator.view.InputView
import calculator.view.OutputView

// Controller를 사용하는 이유: 프로그램의 흐름을 관리하고 책임을 분리하기 위함
// 프로그램의 입력, 로직 처리, 출력의 전체 흐름을 관리함
// 로직과 출력이 섞이는 것을 방지하여 코드의 가독성과 유지보수성을 높임
class CalculatorController {
    private val calculator = Calculator()
    fun run() {
        // 주로 프로그램의 흐름은 입력 -> 처리 -> 출력의 형태로 진행된다.

        // todo: 사용자로부터 입력받기 => InputView 사용
        val input = InputView.getExpression()

        // todo: 입력받은 값으로 계산하기
        //val result=

        // todo: 결과 출력하기 => OutputView사용
        //val output = OutputView.displayResult(result)
    }
}