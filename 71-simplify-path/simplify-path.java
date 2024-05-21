class Solution {
    public String simplifyPath(String path) {

// Using Stack :
       // Step 1: Split the input path by '/'
        String[] components = path.split("/");
        
        // Step 2: Initialize an empty stack to store valid directory names
        Stack<String> stack = new Stack<>();
        
        // Step 3: Process each component of the path
        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) {
                // If the component is empty or '.', just skip it
                continue;
            } else if (component.equals("..")) {
                // If the component is '..', go to the parent directory (pop from stack if not empty)
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Otherwise, it's a valid directory name, push it onto the stack
                stack.push(component);
            }
        }
        
        // Step 4: Join the components in the stack with '/' to form the simplified path
        // Use StringBuilder to efficiently build the resulting path
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }
        
        // If the stack is empty, the simplified path should be "/"
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    

    }
}




// Using Deque :
/*
 Deque<String> deque = new ArrayDeque<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (!component.isEmpty() && !component.equals(".")) {
                deque.addLast(component);
            }
        }

        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : deque) {
            simplifiedPath.append("/").append(dir);
        }

        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }
}
*/

