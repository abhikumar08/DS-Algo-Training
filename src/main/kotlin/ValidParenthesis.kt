import java.util.*

//https://leetcode.com/problems/valid-parentheses/

class ValidParenthesis {
    fun checkValidString(s: String): Boolean {
        val stack: Stack<Char> = Stack()
        s.map {
            when (it) {
                '(', '{', '[' -> {
                    stack.push('(');
                }
                ')' -> {
                    if (stack.isNotEmpty() && stack.peek() == '(')
                        stack.pop()
                    else
                        return false
                }
                ']' -> {
                    if (stack.peek() == '[')
                        stack.pop()
                    else
                        return false
                }
                '}' -> {
                    if (stack.peek() == '{')
                        stack.pop()
                    else
                        return false
                }
                else -> {

                }
            }
        }
        return stack.isEmpty()
    }
}