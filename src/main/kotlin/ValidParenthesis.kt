import java.util.*

class ValidParenthesis {
    fun checkValidString(s: String): Boolean {
        val stack: Stack<String> = Stack()
        s.map {
            if (it == '(') {
                stack.push("(");
            } else if (it == ')') {
                if (!stack.isEmpty()){
                    stack.pop()
                }else {
                    return false
                }
            }else{
                ""
            }
        }
        return stack.isEmpty()
    }
}