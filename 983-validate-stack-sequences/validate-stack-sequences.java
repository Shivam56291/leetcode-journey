// class Solution {
//     public boolean validateStackSequences(int[] pushed, int[] popped) {
//         Stack<Integer> stack = new Stack();
//         int j = 0;

//         for (int i = 0; i < pushed.length; i++) {
//             stack.push(pushed[i]);
//             while (!stack.isEmpty() && stack.peek() == popped[j]) {
//                 stack.pop();
//                 j++;
//             }
//         }

//         return stack.isEmpty();
//     }
// }

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int top = 0;
        int j = 0;

        for (int num : pushed) {
            pushed[top++] = num;

            while (top > 0 && j < popped.length && pushed[top - 1] == popped[j]) {
                top--;
                j++;
            }
        }

        return j == popped.length;
    }
}