class PersistentStackNode {
    int value;
    PersistentStackNode prev;

    public PersistentStackNode(int value, PersistentStackNode prev) {
        this.value = value;
        this.prev = prev;
    }
}

public class PersistentStack {
    private PersistentStackNode current;  // The current version of the stack

    public PersistentStack() {
        this.current = null;
    }

    public void push(int value) {
        // Create a new node and make it the current version
        this.current = new PersistentStackNode(value, this.current);
    }

    public void pop() {
        if (this.current != null) {
            // Move to the previous version
            this.current = this.current.prev;
        }
    }

    public Integer top() {
        return (this.current != null) ? this.current.value : null;
    }

    public void display() {
        PersistentStackNode node = this.current;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PersistentStack stack = new PersistentStack();

        // Version 1
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Display Version 1
        System.out.println("Version 1:");
        stack.display();

        // Version 2
        stack.pop();

        // Display Version 2
        System.out.println("Version 2:");
        stack.display();

        // Version 3
        stack.push(4);

        // Display Version 3
        System.out.println("Version 3:");
        stack.display();

        // Display current version
        System.out.println("Current Version:");
        System.out.println("Top: " + stack.top());
        stack.display();
    }
}
