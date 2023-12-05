//Recursive
import java.util.ArrayList;
import java.util.List;

public class ListFlattener {
    public static List<Integer> flattenRecursive(List<Object> nestedList) {
        List<Integer> flattenedList = new ArrayList<>();
        for (Object element : nestedList) {
            if (element instanceof List<?>) {
                flattenedList.addAll(flattenRecursive((List<Object>) element));
            } else {
                flattenedList.add((Integer) element);
            }
        }
        return flattenedList;
    }

    public static void main(String[] args) {
        List<Object> nestedList = List.of(1, List.of(2, 3), List.of(List.of(List.of(4))));
        List<Integer> flattenedList = flattenRecursive(nestedList);
        System.out.println(flattenedList);
    }
}

//Iterative
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListFlattener {
    public static List<Integer> flattenIterative(List<Object> nestedList) {
        List<Integer> flattenedList = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.addAll(nestedList);

        while (!stack.isEmpty()) {
            Object element = stack.pop();
            if (element instanceof List<?>) {
                stack.addAll((List<Object>) element);
            } else {
                flattenedList.add((Integer) element);
            }
        }

        return flattenedList;
    }

    public static void main(String[] args) {
        List<Object> nestedList = List.of(1, List.of(2, 3), List.of(List.of(List.of(4))));
        List<Integer> flattenedList = flattenIterative(nestedList);
        System.out.println(flattenedList);
    }
}
