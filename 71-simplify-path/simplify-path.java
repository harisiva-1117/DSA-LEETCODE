class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] dirs = path.split("/");

        for (String dir : dirs) {

            if (dir.equals("") || dir.equals(".")) {
                continue;
            }

            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();

        for (String dir : stack) {
            ans.append("/").append(dir);
        }

        return ans.toString();
    }
}