package calculator.controller

import calculator.model.Calculator
import calculator.view.InputView
import calculator.view.OutputView

class CalculatorController {
    private val calculator = Calculator()

    fun run() {
        try {
            // 1. 입력 받기
            val input = InputView.getExpression()

            // 2. 계산 수행
            val result = calculator.add(input)

            // 3. 결과 출력
            OutputView.displayResult(result)
        } catch (e: Exception) {
            // 4. 에러 출력
            //OutputView.displayError(e.message ?: "An unknown error occurred.")
        }
    }
}
