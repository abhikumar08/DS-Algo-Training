import kotlin.math.min
//https://leetcode.com/problems/min-stack/
class MinStack {
    val stack: MutableList<Pair<Int, Int>> = mutableListOf()

    fun push(x: Int) {
        if (stack.isEmpty()) {
            stack.add(Pair(x, x))
        } else {
            var minVal = stack.last().second
            if (x < minVal) {
                minVal = x;
            }
            stack.add(Pair(x, minVal))
        }
    }

    fun pop() {
        if (stack.isNotEmpty()) {
            stack.removeAt(stack.size - 1)
        }
    }

    fun top(): Int {
        return stack.last().first
    }

    fun getMin(): Int {
        return stack.last().second
    }

}