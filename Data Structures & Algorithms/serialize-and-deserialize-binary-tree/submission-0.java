public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";

        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                s.append("null ");
            } else {
                s.append(curr.val).append(" ");
                q.add(curr.left);
                q.add(curr.right);
            }
        }

        return s.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;

        String[] l = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(l[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (!l[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(l[i]));
                q.add(curr.left);
            }
            i++;

            if (!l[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(l[i]));
                q.add(curr.right);
            }
            i++;
        }

        return root;
    }
}
