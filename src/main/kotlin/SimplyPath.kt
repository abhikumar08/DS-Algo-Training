import java.util.*
//https://leetcode.com/problems/simplify-path/
class SimplyPath {
    fun simplifyPath(path: String): String {
        val stack = Stack<String>()
        val dirs = path.split('/')
        var simplyPath = "/"

        dirs.forEach {
            when (it) {
                ".." -> {
                    if (stack.isNotEmpty()) {
                        var pop = stack.pop()
                        simplyPath = simplyPath.removeSuffix("$pop/")
                    }
                }
                "", "." -> {

                }
                else -> {
                    stack.push(it)
                    simplyPath = "$simplyPath$it/"
                }
            }
        }
        if (simplyPath.length > 1) {
            simplyPath = simplyPath.removeSuffix("/")
        }
        return simplyPath
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(SimplyPath().simplifyPath("/home/"))
            println(SimplyPath().simplifyPath("/../"))
            println(SimplyPath().simplifyPath("/home//foo/"))
            println(SimplyPath().simplifyPath("/a/./b/../../c/"))
            println(SimplyPath().simplifyPath("/a/../../b/../c//.//"))
            println(SimplyPath().simplifyPath("/a//b////c/d//././/.."))
            println(SimplyPath().simplifyPath("///.."))




        }
    }
}