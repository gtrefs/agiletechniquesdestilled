package de.gtrefs


val binaryTree: Tree<Int> = Node(Leaf(1), Node(Leaf(2), Leaf(3)))

fun sum(tree: Tree<Int>): Int = fold(tree, 0, {a, b -> a + b }, {a, b -> a + b})


fun <A, B> map(tree: Tree<A>, mapper: (A) -> B): Tree<B> = when(tree){
    is Leaf -> Leaf(mapper(tree.value))
    is Node -> Node(map(tree.left, mapper), map(tree.right, mapper))
}

fun <A, R> fold(tree: Tree<A>, initial: R, f: (acc: R, A) -> R, g: (R, R) -> R): R {
    fun doAction(tree: Tree<A>, acc: R): R = when(tree){
        is Leaf -> f(acc, tree.value)
        is Node -> g(doAction(tree.left, acc), doAction(tree.right, acc))
    }
    return doAction(tree, initial)
}

sealed class Tree<A>
data class Node<A>(val left: Tree<A>, val right: Tree<A>): Tree<A>()
data class Leaf<A>(val value: A) : Tree<A>()

fun main() {
    println(sum(binaryTree))
    println(map(binaryTree){ (it + 96).toChar() })

}