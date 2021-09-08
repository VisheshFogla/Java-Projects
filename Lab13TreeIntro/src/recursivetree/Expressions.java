/**
 * 
 */
package recursivetree;

/**
 * @author Vishesh
 * @version 04.26.2020.
 *
 */
public class Expressions {

    private static BinaryTree<String> bt;
    private static BinaryTree<String> bt2;
    private static BinaryTree<String> bt3;
    private static BinaryTree<String> bt4;

    private static BinaryTree<String> child1;
    private static BinaryTree<String> child2;
    private static BinaryTree<String> child3;
    private static BinaryTree<String> child5;
    private static BinaryTree<String> child4;

    /**
     * 
     * The method creates the given binary tree.
     * 
     * @param args
     *            takes the arguments for binary tree nodes.
     */
    public static void main(String[] args) {

        child1 = new BinaryTree<>("a");
        child2 = new BinaryTree<>("b");
        child3 = new BinaryTree<>("c");
        child4 = new BinaryTree<>("d");
        child5 = new BinaryTree<>("e");

        bt4 = new BinaryTree<>("+", child3, child4);

        bt2 = new BinaryTree<>("-", child1, child2);
        bt3 = new BinaryTree<>("/", bt4, child5);

        bt = new BinaryTree<>("*", bt2, bt3);

        System.out.println(bt.toInOrderString());
    }

}
